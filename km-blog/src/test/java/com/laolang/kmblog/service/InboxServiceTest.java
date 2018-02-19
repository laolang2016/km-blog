package com.laolang.kmblog.service;

import com.github.pagehelper.PageInfo;
import com.laolang.kmblog.domain.Inbox;
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

public class InboxServiceTest extends AbstractServiceTest{

    private static final Logger log = LoggerFactory.getLogger(InboxServiceTest.class);

    @Autowired
    private InboxService inboxService;

    private IDataSet dataSet;

    @Before
    public void beforeInboxServiceTest() throws IOException, DatabaseUnitException, SQLException {
        String[] tables = {"tb_user_base","tb_inbox"};
        backupCustomTable(tables);
        dataSet = createDataset("dbunitxml/tb_inbox.xml");
        DatabaseOperation.CLEAN_INSERT.execute(idconn,dataSet);
        log.info("插入 tb_inbox 测试数据");
    }

    @After
    public void afterInboxServiceTest() throws FileNotFoundException, DatabaseUnitException, SQLException {
        resumeTable();
    }

    @Test
    public void findListTest(){
        PageInfo<Inbox> pageInfo = inboxService.findListByUserTo(3L,1,4);
        assertNotNull(pageInfo);
        assertNotNull(pageInfo.getList());
        for (Inbox inbox : pageInfo.getList() ){
            System.out.println(inbox);
        }
    }
}
