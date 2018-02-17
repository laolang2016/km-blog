create database kmblogssmtest default character set utf8 collate utf8_general_ci;

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

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) values(1001,'u1001','小代码','123456','13500001001','xiaodaima@163.com','http://www.kmblog.com/u/xiaodaima/blog',1,'head_pic','1991-12-06','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) 
values(1002,'u1002','老狼','123456','13500001002','laolang@163.com','http://www.kmblog.com/u/laolang/blog',1,'head_pic','1995-10-26','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) 
values(1003,'u1003','天涯','123456','13500001003','tianya@163.com','http://www.kmblog.com/u/tianya/blog',2,'head_pic','1990-01-01','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) 
values(1004,'u1004','白发','123456','13500001004','baifa@163.com','http://www.kmblog.com/u/baifa/blog',1,'head_pic','1991-12-06','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) 
values(1005,'u1005','弟弟','123456','13500001005','didi@163.com','http://www.kmblog.com/u/didi/blog',2,'head_pic','1991-12-06','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) 
values(1006,'u1006','牛牛','123456','13500001006','niuniu@163.com','http://www.kmblog.com/u/niuniu/blog',1,'head_pic','1995-05-05','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');

insert into tb_user_base(id,user_code,nick_name,pwd,phone,email,blog_url,sex,head_pic,birthday,comment_report,weekly_report,created,updated) 
values(1007,'u1007','十字','123456','13500001007','shizi@163.com','http://www.kmblog.com/u/shizi/blog',1,'head_pic','1991-12-06','1','1','2018-02-17 12:04:22','2018-02-17 12:04:22');


