package com.yootk.ssm.action;

import com.yootk.ssm.service.IDeptService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonAction {
    @RequestMapping("/logoutInfo")
    public String logout() {
        return "logout_info" ;
    }
    @RequestMapping("/login")
    public String login() {
        return "login" ;
    }
//    @RequestMapping("/noauthz")
//    public String noauthz() {
//        return "plugins/noauthz" ;
//    }
    @Autowired
    private IDeptService deptService ;
    @RequestMapping("/pages/welcome")
    public String welcome() {
        this.deptService.list();
        return "welcome" ;
    }
}
