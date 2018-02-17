package com.laolang.kmblog.mapper;

import com.laolang.kmblog.domain.UserBase;

import java.util.List;

public interface UserBaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Long id);

    List<UserBase> selectByPhone( String phone );

    List<UserBase> selectByEmail( String email );

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}