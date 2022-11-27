create database lenovo CHARACTER SET UTF8;
use lenovo_boot;

drop table if exists user;
CREATE TABLE `user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name` varchar(50) NOT NULL COMMENT '用户名',
    `pwd` varchar(50) NOT NULL COMMENT '密码',
    `sex` varchar(10) COMMENT '性别',
    `mail_box` varchar(200) COMMENT '邮箱',
    `location` varchar(200) COMMENT '地址',
    `self_introduction` varchar(500)  COMMENT '个人简介',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '用户表';
insert into user(user_name,pwd) values ('admin','123456');
drop table if exists cart;
CREATE TABLE `cart` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `computer_id` bigint NOT NULL COMMENT '电脑id',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `computer_name` varchar(100) NOT NULL COMMENT '电脑名称',
    `computer_type` varchar(100) NOT NULL COMMENT '电脑品牌',
    `computer_price` varchar(100) NOT NULL COMMENT '电脑价格',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '购物车表';
drop table if exists computer;
CREATE TABLE `computer` (
    `computer_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `computer_name` varchar(100) NOT NULL COMMENT '电脑名称',
    `computer_type` varchar(100) NOT NULL COMMENT '电脑品牌',
    `computer_introduction` varchar(500)  COMMENT '电脑介绍',
    `computer_img` varchar(500)  COMMENT '电脑图片',
    PRIMARY KEY (`computer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '电脑';
drop table if exists buy;
CREATE TABLE `buy` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `computer_id` bigint NOT NULL COMMENT '商品id',
    `computer_name` varchar(100) NOT NULL COMMENT '商品名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '购买记录';

drop table if exists config;
CREATE TABLE `config` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `computer_id` bigint NOT NULL COMMENT '商品id',
    `computer_config` varchar(500) NOT NULL COMMENT '商品名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '配置';

drop table if exists comment;
CREATE TABLE `comment` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `computer_id` bigint NOT NULL COMMENT '商品id',
    `computer_name` varchar(100) NOT NULL COMMENT '商品名称',
    `computer_type` varchar(100) NOT NULL COMMENT '商品种类',
    `comment` varchar(500) NOT NULL COMMENT '商品评价',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '评价';

drop table if exists after;
CREATE TABLE `after` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id` bigint NOT NULL COMMENT '用户id',
    `computer_id` bigint NOT NULL COMMENT '商品id',
    `computer_name` varchar(100) NOT NULL COMMENT '商品名称',
    `computer_type` varchar(100) NOT NULL COMMENT '商品种类',
    `computer_config` varchar(500) NOT NULL COMMENT '商品配置',
    `service` varchar(500) NOT NULL COMMENT '服务',
    `apply` varchar(500) NOT NULL COMMENT '申请原因',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '售后';

drop table if exists serve;
CREATE TABLE `serve` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
    `serve_name` varchar(100) NOT NULL COMMENT '服务名称',
    `serve_details` varchar(500) NOT NULL COMMENT '服务',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 comment '服务';


