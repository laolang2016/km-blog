package com.laolang.kmblog.mapper;

import com.laolang.kmblog.domain.UserBase;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserBaseMapperSelectTest extends AbstractUserBaseMapperTest {

    @Test
    public void selectByPrimaryKeyTest(){
        UserBase userBase = userBaseMapper.selectByPrimaryKey(1L);
        assertNotNull(userBase);
    }
}
