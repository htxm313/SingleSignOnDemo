package com.yootk.ssm.service.impl;

import com.yootk.ssm.service.IDeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements IDeptService {
    @Override
    public void list() {
        System.out.println("*********** (部门列表) ***********");
    }
}
