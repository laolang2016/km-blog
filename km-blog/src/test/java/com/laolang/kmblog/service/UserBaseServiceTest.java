package com.laolang.kmblog.service;

import com.laolang.kmblog.domain.UserBase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class UserBaseServiceTest extends AbstractServiceTest {

    private Logger log = LoggerFactory.getLogger(UserBaseServiceTest.class);

    @Autowired
    private UserBaseService userBaseService;

    private IDataSet dataSet;

    @Before
    public void beforeUserBaseServiceTest(){
        // 备份用户表
        try {
            backcupOneTable("tb_user_base");
            // 将测试数据插入到数据库中
            dataSet = createDataset("dbunitxml/tb_user_base.xml");
            DatabaseOperation.CLEAN_INSERT.execute(idconn,dataSet);
            log.info("插入 tb_user 测试数据");
        } catch (DataSetException e) {
            e.printStackTrace();
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @After
    public void afterAbstractUserBaseMapperTest() {
        try {
            resumeTable();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DatabaseUnitException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findTest(){
        UserBase userBase = userBaseService.find(1L);
        assertNotNull(userBase);
    }
}
