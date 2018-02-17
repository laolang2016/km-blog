package com.laolang.kmblog.domain;

import com.laolang.kmblog.emuns.SexEnum;

import java.util.Date;

public class UserBase {

    public UserBase() {
    }

    @Override
    public String toString() {
        return "UserBase{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", blogUrl='" + blogUrl + '\'' +
                ", sex=" + sex +
                ", headPic='" + headPic + '\'' +
                ", birthday=" + birthday +
                ", commentReport=" + commentReport +
                ", weeklyReport=" + weeklyReport +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl == null ? null : blogUrl.trim();
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic == null ? null : headPic.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getCommentReport() {
        return commentReport;
    }

    public void setCommentReport(Boolean commentReport) {
        this.commentReport = commentReport;
    }

    public Boolean getWeeklyReport() {
        return weeklyReport;
    }

    public void setWeeklyReport(Boolean weeklyReport) {
        this.weeklyReport = weeklyReport;
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

    private Long id;

    private String userCode;

    private String nickName;

    private String pwd;

    private String phone;

    private String email;

    private String blogUrl;

    private SexEnum sex;

    private String headPic;

    private Date birthday;

    private Boolean commentReport;

    private Boolean weeklyReport;

    private Date created;

    private Date updated;
}