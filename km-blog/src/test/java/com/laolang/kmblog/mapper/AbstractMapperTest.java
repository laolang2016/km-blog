package com.laolang.kmblog.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractMapperTest {

    private static final Logger log = LoggerFactory.getLogger(AbstractMapperTest.class);

    @BeforeClass
    public static void beforeClassAbstractMapperTest() throws DatabaseUnitException {
        // 初始化 mybatis
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config-mapper.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            log.info("初始化 sqlSessionFactory");
            reader.close();
            sqlSession = sqlSessionFactory.openSession();
            log.info("初始化 sqlSession");
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }

        // dbunit 链接
        idconn = new DatabaseConnection(getConnection());
    }

    @AfterClass
    public static void afterClassAbstractDbunitTest(){
        // 关闭 dbunit 链接
        try{
            if( null != idconn ){
                idconn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // 关闭 mybatis session
        sqlSession.close();

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


    /**
     * 获取数据库链接
     * @return
     */
    private static Connection getConnection(){
        Connection connection = null;
        try{
            connection = sqlSession.getConfiguration().getEnvironment().getDataSource().getConnection();
            sqlSession.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }



    protected static IDatabaseConnection idconn;

    protected static SqlSessionFactory sqlSessionFactory;

    protected static SqlSession sqlSession;

    // 备份文件路径
    private File tempfile = new File("/home/laolang/projectpath/km/blog-ssm-test/backup/backtables.xml");
}
