/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50090
Source Host           : localhost:3306
Source Database       : wshop

Target Server Type    : MYSQL
Target Server Version : 50090
File Encoding         : 65001

Date: 2017-09-05 18:50:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_brand`
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `BrandId` int(11) NOT NULL,
  `BrandName` varchar(50) default NULL,
  `PinyinName` varchar(50) default NULL,
  `BrandLogo` varchar(200) default NULL,
  `IsShow` int(11) default NULL,
  `SortId` int(11) default NULL,
  PRIMARY KEY  (`BrandId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品品牌表';

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO `t_brand` VALUES ('1', '最生活', 'ZSH', null, '1', '1');

-- ----------------------------
-- Table structure for `t_category`
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `CategoryId` int(11) NOT NULL default '0',
  `CategoryName` varchar(100) default NULL,
  `CategoryImg` varchar(200) default NULL,
  `ParentId` int(11) default NULL,
  `IsShow` int(11) default NULL,
  `CategoryPath` varchar(200) default NULL,
  `CategoryArray` varchar(200) default NULL,
  `SortId` int(11) default NULL,
  PRIMARY KEY  (`CategoryId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '测试一级分类1', null, '0', '1', null, '1', '1');
INSERT INTO `t_category` VALUES ('2', '测试二级分类1', null, '1', '1', '测试一级分类1', '1,2', '2');
INSERT INTO `t_category` VALUES ('3', '测试三级分类1', null, '2', '1', '测试一级分类1,测试二级分类1', '1,2,3', '3');
INSERT INTO `t_category` VALUES ('4', '测试一级分类2', null, '0', '1', '测试一级分类2', '1', '1');
INSERT INTO `t_category` VALUES ('5', '测试二级分类2', null, '4', '1', '测试一级分类2,测试二级分类2', '4,5', '1');
INSERT INTO `t_category` VALUES ('6', '测试三级分类2', null, '5', '1', null, '5,6', '1');
INSERT INTO `t_category` VALUES ('7', '测试三级分类3', null, '2', '1', null, '1,2,7', '2');

-- ----------------------------
-- Table structure for `t_dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic`;
CREATE TABLE `t_dynamic` (
  `AttributeId` int(11) NOT NULL auto_increment,
  `ControlType` int(11) default NULL COMMENT '0:TextBox,1:DropdownList,2:RadioList,3:Checkboxes,4:Datepicker,5:ColorSquares,6:MultilineTextbox,7:FileUpload',
  `DataType` int(11) default NULL COMMENT '0:bool,1:int,2:decimal,3:varchar,4:datetime,5:text',
  `ReadOnly` int(11) default NULL COMMENT 'yes:1,no:0',
  `IsMust` int(11) default NULL COMMENT 'yes:1,no:0',
  `SortId` int(11) default NULL,
  `AttributeName` varchar(100) default NULL,
  `PromptText` varchar(100) default NULL,
  PRIMARY KEY  (`AttributeId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='attribute\r\n\r\ncontrol_type：0:TextBox,1:DropdownList';

-- ----------------------------
-- Records of t_dynamic
-- ----------------------------
INSERT INTO `t_dynamic` VALUES ('1', '0', '1', '0', '1', '1', '文本框测试', '文本框测试');
INSERT INTO `t_dynamic` VALUES ('2', '1', '1', '0', '1', '2', '下拉列表测试', '下拉列表测试');
INSERT INTO `t_dynamic` VALUES ('3', '2', '1', '0', '1', '3', '单选框测试', '单选框测试');
INSERT INTO `t_dynamic` VALUES ('4', '3', '1', '0', '1', '4', '多选按钮测试', '多选按钮测试');
INSERT INTO `t_dynamic` VALUES ('5', '3', '1', '0', '1', '1', '颜色', '颜色');

-- ----------------------------
-- Table structure for `t_dynamic_cate_map`
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic_cate_map`;
CREATE TABLE `t_dynamic_cate_map` (
  `Id` int(11) NOT NULL auto_increment,
  `CategoryId` int(11) default NULL,
  `AttributeId` int(11) default NULL,
  `SortId` int(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='attribute_cate_map';

-- ----------------------------
-- Records of t_dynamic_cate_map
-- ----------------------------
INSERT INTO `t_dynamic_cate_map` VALUES ('1', '3', '1', '1');
INSERT INTO `t_dynamic_cate_map` VALUES ('2', '3', '2', '1');
INSERT INTO `t_dynamic_cate_map` VALUES ('3', '3', '3', '1');
INSERT INTO `t_dynamic_cate_map` VALUES ('4', '3', '4', '1');
INSERT INTO `t_dynamic_cate_map` VALUES ('5', '7', '5', '1');

-- ----------------------------
-- Table structure for `t_dynamic_option`
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic_option`;
CREATE TABLE `t_dynamic_option` (
  `OptionId` int(11) NOT NULL auto_increment,
  `AttributeId` int(11) default NULL,
  `OptionValue` varchar(100) default NULL,
  `SortId` int(11) default NULL,
  PRIMARY KEY  (`OptionId`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='属性选项表';

-- ----------------------------
-- Records of t_dynamic_option
-- ----------------------------
INSERT INTO `t_dynamic_option` VALUES ('1', '1', '文本框默认值', '1');
INSERT INTO `t_dynamic_option` VALUES ('2', '2', '下拉列表选项1', '1');
INSERT INTO `t_dynamic_option` VALUES ('3', '2', '下拉列表选项2', '2');
INSERT INTO `t_dynamic_option` VALUES ('4', '2', '下拉列表选项3', '3');
INSERT INTO `t_dynamic_option` VALUES ('5', '3', '单选选项1', '1');
INSERT INTO `t_dynamic_option` VALUES ('6', '3', '单选选项2', '2');
INSERT INTO `t_dynamic_option` VALUES ('7', '3', '单选选项3', '3');
INSERT INTO `t_dynamic_option` VALUES ('8', '4', '多选选项1', '1');
INSERT INTO `t_dynamic_option` VALUES ('9', '4', '多选选项2', '2');
INSERT INTO `t_dynamic_option` VALUES ('10', '4', '多选选项3', '3');
INSERT INTO `t_dynamic_option` VALUES ('11', '4', '多选选项4', '4');
INSERT INTO `t_dynamic_option` VALUES ('12', '5', '白色', '1');
INSERT INTO `t_dynamic_option` VALUES ('13', '5', '黑色', '2');
INSERT INTO `t_dynamic_option` VALUES ('14', '5', '蓝色', '3');
INSERT INTO `t_dynamic_option` VALUES ('15', '5', '灰色', '4');

-- ----------------------------
-- Table structure for `t_dynamic_product_map`
-- ----------------------------
DROP TABLE IF EXISTS `t_dynamic_product_map`;
CREATE TABLE `t_dynamic_product_map` (
  `Id` int(11) NOT NULL auto_increment,
  `ProductId` int(11) NOT NULL default '0',
  `AttributeId` int(11) NOT NULL default '0',
  `OptionValue` varchar(100) default NULL,
  `SortId` int(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=292 DEFAULT CHARSET=utf8 COMMENT='attribute_product_map';

-- ----------------------------
-- Records of t_dynamic_product_map
-- ----------------------------
INSERT INTO `t_dynamic_product_map` VALUES ('238', '42', '5', '蓝色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('237', '42', '5', '黑色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('236', '42', '5', '白色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('235', '1', '5', '灰色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('234', '1', '5', '蓝色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('232', '1', '5', '白色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('233', '1', '5', '黑色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('56', '36', '1', '文本框默认值3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('57', '36', '2', '下拉列表选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('58', '36', '3', '单选选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('59', '36', '4', '多选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('60', '36', '4', '多选选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('61', '36', '4', '多选选项4', null);
INSERT INTO `t_dynamic_product_map` VALUES ('69', '38', '3', '单选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('68', '38', '2', '下拉列表选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('67', '38', '1', '文本框默认值4', null);
INSERT INTO `t_dynamic_product_map` VALUES ('70', '38', '4', '多选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('71', '38', '4', '多选选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('217', '40', '4', '多选选项4', null);
INSERT INTO `t_dynamic_product_map` VALUES ('216', '40', '4', '多选选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('215', '40', '4', '多选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('212', '40', '1', '文本框默认值5', null);
INSERT INTO `t_dynamic_product_map` VALUES ('214', '40', '3', '单选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('213', '40', '2', '下拉列表选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('246', '47', '3', '单选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('245', '47', '2', '下拉列表选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('244', '47', '1', '文本框默认值47', null);
INSERT INTO `t_dynamic_product_map` VALUES ('247', '47', '4', '多选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('248', '47', '4', '多选选项3', null);
INSERT INTO `t_dynamic_product_map` VALUES ('249', '48', '1', '文本框默认值', null);
INSERT INTO `t_dynamic_product_map` VALUES ('250', '48', '2', '下拉列表选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('251', '48', '3', '单选选项1', null);
INSERT INTO `t_dynamic_product_map` VALUES ('252', '48', '4', '多选选项1', null);
INSERT INTO `t_dynamic_product_map` VALUES ('253', '48', '4', '多选选项2', null);
INSERT INTO `t_dynamic_product_map` VALUES ('291', '49', '5', '灰色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('290', '49', '5', '蓝色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('289', '49', '5', '黑色', null);
INSERT INTO `t_dynamic_product_map` VALUES ('288', '49', '5', '白色', null);

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `ProductId` int(11) NOT NULL,
  `Title` varchar(300) default NULL,
  `SearchTitle` varchar(300) default NULL,
  `SellPrice` decimal(9,2) default NULL,
  `Summery` varchar(600) default NULL,
  `CateId` int(11) NOT NULL,
  `CateName` varchar(300) default NULL,
  `BrandName` varchar(300) default NULL,
  `ProductImg` varchar(300) default NULL,
  `ProductAlbum` varchar(1200) default NULL,
  `VerifyStatus` int(11) default NULL,
  `ShelveStatus` int(11) default NULL,
  `UpdateTime` datetime default NULL,
  PRIMARY KEY  (`ProductId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('1', '苹果 IPHONE 8 手机2', 'IPHONE8 苹果 手机2 测试 iphone', '2222.00', '苹果手机 手机中的战斗机2', '7', '测试一级分类1 > 测试二级分类1 > 测试三级分类3', '苹果', '/upload/1504370357722.jpg', '/upload/1504070396916.jpg,/1504070398654.jpg,/upload/1504070400959.jpg,/upload/1504070403388.jpg', '1', '1', '2017-08-22 09:53:35');
INSERT INTO `t_product` VALUES ('36', '苹果 IPHONE 8 手机3', '苹果 IPHONE 8 手机3', '2323.00', '苹果 IPHONE 8 手机3', '3', '测试一级分类1 > 测试二级分类1 > 测试三级分类1', '最生活', '/upload/1504311738691.jpg', '/upload/1504311742076.jpg,/upload/1504311747984.jpg', '0', '0', '2017-09-02 08:23:48');
INSERT INTO `t_product` VALUES ('38', '苹果 IPHONE 8 手机4', '苹果 IPHONE 8 手机4', '2323.00', '苹果 IPHONE 8 手机4', '3', '测试一级分类1 > 测试二级分类1 > 测试三级分类1', '最生活', '/upload/1504311962458.jpg', '/upload/1504311965670.jpg,/upload/1504311970191.jpg', '0', '0', '2017-09-02 08:31:53');
INSERT INTO `t_product` VALUES ('34', '苹果 IPHONE 8 手机2', '苹果 IPHONE 8 手机2', '123.00', '苹果 IPHONE 8 手机2', '7', '测试一级分类1 > 测试二级分类1 > 测试三级分类3', '最生活', '/upload/1504310636467.jpg', '/upload/1504310639529.jpg', '0', '0', '2017-09-02 08:04:53');
INSERT INTO `t_product` VALUES ('40', '苹果 IPHONE 8 手机2', '苹果 IPHONE 8 手机2', '444.00', '苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2', '3', '测试一级分类1 > 测试二级分类1 > 测试三级分类1', '最生活', '/upload/1504312950503.jpg', '/upload/1504312953614.jpg,/upload/1504312957603.jpg', '0', '0', '2017-09-02 08:45:15');
INSERT INTO `t_product` VALUES ('42', '商品标题商品标题商品标题', '搜索关键词搜索关键词搜索关键词', '444.00', '内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要', '7', '测试一级分类1 > 测试二级分类1 > 测试三级分类3', '最生活', '/upload/1504450040744.jpg', '/upload/1504450044161.jpg,/1504450047705.jpg,/upload/1504450053069.jpg,/upload/1504450058749.jpg', '0', '0', '2017-09-03 22:50:39');
INSERT INTO `t_product` VALUES ('47', ' 商品标题47', '搜索关键词47', '123123.00', '内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要内容摘要', '3', '测试一级分类1 > 测试二级分类1 > 测试三级分类1', '最生活', '/upload/1504488647475.jpg', '/upload/1504488652140.jpg,/upload/1504488655123.jpg,/upload/1504488658880.jpg', '0', '0', '2017-09-04 09:43:42');
INSERT INTO `t_product` VALUES ('48', ' 商品标题48', ' 商品标题48 商品标题48', '234.00', ' 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48', '3', '测试一级分类1 > 测试二级分类1 > 测试三级分类1', '最生活', '/upload/1504490302598.jpg', '/upload/1504490304921.jpg,/upload/1504490307064.jpg,/upload/1504490309286.jpg', '0', '0', '2017-09-04 10:00:28');
INSERT INTO `t_product` VALUES ('49', '商品标题49', '商品标题49', '123.00', '商品标题49商品标题49商品标题49商品标题49', '7', '测试一级分类1 > 测试二级分类1 > 测试三级分类3', '最生活', '/upload/1504491300525.jpg', '/upload/1504491302861.jpg,/upload/1504491305193.jpg,/upload/1504491307200.jpg,/upload/1504491310652.jpg', '0', '0', '2017-09-04 10:18:48');

-- ----------------------------
-- Table structure for `t_product_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_attribute`;
CREATE TABLE `t_product_attribute` (
  `AttributeId` int(11) NOT NULL,
  `AttributeName` varchar(100) default NULL,
  `ProductId` int(11) NOT NULL default '0',
  PRIMARY KEY  (`AttributeId`,`ProductId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='INSERT [dbo].[ProductAttribute] ([Id], [Name], [Description]';

-- ----------------------------
-- Records of t_product_attribute
-- ----------------------------
INSERT INTO `t_product_attribute` VALUES ('1', '颜色', '1');
INSERT INTO `t_product_attribute` VALUES ('2', '内存', '1');
INSERT INTO `t_product_attribute` VALUES ('3', '套装', '1');
INSERT INTO `t_product_attribute` VALUES ('568494', '运营商', '1');
INSERT INTO `t_product_attribute` VALUES ('173194', '账期', '1');
INSERT INTO `t_product_attribute` VALUES ('896442', '颜色', '40');
INSERT INTO `t_product_attribute` VALUES ('79671', '内存', '40');
INSERT INTO `t_product_attribute` VALUES ('71373', '颜色', '34');
INSERT INTO `t_product_attribute` VALUES ('87458', '颜色', '42');
INSERT INTO `t_product_attribute` VALUES ('696462', '颜色', '0');
INSERT INTO `t_product_attribute` VALUES ('705917', '尺码', '0');
INSERT INTO `t_product_attribute` VALUES ('696462', '颜色', '47');
INSERT INTO `t_product_attribute` VALUES ('705917', '尺码', '47');
INSERT INTO `t_product_attribute` VALUES ('335077', '颜色', '48');
INSERT INTO `t_product_attribute` VALUES ('341314', '尺码', '48');
INSERT INTO `t_product_attribute` VALUES ('338582', '颜色', '49');
INSERT INTO `t_product_attribute` VALUES ('364836', '材质', '49');

-- ----------------------------
-- Table structure for `t_product_attribute_map`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_attribute_map`;
CREATE TABLE `t_product_attribute_map` (
  `Id` int(11) NOT NULL auto_increment,
  `ProductId` int(11) default NULL,
  `OptionId` int(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3374 DEFAULT CHARSET=utf8 COMMENT='INSERT [dbo].[Product_ProductAttribute_Mapping] ([Id], [Prod';

-- ----------------------------
-- Records of t_product_attribute_map
-- ----------------------------
INSERT INTO `t_product_attribute_map` VALUES ('3318', '40', '92986');
INSERT INTO `t_product_attribute_map` VALUES ('3317', '40', '87707');
INSERT INTO `t_product_attribute_map` VALUES ('3268', '38', '2785150');
INSERT INTO `t_product_attribute_map` VALUES ('3267', '36', '9071114');
INSERT INTO `t_product_attribute_map` VALUES ('3266', '36', '8447509');
INSERT INTO `t_product_attribute_map` VALUES ('3332', '42', '99046');
INSERT INTO `t_product_attribute_map` VALUES ('3327', '34', '9087161');
INSERT INTO `t_product_attribute_map` VALUES ('3259', '23', '9740193');
INSERT INTO `t_product_attribute_map` VALUES ('3331', '1', '9169959');
INSERT INTO `t_product_attribute_map` VALUES ('3330', '1', '9114572');
INSERT INTO `t_product_attribute_map` VALUES ('3329', '1', '9071114');
INSERT INTO `t_product_attribute_map` VALUES ('3328', '1', '8447509');
INSERT INTO `t_product_attribute_map` VALUES ('3316', '40', '7981805');
INSERT INTO `t_product_attribute_map` VALUES ('3315', '40', '4907914');
INSERT INTO `t_product_attribute_map` VALUES ('3333', '42', '110536');
INSERT INTO `t_product_attribute_map` VALUES ('3343', '48', '366141');
INSERT INTO `t_product_attribute_map` VALUES ('3342', '48', '357510');
INSERT INTO `t_product_attribute_map` VALUES ('3341', '47', '8727869');
INSERT INTO `t_product_attribute_map` VALUES ('3340', '47', '8719942');
INSERT INTO `t_product_attribute_map` VALUES ('3339', '47', '8715617');
INSERT INTO `t_product_attribute_map` VALUES ('3373', '49', '1353690');
INSERT INTO `t_product_attribute_map` VALUES ('3372', '49', '1348519');
INSERT INTO `t_product_attribute_map` VALUES ('3371', '49', '1372742');

-- ----------------------------
-- Table structure for `t_product_attribute_value`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_attribute_value`;
CREATE TABLE `t_product_attribute_value` (
  `OptionId` int(11) NOT NULL,
  `AttributeId` int(11) NOT NULL default '0',
  `OptionName` varchar(100) default NULL,
  `OptionImg` varchar(300) default NULL,
  `AttributeName` varchar(300) default NULL,
  PRIMARY KEY  (`OptionId`,`AttributeId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='INSERT [dbo].[ProductAttributeValue] ([Id], [ProductAttribut';

-- ----------------------------
-- Records of t_product_attribute_value
-- ----------------------------
INSERT INTO `t_product_attribute_value` VALUES ('8447509', '1', '黑色', '/upload/1503978437980.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('8945106', '1', '金色', '/upload/1503978935215.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('8967620', '1', '银色', '/upload/1503978957464.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('9056447', '1', '玫瑰金', '/upload/1503978998692.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('9071114', '1', '红色特别版', '/upload/1503979061865.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('9114572', '2', '32GB', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('9169959', '2', '256GB', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('9200973', '2', '512GB', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('1526473', '519802', '红色', '', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('1548989', '519802', '黑色', '/upload/1504281546995.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('4907416', '894466', '红色', '/upload/1504284904557.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('5640449', '525028', '红色', '', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('9740193', '726929', '红色', '/upload/1504309737910.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('2576936', '554920', '红色', '/upload/1504312575692.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('2785150', '771499', '红色', '/upload/1504312782246.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('2987573', '979490', '红色', '/upload/1504312986754.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('3001785', '995747', '64G', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('3008000', '995747', '128G', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('3022050', '979490', '黑色', '/upload/1504313018318.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('4907914', '896442', '红色', '/upload/1504314905006.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('7981805', '896442', '黑色', '/upload/1504317981119.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('87707', '79671', '64G', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('92986', '79671', '128G', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('100207', '79671', '256G', '', '内存');
INSERT INTO `t_product_attribute_value` VALUES ('9087161', '71373', '黑色', '/upload/1504399085640.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('99046', '87458', '黑色', '/upload/1504450097263.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('110536', '87458', '白色', '/upload/1504450108934.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('8715617', '696462', '白色', '', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('8719942', '696462', '黑色', '', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('8727869', '705917', 'L', '', '尺码');
INSERT INTO `t_product_attribute_value` VALUES ('8731632', '705917', 'M', '', '尺码');
INSERT INTO `t_product_attribute_value` VALUES ('8734568', '705917', 'S', '', '尺码');
INSERT INTO `t_product_attribute_value` VALUES ('1348519', '338582', '卡其色', '/upload/1504495553840.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('1353690', '338582', '墨绿色', '/upload/1504495557469.jpg', '颜色');
INSERT INTO `t_product_attribute_value` VALUES ('1372742', '364836', '全棉', '/upload/1504495545520.jpg', '材质');
INSERT INTO `t_product_attribute_value` VALUES ('1381032', '364836', '莫奈尔', '/upload/1504495548672.jpg', '材质');

-- ----------------------------
-- Table structure for `t_product_ext`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_ext`;
CREATE TABLE `t_product_ext` (
  `ProductId` int(11) NOT NULL,
  `Content` mediumtext,
  `ServiceInfo` varchar(1000) default NULL,
  PRIMARY KEY  (`ProductId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_ext
-- ----------------------------
INSERT INTO `t_product_ext` VALUES ('1', '<p>\r\n	苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2222222222222222222\r\n</p>\r\n<p>\r\n	<img src=\"/1504076395359.jpg\" alt=\"\" /><img src=\"/1504076415511.jpg\" alt=\"\" /><img src=\"/1504076415575.jpg\" alt=\"\" /> \r\n</p>', '商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务22222222222222');
INSERT INTO `t_product_ext` VALUES ('34', '苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2', '苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2苹果 IPHONE 8 手机2');
INSERT INTO `t_product_ext` VALUES ('36', '苹果 IPHONE 8 手机3苹果 IPHONE 8 手机3苹果 IPHONE 8 手机3苹果 IPHONE 8 手机3苹果 IPHONE 8 手机3', '苹果 IPHONE 8 手机3苹果 IPHONE 8 手机3苹果 IPHONE 8 手机3');
INSERT INTO `t_product_ext` VALUES ('38', '苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4', '苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4苹果 IPHONE 8 手机4');
INSERT INTO `t_product_ext` VALUES ('40', '<p>\r\n	<img border=\"0\" align=\"middle\" class=\"\" src=\"https://img10.360buyimg.com/imgzone/jfs/t5815/214/2806419833/100233/b87f5df1/5934bd8eN0f87e47c.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"></span><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"></span><img width=\"750\" height=\"310\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t6028/111/2017352894/184268/f264646/593912c0Ndfcb38de.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"311\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t5824/30/3287200161/209909/65fe906e/593912c0N37097ec4.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"720\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t6334/302/92642282/293015/ef7bca1e/593912c0N80a662d9.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"910\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t6658/226/67374635/271364/a9057c01/593912c0N6ec60f4a.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"821\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t6325/101/85297949/282853/a63d78b1/593912c0Nf70c9a15.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"417\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t6421/359/90848871/193479/643a9079/593912bbNfa1e2040.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"685\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t6232/248/81908945/264624/951de444/593912c0N746c24a6.jpg\" /><span style=\"color:#666666;font-family:tahoma, arial, \" background-color:#ffffff;\"=\"\"> </span><img width=\"750\" height=\"336\" alt=\"\" class=\"\" src=\"https://m.360buyimg.com/mobilecms/jfs/t5806/116/3238139708/118691/32f3165c/593912c0N103909cd.jpg\" /> \r\n</p>\r\n<p>\r\n	<img src=\"https://m.360buyimg.com/mobilecms/jfs/t6028/111/2017352894/184268/f264646/593912c0Ndfcb38de.jpg\" /> \r\n</p>', '本产品全国联保，享受三包服务，质保期为：一年质保（已激活的iPhone无质量问题不支持7天无理由退换货）\r\n如因质量问题或故障，凭厂商维修中心或特约维修点的质量检测证明，享受7日内退货，15日内换货，15日以上在质保期内享受免费保修等三包服务！');
INSERT INTO `t_product_ext` VALUES ('42', '<span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span><span style=\"color:#666666;font-family:&quot;font-size:14px;background-color:#FFFFFF;\">商品详情</span>', '商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务商品服务');
INSERT INTO `t_product_ext` VALUES ('47', '<span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47<span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span><span style=\"color:#666666;font-family:\" font-size:14px;background-color:#ffffff;\"=\"\">商品详情47</span></span>', '商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47商品服务47');
INSERT INTO `t_product_ext` VALUES ('48', '&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48&nbsp;商品标题48', ' 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48 商品标题48');
INSERT INTO `t_product_ext` VALUES ('49', '商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49', '商品标题49商品标题49商品标题49商品标题49商品标题49商品标题49');

-- ----------------------------
-- Table structure for `t_product_gift_map`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_gift_map`;
CREATE TABLE `t_product_gift_map` (
  `Id` int(11) NOT NULL auto_increment,
  `ProductId` int(11) default NULL,
  `ProductId2` int(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_gift_map
-- ----------------------------
INSERT INTO `t_product_gift_map` VALUES ('117', '1', '1');
INSERT INTO `t_product_gift_map` VALUES ('3', '23', '1');
INSERT INTO `t_product_gift_map` VALUES ('4', '0', '1');
INSERT INTO `t_product_gift_map` VALUES ('112', '34', '34');
INSERT INTO `t_product_gift_map` VALUES ('7', '36', '34');
INSERT INTO `t_product_gift_map` VALUES ('8', '36', '1');
INSERT INTO `t_product_gift_map` VALUES ('105', '40', '40');
INSERT INTO `t_product_gift_map` VALUES ('104', '40', '38');
INSERT INTO `t_product_gift_map` VALUES ('103', '40', '36');
INSERT INTO `t_product_gift_map` VALUES ('102', '40', '36');
INSERT INTO `t_product_gift_map` VALUES ('116', '1', '1');
INSERT INTO `t_product_gift_map` VALUES ('115', '1', '1');
INSERT INTO `t_product_gift_map` VALUES ('101', '40', '36');
INSERT INTO `t_product_gift_map` VALUES ('100', '40', '1');
INSERT INTO `t_product_gift_map` VALUES ('99', '40', '1');
INSERT INTO `t_product_gift_map` VALUES ('98', '40', '1');
INSERT INTO `t_product_gift_map` VALUES ('113', '34', '1');
INSERT INTO `t_product_gift_map` VALUES ('114', '34', '1');
INSERT INTO `t_product_gift_map` VALUES ('118', '42', '40');
INSERT INTO `t_product_gift_map` VALUES ('119', '42', '34');
INSERT INTO `t_product_gift_map` VALUES ('120', '42', '36');
INSERT INTO `t_product_gift_map` VALUES ('121', '42', '1');
INSERT INTO `t_product_gift_map` VALUES ('125', '47', '1');
INSERT INTO `t_product_gift_map` VALUES ('124', '47', '36');
INSERT INTO `t_product_gift_map` VALUES ('126', '48', '36');
INSERT INTO `t_product_gift_map` VALUES ('127', '48', '1');
INSERT INTO `t_product_gift_map` VALUES ('151', '49', '38');
INSERT INTO `t_product_gift_map` VALUES ('150', '49', '34');
INSERT INTO `t_product_gift_map` VALUES ('149', '49', '1');

-- ----------------------------
-- Table structure for `t_product_related_map`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_related_map`;
CREATE TABLE `t_product_related_map` (
  `Id` int(11) NOT NULL auto_increment,
  `ProductId` int(11) default NULL,
  `ProductId2` int(11) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product_related_map
-- ----------------------------
INSERT INTO `t_product_related_map` VALUES ('55', '40', '34');
INSERT INTO `t_product_related_map` VALUES ('54', '40', '36');
INSERT INTO `t_product_related_map` VALUES ('4', '23', '1');
INSERT INTO `t_product_related_map` VALUES ('5', '0', '1');
INSERT INTO `t_product_related_map` VALUES ('58', '34', '40');
INSERT INTO `t_product_related_map` VALUES ('8', '36', '34');
INSERT INTO `t_product_related_map` VALUES ('9', '36', '1');
INSERT INTO `t_product_related_map` VALUES ('53', '40', '36');
INSERT INTO `t_product_related_map` VALUES ('52', '40', '1');
INSERT INTO `t_product_related_map` VALUES ('61', '1', '34');
INSERT INTO `t_product_related_map` VALUES ('59', '34', '34');
INSERT INTO `t_product_related_map` VALUES ('60', '34', '1');
INSERT INTO `t_product_related_map` VALUES ('62', '42', '36');
INSERT INTO `t_product_related_map` VALUES ('63', '42', '40');
INSERT INTO `t_product_related_map` VALUES ('64', '42', '34');
INSERT INTO `t_product_related_map` VALUES ('65', '42', '38');
INSERT INTO `t_product_related_map` VALUES ('73', '47', '34');
INSERT INTO `t_product_related_map` VALUES ('72', '47', '38');
INSERT INTO `t_product_related_map` VALUES ('71', '47', '36');
INSERT INTO `t_product_related_map` VALUES ('70', '47', '1');
INSERT INTO `t_product_related_map` VALUES ('74', '48', '34');
INSERT INTO `t_product_related_map` VALUES ('75', '48', '36');
INSERT INTO `t_product_related_map` VALUES ('107', '49', '36');
INSERT INTO `t_product_related_map` VALUES ('106', '49', '34');
INSERT INTO `t_product_related_map` VALUES ('105', '49', '36');
INSERT INTO `t_product_related_map` VALUES ('104', '49', '34');

-- ----------------------------
-- Table structure for `t_product_sku`
-- ----------------------------
DROP TABLE IF EXISTS `t_product_sku`;
CREATE TABLE `t_product_sku` (
  `SkuId` int(11) NOT NULL,
  `ProductId` int(11) default NULL,
  `StockQuantity` int(11) default NULL,
  `CommodityCode` varchar(100) default NULL,
  `SkuPrice` decimal(18,2) default NULL,
  `SkuImg1` varchar(500) default NULL,
  `SkuImg2` varchar(1200) default NULL,
  `Attributes` varchar(1500) default NULL,
  `AttributeName` varchar(300) default NULL,
  `IsDelete` int(11) default NULL,
  PRIMARY KEY  (`SkuId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品SKU表\r\nINSERT INTO [dbo].[ProductAttributeCombination]';

-- ----------------------------
-- Records of t_product_sku
-- ----------------------------
INSERT INTO `t_product_sku` VALUES ('7388560', '40', '0', '', '0.00', '/upload/1504317479850.jpg', '/upload/1504317483457.jpg,/upload/1504317486836.jpg', '4907914', '红色', '1');
INSERT INTO `t_product_sku` VALUES ('7983882', '40', '0', '', '0.00', '/upload/1504317991885.jpg', '/upload/1504317995430.jpg,/upload/1504318000053.jpg', '7981805', '黑色', '1');
INSERT INTO `t_product_sku` VALUES ('7139425', '1', '22', '123123', '333.00', '/upload/1504370445545.jpg', '/upload/1504370459410.jpg', '8447509,9114572', '黑色,32GB', '0');
INSERT INTO `t_product_sku` VALUES ('7139426', '1', '22', '123123', '22.00', '/upload/1504370448858.jpg', '/upload/1504370462506.jpg', '8447509,9169959', '黑色,256GB', '0');
INSERT INTO `t_product_sku` VALUES ('7139427', '1', '22', '123123', '222.00', '/upload/1504370452359.jpg', '/upload/1504370466151.jpg', '9071114,9114572', '红色特别版,32GB', '0');
INSERT INTO `t_product_sku` VALUES ('7139428', '1', '222', '1232', '2222.00', '/upload/1504370455951.jpg', '/upload/1504370474841.jpg', '9071114,9169959', '红色特别版,256GB', '0');
INSERT INTO `t_product_sku` VALUES ('103753', '40', '123', '1231', '123.00', '/upload/1504370135852.jpg', '/upload/1504370155960.jpg,/upload/1504370159674.jpg,/upload/1504370162745.jpg,/upload/1504370166370.jpg', '4907914,87707', '红色,64G', '0');
INSERT INTO `t_product_sku` VALUES ('103754', '40', '132', '123', '333.00', '/upload/1504370139106.jpg', '/upload/1504370170386.jpg,/upload/1504370174940.jpg,/upload/1504370180843.jpg,/upload/1504370184929.jpg', '4907914,92986', '红色,128G', '0');
INSERT INTO `t_product_sku` VALUES ('103755', '40', '123', '123', '222.00', '/upload/1504370143945.jpg', '/upload/1504370188784.jpg,/upload/1504370192154.jpg,/upload/1504370196466.jpg,/upload/1504370201206.jpg', '7981805,87707', '黑色,64G', '0');
INSERT INTO `t_product_sku` VALUES ('103756', '40', '123', '123', '444.00', '/upload/1504370151516.jpg', '/upload/1504370207323.jpg,/upload/1504370214482.jpg,/upload/1504370220487.jpg,/upload/1504370226238.jpg', '7981805,92986', '黑色,128G', '0');
INSERT INTO `t_product_sku` VALUES ('9088642', '34', '123', '123', '123.00', '/upload/1504399098860.jpg', '/upload/1504399103248.jpg,/upload/1504399106456.jpg,/upload/1504399110909.jpg', '9087161', '黑色', '0');
INSERT INTO `t_product_sku` VALUES ('115625', '42', '332', '123123', '123.00', '/upload/1504450137276.jpg', '/upload/1504450149322.jpg,/upload/1504450153140.jpg,/upload/1504450156709.jpg,/upload/1504450162907.jpg', '99046', '黑色', '0');
INSERT INTO `t_product_sku` VALUES ('115626', '42', '2323', '123123', '444.00', '/upload/1504450144754.jpg', '/upload/1504450168017.jpg,/upload/1504450173326.jpg,/upload/1504450178819.png,/upload/1504450184696.jpg,/upload/1504450191268.jpg', '110536', '白色', '0');
INSERT INTO `t_product_sku` VALUES ('139677', '47', '123', '123123', '123123.00', '', '', '8715617,8727869', '白色,L', '0');
INSERT INTO `t_product_sku` VALUES ('139678', '47', '123', '123123', '123123.00', '', '', '8719942,8727869', '黑色,L', '0');
INSERT INTO `t_product_sku` VALUES ('380872', '48', '234', '234234', '234.00', '/upload/1504490394036.jpg', '/upload/1504490399436.jpg,/upload/1504490403881.jpg,/upload/1504490410401.jpg', '357510', 'L', '0');
INSERT INTO `t_product_sku` VALUES ('380873', '48', '234', '234234', '234.00', '/upload/1504490396606.jpg', '/upload/1504490401867.jpg,/upload/1504490405998.jpg,/upload/1504490408168.jpg', '366141', 'M', '0');
INSERT INTO `t_product_sku` VALUES ('1385642', '49', '123', '123', '123.00', '/upload/1504491448525.jpg', '/upload/1504491458033.jpg,/upload/1504491468755.jpg,/upload/1504491483290.jpg', '1372742,1348519', '全棉,卡其色', '0');
INSERT INTO `t_product_sku` VALUES ('1385643', '49', '0', '', '0.00', '/upload/1504491450419.jpg', '/upload/1504491460025.jpg,/upload/1504491473750.jpg,/upload/1504491480219.jpg', '1381032,1348519', '莫奈尔,卡其色', '1');
INSERT INTO `t_product_sku` VALUES ('1385644', '49', '123', '123', '123.00', '/upload/1504491453187.jpg', '/upload/1504491461885.jpg,/upload/1504491486666.jpg,/upload/1504491489456.jpg', '1372742,1353690', '全棉,墨绿色', '0');
INSERT INTO `t_product_sku` VALUES ('1385645', '49', '0', '', '0.00', '/upload/1504491455734.jpg', '/upload/1504491465744.jpg,/upload/1504491476506.jpg,/upload/1504491494435.png', '1381032,1353690', '莫奈尔,墨绿色', '1');

-- ----------------------------
-- Table structure for `t_sequence_int`
-- ----------------------------
DROP TABLE IF EXISTS `t_sequence_int`;
CREATE TABLE `t_sequence_int` (
  `id` int(11) NOT NULL auto_increment,
  `stub` char(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sequence_int
-- ----------------------------
INSERT INTO `t_sequence_int` VALUES ('1', 'a');
INSERT INTO `t_sequence_int` VALUES ('2', 'a');
INSERT INTO `t_sequence_int` VALUES ('3', 'a');
INSERT INTO `t_sequence_int` VALUES ('4', 'a');
INSERT INTO `t_sequence_int` VALUES ('5', 'a');
INSERT INTO `t_sequence_int` VALUES ('6', 'a');
INSERT INTO `t_sequence_int` VALUES ('7', 'a');
INSERT INTO `t_sequence_int` VALUES ('8', 'a');
INSERT INTO `t_sequence_int` VALUES ('9', 'a');
INSERT INTO `t_sequence_int` VALUES ('10', 'a');
INSERT INTO `t_sequence_int` VALUES ('11', 'a');
INSERT INTO `t_sequence_int` VALUES ('12', 'a');
INSERT INTO `t_sequence_int` VALUES ('13', 'a');
INSERT INTO `t_sequence_int` VALUES ('14', 'a');
INSERT INTO `t_sequence_int` VALUES ('15', 'a');
INSERT INTO `t_sequence_int` VALUES ('16', 'a');
INSERT INTO `t_sequence_int` VALUES ('17', 'a');
INSERT INTO `t_sequence_int` VALUES ('18', 'a');
INSERT INTO `t_sequence_int` VALUES ('19', 'a');
INSERT INTO `t_sequence_int` VALUES ('20', 'a');
INSERT INTO `t_sequence_int` VALUES ('21', 'a');
INSERT INTO `t_sequence_int` VALUES ('22', 'a');
INSERT INTO `t_sequence_int` VALUES ('23', 'a');
INSERT INTO `t_sequence_int` VALUES ('24', 'a');
INSERT INTO `t_sequence_int` VALUES ('25', 'a');
INSERT INTO `t_sequence_int` VALUES ('26', 'a');
INSERT INTO `t_sequence_int` VALUES ('27', 'a');
INSERT INTO `t_sequence_int` VALUES ('28', 'a');
INSERT INTO `t_sequence_int` VALUES ('29', 'a');
INSERT INTO `t_sequence_int` VALUES ('30', 'a');
INSERT INTO `t_sequence_int` VALUES ('31', 'a');
INSERT INTO `t_sequence_int` VALUES ('32', 'a');
INSERT INTO `t_sequence_int` VALUES ('33', 'a');
INSERT INTO `t_sequence_int` VALUES ('34', 'a');
INSERT INTO `t_sequence_int` VALUES ('35', 'a');
INSERT INTO `t_sequence_int` VALUES ('36', 'a');
INSERT INTO `t_sequence_int` VALUES ('37', 'a');
INSERT INTO `t_sequence_int` VALUES ('38', 'a');
INSERT INTO `t_sequence_int` VALUES ('39', 'a');
INSERT INTO `t_sequence_int` VALUES ('40', 'a');
INSERT INTO `t_sequence_int` VALUES ('41', 'a');
INSERT INTO `t_sequence_int` VALUES ('42', 'a');
INSERT INTO `t_sequence_int` VALUES ('43', 'a');
INSERT INTO `t_sequence_int` VALUES ('44', 'a');
INSERT INTO `t_sequence_int` VALUES ('45', 'a');
INSERT INTO `t_sequence_int` VALUES ('46', 'a');
INSERT INTO `t_sequence_int` VALUES ('47', 'a');
INSERT INTO `t_sequence_int` VALUES ('48', 'a');
INSERT INTO `t_sequence_int` VALUES ('49', 'a');
