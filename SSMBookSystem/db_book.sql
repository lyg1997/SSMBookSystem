/*
 Navicat Premium Data Transfer

 Source Server         : liuwei
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : db_book

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 29/06/2019 16:40:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `manager_id` int(10) NOT NULL,
  `catName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `parent_id` int(10) NULL DEFAULT NULL COMMENT '父目录id',
  `is_parent` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT '子目录',
  `createDate` bigint(30) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`manager_id`) USING BTREE,
  INDEX `parent_id`(`parent_id`) USING BTREE,
  CONSTRAINT `mid` FOREIGN KEY (`manager_id`) REFERENCES `tb_manager` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES (1, 1, '文艺', 0, 1, 1522910247);
INSERT INTO `tb_category` VALUES (8, 1, '文学', 0, 1, 1523877843);
INSERT INTO `tb_category` VALUES (9, 1, '教育', 0, 0, 1523877874);
INSERT INTO `tb_category` VALUES (10, 1, '生活', 0, 0, 1523877885);
INSERT INTO `tb_category` VALUES (11, 1, '成功/励志', 0, 0, 1523877896);
INSERT INTO `tb_category` VALUES (14, 1, '艺术', 8, 0, 1523878304);

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `book_id` int(11) NOT NULL COMMENT '目标图书id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `commentDate` bigint(30) NOT NULL COMMENT '评论时间',
  `top` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES (2, 1, 1, '孤独并不可怕，你害怕的是寂寞，所有让人快速成长的事，都是孤独的，孤独是我们跟世界相处的方式之一。学会跟孤独坦然相对。喜欢看踢踢的书，有一种恬静的生活态度，静静地品味人生品味自己。推荐踢踢的这本书哦《越孤独越自由》', 1522910247, 00000000000);
INSERT INTO `tb_comment` VALUES (6, 5, 23, '从你的全世界路过', 1523871356, NULL);
INSERT INTO `tb_comment` VALUES (7, 5, 23, 'dadad', 1523871771, NULL);
INSERT INTO `tb_comment` VALUES (8, 5, 23, '345345', 1555572097, NULL);
INSERT INTO `tb_comment` VALUES (9, 5, 23, '测试0123', 1555574407, NULL);

-- ----------------------------
-- Table structure for tb_library
-- ----------------------------
DROP TABLE IF EXISTS `tb_library`;
CREATE TABLE `tb_library`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cate_id` int(10) NOT NULL COMMENT '图书分类',
  `manager_id` int(10) NULL DEFAULT NULL COMMENT '创建人',
  `bookName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `press` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版社',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` float(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `publishDate` bigint(30) NULL DEFAULT NULL COMMENT '出版日期',
  `createDate` bigint(30) NOT NULL COMMENT '创建时间',
  `bookNum` int(11) NULL DEFAULT 1 COMMENT '数量',
  `barcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '条形码',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cate_id`(`cate_id`) USING BTREE,
  INDEX `manager_id`(`manager_id`) USING BTREE,
  CONSTRAINT `tb_library_ibfk_1` FOREIGN KEY (`cate_id`) REFERENCES `tb_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_library_ibfk_2` FOREIGN KEY (`manager_id`) REFERENCES `tb_manager` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_library
-- ----------------------------
INSERT INTO `tb_library` VALUES (23, 1, 1, '从你的全世界路过', '你好世界', '张嘉佳', '湖南文艺出版社', '/upload/book/3a9f1d7032ed4b42bb3fc2970cefb446.jpg', 29.90, 1523863298, 1523863298, 500, '22222');
INSERT INTO `tb_library` VALUES (25, 8, 1, '白洋淀纪事', '《白洋淀纪事》 是2010年3月1日由凤凰出版传媒集团、江苏文艺出版社出版的纪实类图书，作者是孙犁。本书以一个个日常小故事串联，记录了白洋淀发生的故事。', '孙犁', '江苏文艺出版社出版', '/upload/book/ae310ceddb9c42b7b7f00137820a5e5c.jpg', 31.60, 1523878724, 1523878724, 356, '33333');
INSERT INTO `tb_library` VALUES (26, 8, 1, '三毛：撒哈拉的故事', '《三毛：撒哈拉的故事》是2011年北京十月文艺出版社出版的图书，作者是三毛。该书由十几篇精彩动人的散文结合而成，以沙漠为背景的故事，倾倒了全世界的华文读者。', '三毛', '北京十月文艺出版社', '/upload/book/0f249f23c30245548b9d2f7fa4691312.jpg', 16.60, 1523878871, 1523878871, 956, '123456');
INSERT INTO `tb_library` VALUES (27, 8, 1, '写在人生边上人生边上的边上石语', '《写在人生边上人生边上的边上石语》是2002年10月1日生活.读书.新知三联书店出版发行的图书，作者是钱锺书先生。', '钱锺书', '生活.读书.新知三联书店', '/upload/book/6396701ac6a347b1b4d328182122a945.jpg', 34.00, 1523878973, 1523878973, 3200, '123455');
INSERT INTO `tb_library` VALUES (28, 8, 1, '远方的鼓声', '《远方的鼓声》是2011年由上海译文出版社出版的图书，作者是村上春树，译者是林少华。本书是作者的游记，时间为1986-1989年，游历地区为欧洲，主要为希腊、意大利两个国家。', '村上春树', '上海译文出版社', '/upload/book/93a188c44d3f4c2788d6b7a1bbc6fe6d.jpg', 31.80, 1523879421, 1523879421, 1230, '123454');
INSERT INTO `tb_library` VALUES (29, 1, 1, '东宫', '《东宫》 是作家匪我思存创作的长篇爱情小说；2010年在内地由新世界出版社出版   ，之后在香港   、台湾  、越南   、泰国  等地发行。', '匪我思存', '新世界出版社', '/upload/book/bfe7f40c4d5943cf816c32eb0dc45a5b.jpg', 47.20, 1523879803, 1523879803, 5262, '123451');
INSERT INTO `tb_library` VALUES (30, 1, 1, '一座城，在等你', '《一座城，在等你》发表于晋江文学城，作者玖月晞。\r\n文案1：你每一次的逆行，我都在原地等你。文案2：去吧，愿光脚追逐爱情；桥都坚固，隧道都光明。——改自塔朗吉文案3：小怂包：求抱抱求温暖求怜爱~~宋日天：给抱抱给温暖给怜爱', '玖月晞', '晋江文学', '/upload/book/501ac21f63f14da2b062a35749d7bec6.jpg', 42.00, 1523879922, 1523879922, 250, '1234351');
INSERT INTO `tb_library` VALUES (31, 1, 1, '芸汐传奇', '网作家芥沫作品，原名《天才小毒妃》', '芥沫', '百花洲文艺出版社', '/upload/book/b596af6c71054d61ba46045a6c35f57a.jpg', 59.80, 1523880053, 1523880053, 20, '555555');
INSERT INTO `tb_library` VALUES (32, 1, 1, '他知道风从哪个方向来', '《他知道风从哪个方向来》是一本于2015年12月由百花洲文艺出版社出版的文学体裁为爱情类的图书，作者是玖月晞。', '玖月晞', '百花洲文艺出版社', '/upload/book/04ebc59d55b546fc883013edc723843d.jpg', 38.00, 1523880177, 1523880177, 10, '6666666');
INSERT INTO `tb_library` VALUES (33, 1, 1, '时光不负爱情，我不负你', '暖心文艺女神米娅“暖心暖肾系列”，既有炙热的情感，又有精巧的情趣。\r\n即使时光易老，青春不再，你我还是最初相爱的模样。\r\n2018年3月百花洲文艺出版社、酷威文化出版。', '米娅', '百花洲文艺出版社', '/upload/book/a433fe0595ac46f6a9253992e2deff6d.jpg', 36.00, 1523880322, 1523880322, 256, '888888');
INSERT INTO `tb_library` VALUES (34, 1, 1, '如果你也喜欢我', '她和他是从小一起长大的青梅竹马。 她对他早已暗生情愫,而他却懵然不知。 从黑暗里走出来的少年、突然出现的三名转校生。 这一切,左雅泉都认为除了从暗巷里带回来的少年之外,其他人和她不会有任何关系。', '孤影自怜', '小说吧', '/upload/book/e6c318b3c57240db9a5ad9d757d3e175.jpg', 15.20, 1523880796, 1523880796, 2000, '999999');
INSERT INTO `tb_library` VALUES (35, 14, 1, '极简摄影入门', '摄影初学者的摄影入门教程，快速学会相机设置、附件使用以及摄影构图、用光技法', '杨品，曾兰，熊枭', '化学工业出版社', '/upload/book/dc175f5e520341b3b12acd47dbedfc2c.jpg', 48.99, 1523881218, 1523881218, 2000, '147258');
INSERT INTO `tb_library` VALUES (36, 11, 1, '活法', '畅销十年,单本在中国发行突破200万册。 两家世界500强企业京瓷及KDDI的创立者，日航起死回生奇迹的缔造者。 他是经营界的传奇式人物，却始终坚持简单而平实的活法。他就是稻盛和夫！', '曹岫云', '东方出版社', '/upload/book/ef77eb23e7ed4f3bb3168a9052ce5d71.jpg', 27.00, 1523881451, 1523881451, 2000, '369258');
INSERT INTO `tb_library` VALUES (37, 11, 1, '不抱怨的世界', '200万册增订版；新增30%心灵变革实践篇；世界500强推崇的员工心理自助书；冯仑、李开复、张德芬、奥普拉感动推荐', '[美]威尔·鲍温（Will Bowen）', '湖南文艺出版社', '/upload/book/7cbfbfc7dfce4ba4af2462b705d33b7a.jpg', 25.20, 1523881624, 1523881624, 1000, '456789');
INSERT INTO `tb_library` VALUES (38, 9, 1, '英汉大词典', '曾荣获首届国家图书奖等多个奖项，是联合国编译人员使用的主要英汉工具书。', '陆谷孙', '上海译文出版社', '/upload/book/db3abfac5cb2436ca8dc821f43b95b0b.jpg', 184.30, 1523881842, 1523881842, 12, '987654');
INSERT INTO `tb_library` VALUES (39, 10, 1, '美好的旅行', '穿越那与天齐高的珠穆朗玛，在雅鲁藏布江把心洗净，俯瞰满山天光云影的层层梯田，在塞伦盖蒂草原，看角马群在如血夕阳下汹涌奔流，在悠然的岁月中，游遍美好的地方……', '《图书天下·国家地理系列》编委会', '北京联合出版公司', '/upload/book/34f4888b8fe842498103ff25083f668e.jpg', 28.60, 1523882012, 1523882012, 1200, '258147');
INSERT INTO `tb_library` VALUES (40, 8, 1, '测试图书-02', 'xx图书简介', '是多少', 'xx出版社', '/upload/book/34e942cd5ece4b3abf2ca64c61b8b474.jpg', 100.00, 1558419200, 1558419200, 200, '123123');
INSERT INTO `tb_library` VALUES (41, 1, 1, 'test', '233', '233', '233', '/upload/book/2a69080098c040d08db35d7aaea23253.jpg', 100.00, 1561362412, 1561362412, 200, '4633');

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES (1, 'admin', '0adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `book_id` int(10) NOT NULL,
  `orderDate` bigint(30) NOT NULL COMMENT '预约日期',
  `deadline` bigint(11) NULL DEFAULT NULL COMMENT '预约过期时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (22, 50, 29, 1523885398, 1524490198);
INSERT INTO `tb_order` VALUES (25, 50, 30, 1523885407, 1524490207);
INSERT INTO `tb_order` VALUES (29, 5, 23, 1558421555, 1559026355);
INSERT INTO `tb_order` VALUES (31, 5, 23, 1558421568, 1559026368);
INSERT INTO `tb_order` VALUES (32, 5, 39, 1558426780, 1559031580);
INSERT INTO `tb_order` VALUES (33, 5, 40, 1558426920, 1566202920);
INSERT INTO `tb_order` VALUES (34, 5, 25, 1558580149, 1566356149);
INSERT INTO `tb_order` VALUES (35, 5, 25, 1558580150, 1566356150);
INSERT INTO `tb_order` VALUES (36, 5, 25, 1558580153, 1566356153);
INSERT INTO `tb_order` VALUES (37, 5, 25, 1558580154, 1566356154);
INSERT INTO `tb_order` VALUES (38, 5, 25, 1558580155, 1566356155);

-- ----------------------------
-- Table structure for tb_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_record`;
CREATE TABLE `tb_record`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NULL DEFAULT NULL,
  `book_id` int(10) NOT NULL,
  `recordDate` bigint(30) NOT NULL COMMENT '借书日期',
  `backDate` bigint(30) NULL DEFAULT NULL COMMENT '预计还书日期',
  `returnbook` int(1) NULL DEFAULT NULL COMMENT '是否归还',
  `ticketFfee` float NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_record
-- ----------------------------
INSERT INTO `tb_record` VALUES (9, 5, 23, 1523874049, 1524478849, 1, -4.2);
INSERT INTO `tb_record` VALUES (15, 5, 23, 1523882104, 1524486904, 1, -4.2);
INSERT INTO `tb_record` VALUES (16, 5, 23, 1522543636, 1523321236, 1, 0);
INSERT INTO `tb_record` VALUES (17, 5, 29, 1520642836, 1521074836, 1, -8.1);
INSERT INTO `tb_record` VALUES (18, 5, 26, 1523882143, 1524486943, 1, 0);
INSERT INTO `tb_record` VALUES (19, 5, 37, 1523882144, 1524486944, 2, -3);
INSERT INTO `tb_record` VALUES (20, 50, 38, 1523885468, 1524490268, 1, 0);
INSERT INTO `tb_record` VALUES (21, 50, 30, 1523885474, 1524490274, 1, 0);
INSERT INTO `tb_record` VALUES (22, 5, 39, 1555574456, 1556179256, 1, -4);
INSERT INTO `tb_record` VALUES (23, 5, 23, 1558426971, 1590135771, 2, -0.5);
INSERT INTO `tb_record` VALUES (24, 51, 23, 1561270585, 1561875385, 1, NULL);
INSERT INTO `tb_record` VALUES (25, 51, 25, 1561360677, 1561965477, 1, NULL);
INSERT INTO `tb_record` VALUES (26, 51, 41, 1561362500, 1569138500, 2, 0);
INSERT INTO `tb_record` VALUES (27, 51, 23, 1561440926, 1562045726, 1, NULL);

-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  `replyDate` bigint(30) NOT NULL COMMENT '回复日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `tb_reply_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `tb_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `registerDate` bigint(30) NULL DEFAULT NULL COMMENT '注册时间',
  `afterdate` bigint(30) NULL DEFAULT NULL COMMENT '最后一次在线时间',
  `realName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实名字',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `telNum` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `headimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `isOnline` int(1) NULL DEFAULT 0 COMMENT '是否黑名单',
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (51, '201708024121', '0adc3949ba59abbe56e057f20f883e', 1561270392, 1561797177, '刘伟', 21, NULL, '13511814325', '计算机学院', '计科171', '/upload/user/7d67b28339fe429ebf583c681893e159.', NULL, '');
INSERT INTO `tb_user` VALUES (52, '201708024124', '0adc3949ba59abbe56e057f20f883e', 1561796321, NULL, NULL, NULL, NULL, '13511814328', NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
