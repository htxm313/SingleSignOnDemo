package com.yootk.oauth.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yootk.oauth.service.IOAuthService;
import com.yootk.service.IClientService;
import com.yootk.vo.Client;
import org.springframework.stereotype.Service;

@Service("oauthService")
public class OAuthServiceImpl implements IOAuthService {
    @Reference
    private IClientService clientService ;
    @Override
    public Client get(String mid) {
        return this.clientService.get(mid);
    }
}
