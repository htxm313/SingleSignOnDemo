package com.yootk.client.service.impl;


import com.yootk.client.dao.IClientDAO;
import com.yootk.service.IClientService;
import com.yootk.vo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientDAO clientDAO ;

    @Override
    public Client get(String clientId) {
        System.err.println("方法进入测试*********************");

        return this.clientDAO.findById(clientId);
    }
}
