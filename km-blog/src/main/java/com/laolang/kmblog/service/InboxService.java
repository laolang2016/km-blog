package com.laolang.kmblog.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laolang.kmblog.domain.Inbox;
import com.laolang.kmblog.emuns.InboxTypeEnum;
import com.laolang.kmblog.mapper.InboxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboxService {

    @Autowired
    private InboxMapper inboxMapper;

    /**
     *
     * 根据收信人id和私信类型查询私信
     * @param userTo 收信人 id
     * @param inboxType 私信类型
     * @param page 页数
     * @param size 每页数据量
     * @return pageinfo
     */
    public PageInfo<Inbox> findListByUserToAndInboxType(Long userTo , InboxTypeEnum inboxType , int page, int size ){
        PageHelper.startPage(page,size);
        List<Inbox> inboxes = inboxMapper.selectByUserTo(userTo);
        PageInfo<Inbox> pageInfo = new PageInfo<>(inboxes);
        return pageInfo;
    }
}
