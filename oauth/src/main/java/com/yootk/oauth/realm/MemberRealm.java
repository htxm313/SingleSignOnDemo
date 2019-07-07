package com.yootk.oauth.realm;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yootk.oauth.service.IOAuthService;
import com.yootk.service.IMemberService;
import com.yootk.service.IRoleAndActionService;
import com.yootk.vo.Member;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

// 此处不使用扫描配置，通过bean配置文件的模式来完成
public class MemberRealm extends AuthorizingRealm {
    @Autowired
    private IOAuthService oAuthService ;
    @Reference
    private IRoleAndActionService memberPrivilegeService ;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("【1】｛MemberRealm｝============== 用户认证处理 ==============");
        String mid = (String) token.getPrincipal() ;
        Member member = this.oAuthService.getMember(mid) ; // 根据mid查询用户信息
        if (member == null) {   // 用户信息不存在
            throw new UnknownAccountException(mid + "账户信息不存在！") ;
        }
        if (member.getLocked().equals(1)) { // 用户锁定了
            throw new LockedAccountException(mid + "账户已经被锁定！");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(),member.getPassword(),this.getName());
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.err.println("【2】｛MemberRealm｝************** 用户授权处理 **************");
        Map<String, Object> map = this.memberPrivilegeService.get((String) principals.getPrimaryPrincipal());
        // 将所有获取的授权信息保存在AuthorizationInfo类的实例之中
        SimpleAuthorizationInfo authz = new SimpleAuthorizationInfo() ; // 返回的授权信息
        authz.setRoles((Set<String>)map.get("allRoles"));
        authz.setStringPermissions((Set<String>)map.get("allActions"));
        return authz;
    }
}
