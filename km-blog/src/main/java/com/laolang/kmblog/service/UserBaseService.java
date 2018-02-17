package com.laolang.kmblog.service;

import com.laolang.kmblog.domain.UserBase;
import com.laolang.kmblog.mapper.UserBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBaseService {

    @Autowired
    private UserBaseMapper userBaseMapper;

    public UserBase find( Long id ){
        return userBaseMapper.selectByPrimaryKey(id);
    }
}
