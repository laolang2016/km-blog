package com.laolang.kmblog.mapper;

import com.laolang.kmblog.domain.Inbox;
import com.laolang.kmblog.emuns.InboxTypeEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InboxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Inbox record);

    int insertSelective(Inbox record);

    Inbox selectByPrimaryKey(Long id);

    List<Inbox> selectByUserTo( Long userTo );

    List<Inbox> selectByUserToAndContentKey(@Param("userTo") Long userTo, @Param("keyWord") String keyWord);

    List<Inbox> selectByUserFromAndInboxType(@Param("userFrom") Long userFrom , @Param("inboxType")InboxTypeEnum inboxType);

    List<Inbox> selectByUserToAndInboxType( @Param("userTo") Long userTo , @Param("inboxType")InboxTypeEnum inboxType);

    int updateByPrimaryKeySelective(Inbox record);

    int updateByPrimaryKeyWithBLOBs(Inbox record);

    int updateByPrimaryKey(Inbox record);
}