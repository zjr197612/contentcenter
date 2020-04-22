drop database if exists content_center;
create database content_center;

USE `content_center`;

-- -----------------------------------------------------
-- Table `share`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `share` (
  `share_id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` INT NOT NULL DEFAULT 0 COMMENT '发布人id',
  `share_title` VARCHAR(80) NOT NULL DEFAULT '' COMMENT '标题',
  `share_create_time` DATETIME NOT NULL COMMENT '创建时间',
  `share_update_time` DATETIME NOT NULL COMMENT '修改时间',
  `share_is_original` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否原创 0:否 1:是',
  `share_author` VARCHAR(45) NOT NULL DEFAULT '' COMMENT '作者',
  `share_cover` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '封面',
  `share_summary` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '概要信息',
  `share_price` INT NOT NULL DEFAULT 0 COMMENT '价格（需要的积分）',
  `share_download_url` VARCHAR(256) NOT NULL DEFAULT '' COMMENT '下载地址',
  `share_buy_count` INT NOT NULL DEFAULT 0 COMMENT '下载数 ',
  `share_show_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否显示 0:否 1:是',
  `share_audit_status` VARCHAR(10) NOT NULL DEFAULT 0 COMMENT '审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过',
  `share_reason` VARCHAR(200) NOT NULL DEFAULT '' COMMENT '审核不通过原因',
  PRIMARY KEY (`share_id`))ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT = '分享表';

insert into share(user_id,share_title,share_create_time,share_update_time,share_author,share_cover,share_download_url,share_buy_count)
    values(1,'springcloud1',now(),now(),'张三1','封面1','http://www.163.com1',1);
insert into share(user_id,share_title,share_create_time,share_update_time,share_author,share_cover,share_download_url,share_buy_count)
    values(1,'springcloud2',now(),now(),'张三2','封面2','http://www.263.com2',2);
insert into share(user_id,share_title,share_create_time,share_update_time,share_author,share_cover,share_download_url,share_buy_count)
    values(2,'springcloud3',now(),now(),'张三3','封面3','http://www.363.com3',3);
insert into share(user_id,share_title,share_create_time,share_update_time,share_author,share_cover,share_download_url,share_buy_count)
    values(2,'springcloud4',now(),now(),'张三4','封面4','http://www.464.com4',4);

select * from share;
-- -----------------------------------------------------
-- Table `mid_user_share`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mid_user_share` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `share_id` INT NOT NULL COMMENT 'share.id',
  `user_id` INT NOT NULL COMMENT 'user.id',
  PRIMARY KEY (`id`),
  INDEX `fk_mid_user_share_share1_idx` (`share_id` ASC) ,
  INDEX `fk_mid_user_share_user1_idx` (`user_id` ASC) )
ENGINE = InnoDB
COMMENT = '用户-分享中间表【描述用户购买的分享】';


-- -----------------------------------------------------
-- Table `notice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `notice` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '内容',
  `show_flag` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否显示 0:否 1:是',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`));