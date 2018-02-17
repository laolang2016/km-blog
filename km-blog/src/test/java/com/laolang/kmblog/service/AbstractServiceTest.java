package com.laolang.kmblog.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.laolang.kmblog.mapper.AbstractMapperTest;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.xml.sax.InputSource;

import java.io.*;
import java.sql.SQLException;

public class AbstractServiceTest extends AbstractSpringTest {

    private static final Logger log = LoggerFactory.getLogger(AbstractServiceTest.class);

    // 备份文件路径
    private File tempfile = new File("/home/laolang/projectpath/km/blog-ssm-test/backup/backtables.xml");

    @Autowired
    private DruidDataSource dataSource;

    protected IDatabaseConnection idconn;

    @Before
    public void beforeClassAbstractServiceTest() {
        try {
            idconn = new DatabaseConnection(DataSourceUtils.getConnection(dataSource));
        } catch (DatabaseUnitException e) {
            log.info("初始化 dbunit 链接失败");
            e.printStackTrace();
        }

    }

    @After
    public void afterClassAbstractServiceTest(){
        if( null != idconn ){
            try {
                idconn.close();
            } catch (SQLException e) {
                log.info("关闭 dbunit 失败");
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建测试数据源
     * @param tablename 测试数据文件
     * @return dataset
     * @throws DataSetException
     */
    protected IDataSet createDataset(String tablename ) throws DataSetException {
        InputStream is = AbstractMapperTest.class.getClassLoader().getResourceAsStream(tablename);
        Assert.assertNotNull("dbunit xml数据文件未找到",is);
        return new FlatXmlDataSet( new FlatXmlProducer(new InputSource(is)));

    }

    /**
     * 备份所有的表
     * @throws SQLException
     * @throws IOException
     * @throws DataSetException
     */
    protected void backupAllTable() throws SQLException, IOException, DataSetException{
        IDataSet dataset = idconn.createDataSet();
        writeBackupFile(dataset);
    }

    private void writeBackupFile(IDataSet ds) throws IOException, DataSetException{
        FlatXmlDataSet.write(ds, new FileWriter(tempfile));
    }

    /**
     * 备份指定表
     * @param tname 要备份的表的名称[数组]
     * @throws DataSetException
     * @throws IOException
     */
    protected void backupCustomTable(String[] tname) throws DataSetException, IOException {
        QueryDataSet ds = new QueryDataSet(idconn);
        for(String str:tname) {
            ds.addTable(str);
        }
        writeBackupFile(ds);
    }

    /**
     * 备份指定表
     * @param tname 要备份的表的名称
     * @throws DataSetException
     * @throws IOException
     */
    protected void backcupOneTable(String tname) throws DataSetException, IOException {
        backupCustomTable(new String[]{tname});
    }

    /**
     * 还原表
     * @throws FileNotFoundException
     * @throws DatabaseUnitException
     * @throws SQLException
     */
    protected void resumeTable() throws FileNotFoundException, DatabaseUnitException, SQLException {
        IDataSet ds = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(tempfile))));
        DatabaseOperation.CLEAN_INSERT.execute(idconn, ds);
    }

}
