package com.yootk.test;

import com.yootk.client.dao.IClientDAO;
import com.yootk.service.IClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath:META-INF/spring/spring-base.xml",
        "classpath:META-INF/spring/spring-mybatis.xml",
        "classpath:META-INF/spring/spring-transaction.xml",
        "classpath:META-INF/spring/spring-cache.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class Client_TestClentService {
    @Autowired
    public IClientService clientService ;

    @Autowired
    public IClientDAO clientDAO ;

    @Test

    public void testGet() {
        System.out.println("111");
        System.out.println(this.clientDAO.findById("client000111"));
        System.out.println("***********");
        System.out.println(this.clientService.get("client000111"));
    }
}
