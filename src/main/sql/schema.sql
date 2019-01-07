-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- 数据库初始化脚本
-- 创建数据库
create  database seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
CREATE TABLE `seckill` (
	`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
	`name` VARCHAR(120) NOT NULL COMMENT '商品名称',
	`number` INT NOT NULL COMMENT '库存数量',
	`start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
	`end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
	`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (seckill_id),
	KEY idx_start_time(start_time),
	KEY idx_end_time(end_time),
	KEY idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT '秒杀库存表';

-- 初始化数据
insert  into
  seckill(name,number,start_time,end_time)
values
  ('1000元秒杀iPhoneX','100','2018-12-24 00:00:00','2018-12-24 01:00:00'),
  ('500元秒杀iPad4','200','2018-12-24 00:00:00','2018-12-24 01:00:00'),
  ('1000元秒杀华为p20','300','2018-12-24 00:00:00','2018-12-24 01:00:00'),
  ('800元秒杀小米8','400','2018-12-24 00:00:00','2018-12-24 01:00:00');

-- 秒杀成功明细表
-- 用户登录认证相关信息
create table success_killed(
  `seckill_id` bigint not null comment '秒杀商品id',
  `user_phone` bigint not null comment '用户手机号',
  `state` tinyint not null default -1 comment '状态标识：-1：无效；0：成功；1：已付款',
  `create_time` timestamp not null comment '创建时间',
  primary key (seckill_id,user_phone),/*联合主键*/
  key idx_create_time(create_time)
)engine=innodb default charset=utf8 comment='秒杀成功明细表';

-- 连接数据库控制台

