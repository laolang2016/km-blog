package com.laolang.kmblog.domain;

import com.laolang.kmblog.emuns.InboxTypeEnum;

import java.util.Date;

public class Inbox {

    public Inbox() {
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "id=" + id +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", inboxType=" + inboxType +
                ", created=" + created +
                ", updated=" + updated +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(Long userFrom) {
        this.userFrom = userFrom;
    }

    public Long getUserTo() {
        return userTo;
    }

    public void setUserTo(Long userTo) {
        this.userTo = userTo;
    }

    public InboxTypeEnum getInboxType() {
        return inboxType;
    }

    public void setInboxType(InboxTypeEnum inboxType) {
        this.inboxType = inboxType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    private Long id;

    private Long userFrom;

    private Long userTo;

    private InboxTypeEnum inboxType;

    private Date created;

    private Date updated;

    private String content;
}