package com.laolang.kmblog.service;

import com.laolang.kmblog.domain.UserBase;
import com.laolang.kmblog.exception.KmblogServiceNotFoundException;
import com.laolang.kmblog.mapper.UserBaseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBaseService {

    private static final Logger log = LoggerFactory.getLogger(UserBaseService.class);

    @Autowired
    private UserBaseMapper userBaseMapper;

    public UserBase find( Long id ){
        return userBaseMapper.selectByPrimaryKey(id);
    }

    public UserBase findByPhone( String phone ) throws KmblogServiceNotFoundException {
        List<UserBase> userBases = userBaseMapper.selectByPhone(phone);
        if( null != userBases && 1 == userBases.size()){
            return userBases.get(0);
        }else{
            log.error("未查询到匹配用户 -> phone："+phone);
            throw new KmblogServiceNotFoundException();
        }
    }

    public UserBase findByEmail( String email ) throws KmblogServiceNotFoundException {
        List<UserBase> userBases = userBaseMapper.selectByEmail(email);
        if( null != userBases && 1 == userBases.size()){
            return userBases.get(0);
        }else{
            log.error("未查询到匹配用户 -> email："+email);
            throw new KmblogServiceNotFoundException();
        }
    }
}
