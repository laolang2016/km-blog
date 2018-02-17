package com.laolang.kmblog.mapper;

import com.laolang.kmblog.domain.UserBase;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserBaseMapperSelectTest extends AbstractUserBaseMapperTest {

    @Test
    public void selectByPrimaryKeyTest(){
        UserBase userBase = userBaseMapper.selectByPrimaryKey(1L);
        assertNotNull(userBase);
    }

    @Test
    public void selectByPhoneTest(){
        List<UserBase> userBases = userBaseMapper.selectByPhone("13569091001");
        assertNotNull(userBases);
        assertEquals(1,userBases.size());
    }

    @Test
    public void selectByEmailTest(){
        List<UserBase> userBases = userBaseMapper.selectByEmail("xiaodaima1@163.com");
        assertNotNull(userBases);
        assertEquals(1,userBases.size());
    }


}
