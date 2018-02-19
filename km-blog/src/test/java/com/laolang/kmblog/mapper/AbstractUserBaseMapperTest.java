package com.laolang.kmblog.mapper;

import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public abstract class AbstractUserBaseMapperTest extends AbstractMapperTest{

    private static final Logger log = LoggerFactory.getLogger(AbstractUserBaseMapperTest.class);

    protected static UserBaseMapper userBaseMapper;

    private IDataSet dataSet;

    @BeforeClass
    public static void beforeClassUserMapperAbstractTest(){
        userBaseMapper = sqlSession.getMapper(UserBaseMapper.class);

    }

    @Before
    public void beforeAbstractUserBaseMapperTest() throws IOException, DatabaseUnitException, SQLException {
        // 备份用户表
        backcupOneTable("tb_user_base");

        // 将测试数据插入到数据库中
        dataSet = createDataset("dbunitxml/tb_user_base.xml");
        DatabaseOperation.CLEAN_INSERT.execute(idconn,dataSet);
        log.info("插入 tb_user_base 测试数据");
    }

    /**
     * 还原数据库
     * @throws FileNotFoundException
     * @throws DatabaseUnitException
     * @throws SQLException
     */
    @After
    public void afterAbstractUserBaseMapperTest() throws FileNotFoundException, DatabaseUnitException, SQLException {
        resumeTable();
    }
}
