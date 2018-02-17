package com.laolang.kmblog.ext.mybatis;

import com.laolang.kmblog.emuns.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SexEnumHandler implements TypeHandler<SexEnum> {

    private final Map<Integer,SexEnum> sexEnumMap = new HashMap<>();


    public SexEnumHandler() {
        for( SexEnum sex : SexEnum.values()){
            sexEnumMap.put(sex.getValue(),sex);
        }
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getValue());
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, String s) throws SQLException {
        Integer value = resultSet.getInt(s);
        return sexEnumMap.get(value);
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, int i) throws SQLException {
        Integer value = resultSet.getInt(i);
        return sexEnumMap.get(value);
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer value = callableStatement.getInt(i);
        return sexEnumMap.get(value);
    }
}
