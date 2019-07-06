package com.yootk.client.dao;

import com.yootk.vo.Client;

public interface IClientDAO {
    // 根据用户编号获取信息
    public Client findById(String cid) ;
}
