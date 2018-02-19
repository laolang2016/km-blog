package com.laolang.kmblog.ext.mybatis;

import com.laolang.kmblog.emuns.InboxTypeEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InboxTypeEnumHandler implements TypeHandler<InboxTypeEnum> {

    private final Map<Integer,InboxTypeEnum> inboxTypeEnumMap = new HashMap<>();

    public InboxTypeEnumHandler() {
        for( InboxTypeEnum sex : InboxTypeEnum.values()){
            inboxTypeEnumMap.put(sex.getValue(),sex);
        }
    }

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, InboxTypeEnum inboxTypeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,inboxTypeEnum.getValue());
    }

    @Override
    public InboxTypeEnum getResult(ResultSet resultSet, String s) throws SQLException {
        Integer value = resultSet.getInt(s);
        return inboxTypeEnumMap.get(value);
    }

    @Override
    public InboxTypeEnum getResult(ResultSet resultSet, int i) throws SQLException {
        Integer value = resultSet.getInt(i);
        return inboxTypeEnumMap.get(value);
    }

    @Override
    public InboxTypeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer value = callableStatement.getInt(i);
        return inboxTypeEnumMap.get(value);
    }
}
