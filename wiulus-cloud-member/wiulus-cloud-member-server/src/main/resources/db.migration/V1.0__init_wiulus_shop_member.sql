SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
use wiulus_member;
-- ----------------------------
-- Table structure for wls_shop_invoice
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_invoice`;
CREATE TABLE `wls_shop_invoice`  (
  `id` bigint(20) NOT NULL COMMENT '索引id',
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `inv_state` tinyint(1) NULL DEFAULT NULL COMMENT '发票类型（1:普通发票，2:增值税发票，3:电子发票）',
  `inv_type` tinyint(1) NULL DEFAULT 1 COMMENT '普通发票类型（1:个人发票，2:单位发票）',
  `inv_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '公司发票抬头名称',
  `inv_personal` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '个人发票抬头名称',
  `inv_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '纳税人识别号',
  `inv_reg_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '注册地址名称',
  `inv_reg_phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '注册电话',
  `inv_reg_bname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '开户银行名称',
  `inv_reg_baccount` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '银行帐户',
  `inv_rec_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '收票人姓名',
  `inv_rec_mobile` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '收票人手机号',
  `inv_rec_province` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '收票人省市区ID（省市区ID中间使用ID分割）',
  `inv_rec_addr` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '收票详细地址',
  `is_default` tinyint(1) NULL DEFAULT 0 COMMENT '是否默认（默认0:否，1:是）',
  `audit_status` tinyint(1) NULL DEFAULT 0 COMMENT '审核状态（0未审核，1审核通过，2审核未通过，3审核中）只有增值税专票需要审核',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记（默认0:未删除,1:已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户发票信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wls_shop_member
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_member`;
CREATE TABLE `wls_shop_member`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `member_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `member_mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `member_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `member_real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `member_avatar` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户头像',
  `member_sex` tinyint(1) NULL DEFAULT 0 COMMENT '用户性别 （默认0:保密，1：女，2：男）',
  `member_passwd` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户密码',
  `member_birthday` datetime(0) NULL DEFAULT NULL COMMENT '用户生日',
  `member_login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户当前登录IP',
  `member_login_time` datetime(0) NULL DEFAULT NULL COMMENT '用户当前登录时间',
  `last_login_date` datetime(0) NULL DEFAULT NULL COMMENT '用户最后登录时间',
  `last_login_ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户最后登录IP',
  `wechat_openid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信openId',
  `wechat_unionid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。',
  `qq_openid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'QQopenId',
  `sina_openid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '新浪openId',
  `member_role` tinyint(1) NULL DEFAULT 0 COMMENT '会员角色：0：会员，1：店铺和会员',
  `member_source` tinyint(1) NULL DEFAULT 0 COMMENT '用户来源（默认0:网站注册，1:安卓，2:IOS注册，3:小程序注册）',
  `member_state` tinyint(1) NULL DEFAULT 0 COMMENT '用户状态（默认0:正常、1:锁定）',
  `email_validate_state` tinyint(1) NULL DEFAULT 0 COMMENT '邮箱验证状态（默认为0:未验证，1:已验证）',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记（默认为0未删除，1已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `MEMBER_NAME`(`member_name`) USING BTREE COMMENT '会员名称索引',
  INDEX `MEMBER_MOBILE`(`member_mobile`) USING BTREE COMMENT '会员手机号索引',
  INDEX `MEMBER_EMAIL`(`member_email`) USING BTREE COMMENT '会员邮箱索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wls_shop_member_address
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_member_address`;
CREATE TABLE `wls_shop_member_address`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `true_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收件人名称',
  `mob_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '收件人电话',
  `area_id` bigint(20) NULL DEFAULT NULL COMMENT '地区ID',
  `province_id` bigint(20) NULL DEFAULT NULL COMMENT '省级id',
  `city_id` bigint(20) NULL DEFAULT NULL COMMENT '市级ID',
  `stress_id` bigint(20) NULL DEFAULT NULL COMMENT '街道id',
  `area_info` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址内容',
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `zip_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `default_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否默认（ 默认为0:非默认，1:已默认）',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记（默认为0未删除，1已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员地址表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wls_shop_member_grade
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_member_grade`;
CREATE TABLE `wls_shop_member_grade`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `grade_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '等级名称',
  `integration` int(11) NULL DEFAULT NULL COMMENT '所需积分',
  `grade_img` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '等级所对应的图片',
  `deadline` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '会员帐号有效期',
  `preferential` int(11) NULL DEFAULT NULL COMMENT '优惠百分比',
  `default_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否是默认（默认0 非默认，1已默认）',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT NULL COMMENT '删除标记（默认为0未删除，1已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wls_shop_member_info
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_member_info`;
CREATE TABLE `wls_shop_member_info`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `member_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `payment_passwd` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '支付密码',
  `consume_point` int(11) NULL DEFAULT 0 COMMENT '用户消费积分',
  `available_point` int(11) NULL DEFAULT 0 COMMENT '用户可用积分',
  `grade_point` int(11) NULL DEFAULT 0 COMMENT '用户等级积分',
  `member_areaid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地区ID',
  `member_cityid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '城市ID',
  `member_provinceid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '省份ID',
  `stress_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '街道id',
  `member_areainfo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地区内容',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记（默认为0未删除，1已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `MEMBER_ID`(`member_id`) USING BTREE COMMENT '会员IDsuoy'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '会员详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wls_shop_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_member_login_log`;
CREATE TABLE `wls_shop_member_login_log`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `member_id` bigint(20) NOT NULL COMMENT '用户ID',
  `ip` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作ip',
  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户代理',
  `phone_number` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `login_area` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '登录地区',
  `source` tinyint(1) NULL DEFAULT 0 COMMENT '登录方式   0:PC登录  1:手机  2:其他',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记（默认为0未删除，1已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  `status` tinyint(3) NULL DEFAULT NULL COMMENT '登录状态 0：登录成功   1：登陆失败',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wls_shop_point_log
-- ----------------------------
DROP TABLE IF EXISTS `wls_shop_point_log`;
CREATE TABLE `wls_shop_point_log`  (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `member_id` bigint(20) NOT NULL COMMENT '用户ID',
  `member_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名称',
  `point_value` int(8) NOT NULL COMMENT '积分/成长值（正为加，负为减）',
  `point_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '积分/成长值描述',
  `source_type` int(2) NULL DEFAULT NULL COMMENT '积分/成长值获取类型（1:新手欢迎奖励;2:设置头像;3:设置昵称;4:完善个人信息;5:首次关注店铺;6:首次分享商品;7:首次收藏商品;8:首次购物成功;9:首次完成评价;10:每日登录;11:每日签到;12:分享商品;13:邀请好友;14:好友首次下单成功;15:评价）',
  `point_type` tinyint(1) NOT NULL COMMENT '类型（1:积分;2:成长值）',
  `current_value` int(8) NOT NULL DEFAULT 0 COMMENT '当前积分/成长值',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记（默认为0未删除，1已删除）',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `member_id`(`member_id`) USING BTREE COMMENT '会员ID',
  INDEX `point_type`(`point_type`) USING BTREE COMMENT '类型'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '积分日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主键id',
  `token` blob NULL COMMENT 'token值',
  `authentication_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份认证id',
  `user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `client_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端id',
  `authentication` blob NULL COMMENT '身份认证信息',
  `refresh_token` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用于保证用户token不过期的刷新token',
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
  `userId` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `clientId` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端id',
  `scope` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作用范围',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  `expiresAt` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '过期时间',
  `lastModifiedAt` timestamp(0) NOT NULL COMMENT '最后一次修改时间'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户端id',
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '资源id',
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '客户端密匙',
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '范围',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '授权类型',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '回调地址',
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '认证',
  `access_token_validity` int(11) NULL DEFAULT NULL COMMENT 'access_token有效时间',
  `refresh_token_validity` int(11) NULL DEFAULT NULL COMMENT 'refresh_token有效时间',
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '额外信息',
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '自动批准',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '认证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主键',
  `token` blob NULL COMMENT 'token值',
  `authentication_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户认证id',
  `user_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `client_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端id',
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
  `code` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'oauth2code',
  `authentication` blob NULL COMMENT '认证信息'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主键',
  `token` blob NULL COMMENT 'tokenid',
  `authentication` blob NULL COMMENT '认证信息'
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
