create database kmblogssm default character set utf8 collate utf8_general_ci;

create table tb_user_base(
       id bigint(20) primary key auto_increment comment 'id',
       user_code varchar(255) not null unique comment '用户号码',
       nick_name varchar(255) not null unique comment '昵称',
       pwd varchar(255) not null comment '密码',
       phone varchar(255) unique comment '手机号码',
       email varchar(255) unique comment '邮箱地址',
       blog_url varchar(255) not null unique comment '个人博客地址',
       sex int not null comment '性别，1：男，2：女',
       head_pic varchar(255) not null default '' comment '头像地址',
       birthday date comment '出生日期',
       comment_report tinyint(1) not null default '1' comment '评论、回复、关注通知',
       weekly_report tinyint(1) not null default '1' comment '每周精彩订阅',
       created datetime not null comment '创建时间',
       updated datetime not null comment '更新时间'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';
