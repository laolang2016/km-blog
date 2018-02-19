package com.laolang.kmblog.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laolang.kmblog.domain.Inbox;
import com.laolang.kmblog.emuns.InboxTypeEnum;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.groups.ConvertGroup;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class InboxMapperTest extends AbstractMapperTest {
    private static final Logger log = LoggerFactory.getLogger(AbstractMapperTest.class);

    private static InboxMapper inboxMapper;

    private IDataSet dataSet;

    @BeforeClass
    public static void beforeCassInboxMapperTest(){
        inboxMapper = sqlSession.getMapper(InboxMapper.class);
    }

    @Before
    public void beforeInboxMapperTest() throws IOException, DatabaseUnitException, SQLException {
        String[] tables = {"tb_user_base","tb_inbox"};
        backupCustomTable(tables);
        dataSet = createDataset("dbunitxml/tb_inbox.xml");
        DatabaseOperation.CLEAN_INSERT.execute(idconn,dataSet);
        log.info("插入 tb_inbox 测试数据");


    }

    @After
    public void afterInboxMapperTest() throws FileNotFoundException, DatabaseUnitException, SQLException {
        resumeTable();

    }

    @Test
    public void selectByPrimaryKeyTest(){
        Inbox inbox = inboxMapper.selectByPrimaryKey(1L);
        assertNotNull(inbox);
    }

    @Test
    public void selectByUserToTest(){
        PageHelper.startPage(2,3);
        List<Inbox> inboxes = inboxMapper.selectByUserTo(3L);
        PageInfo<Inbox> pageInfo = new PageInfo<>(inboxes);
        assertNotNull(pageInfo);
        assertNotNull(pageInfo.getList());
        for (Inbox inbox : pageInfo.getList() ){
            System.out.println(inbox);
        }

    }

    @Test
    public void selectByContentKeyTest(){
        PageHelper.startPage(1,3);
        List<Inbox> inboxes = inboxMapper.selectByUserToAndContentKey(3L,"私信");
        PageInfo<Inbox> pageInfo = new PageInfo<>(inboxes);
        assertNotNull(pageInfo);
        assertNotNull(pageInfo.getList());
        for (Inbox inbox : pageInfo.getList() ){
            System.out.println(inbox);
        }
    }

    @Test
    public void selectByUserFromAndInboxTypeTest(){
        PageHelper.startPage(1,3);
        List<Inbox> inboxes = inboxMapper.selectByUserFromAndInboxType(0L, InboxTypeEnum.SYSTEM);
        PageInfo<Inbox> pageInfo = new PageInfo<>(inboxes);
        assertNotNull(pageInfo);
        assertNotNull(pageInfo.getList());
        for (Inbox inbox : pageInfo.getList() ){
            System.out.println(inbox);
        }
    }

    @Test
    public void selectByUserToAndInboxTypeTest(){
        PageHelper.startPage(1,3);
        List<Inbox> inboxes = inboxMapper.selectByUserToAndInboxType(3L, InboxTypeEnum.USER);
        PageInfo<Inbox> pageInfo = new PageInfo<>(inboxes);
        assertNotNull(pageInfo);
        assertNotNull(pageInfo.getList());
        for (Inbox inbox : pageInfo.getList() ){
            System.out.println(inbox);
        }
    }
}
