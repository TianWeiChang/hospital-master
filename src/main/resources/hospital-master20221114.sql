/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : hospital-master

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2022-11-14 17:26:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bed_info`
-- ----------------------------
DROP TABLE IF EXISTS `bed_info`;
CREATE TABLE `bed_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `bed_name` varchar(255) NOT NULL COMMENT '住院床位名称',
  `price` int NOT NULL COMMENT '价格',
  `department_name` varchar(255) NOT NULL COMMENT '科室名称',
  `department_id` int NOT NULL COMMENT '科室id',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='住院床位表';

-- ----------------------------
-- Records of bed_info
-- ----------------------------
INSERT INTO `bed_info` VALUES ('1', '床位1', '1010', '内科', '1', '1', '0', '2022-10-26 14:34:06', '2022-10-26 14:34:06');

-- ----------------------------
-- Table structure for `charge_type_info`
-- ----------------------------
DROP TABLE IF EXISTS `charge_type_info`;
CREATE TABLE `charge_type_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `type_name` varchar(255) NOT NULL COMMENT '类型名称',
  `ratio` int NOT NULL COMMENT '比例',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收费类型表';

-- ----------------------------
-- Records of charge_type_info
-- ----------------------------
INSERT INTO `charge_type_info` VALUES ('1', '农村医疗合作社', '35', '1', '0', '2022-10-26 14:57:03', '2022-10-26 14:57:03');

-- ----------------------------
-- Table structure for `department_info`
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `department_Name` varchar(255) NOT NULL COMMENT '科室名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：不挂号',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='科室信息表';

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES ('1', '内科', '1', '0', '2022-10-19 19:47:11', '2022-10-19 19:47:11');
INSERT INTO `department_info` VALUES ('2', '外科', '1', '0', '2022-10-23 18:26:19', '2022-10-23 18:26:19');
INSERT INTO `department_info` VALUES ('3', '儿科', '1', '0', '2022-10-23 18:26:24', '2022-10-23 18:26:24');
INSERT INTO `department_info` VALUES ('4', '妇科', '1', '0', '2022-10-23 18:26:30', '2022-10-23 18:26:30');

-- ----------------------------
-- Table structure for `doctor_duty`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_duty`;
CREATE TABLE `doctor_duty` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `doctor_id` int NOT NULL COMMENT '医生id',
  `department_id` int NOT NULL COMMENT '科室id',
  `register_type_id` int NOT NULL COMMENT '挂号类型id',
  `start_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='医生值班表';

-- ----------------------------
-- Records of doctor_duty
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_info`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_info`;
CREATE TABLE `doctor_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `doctor_Name` varchar(255) NOT NULL COMMENT '医生姓名',
  `department_id` int NOT NULL COMMENT '科室id',
  `register_type_id` int NOT NULL COMMENT '挂号类型id',
  `type_id` int NOT NULL COMMENT '类型id 门诊部、住院部（用枚举实现）',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：不挂号',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='挂号类型表';

-- ----------------------------
-- Records of doctor_info
-- ----------------------------
INSERT INTO `doctor_info` VALUES ('1', '内科专家医生', '1', '1', '1', '1', '0', '2022-10-19 21:09:13', '2022-10-19 21:17:06');
INSERT INTO `doctor_info` VALUES ('2', '门诊部医生', '1', '1', '0', '1', '0', '2022-10-19 22:07:28', '2022-10-19 22:07:28');
INSERT INTO `doctor_info` VALUES ('3', '张三', '1', '2', '1', '1', '0', '2022-10-23 18:26:49', '2022-10-23 18:26:49');
INSERT INTO `doctor_info` VALUES ('4', '王五', '3', '1', '1', '1', '0', '2022-10-23 18:31:21', '2022-10-23 18:31:21');
INSERT INTO `doctor_info` VALUES ('5', 'tian', '3', '1', '0', '1', '0', '2022-11-01 16:21:57', '2022-11-01 16:21:57');

-- ----------------------------
-- Table structure for `doctor_leave`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_leave`;
CREATE TABLE `doctor_leave` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `department_id` int DEFAULT NULL,
  `register_type_id` int DEFAULT NULL,
  `doctor_id` int NOT NULL COMMENT '医生id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `start_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='医生请假表';

-- ----------------------------
-- Records of doctor_leave
-- ----------------------------

-- ----------------------------
-- Table structure for `doctor_register_time_slot`
-- ----------------------------
DROP TABLE IF EXISTS `doctor_register_time_slot`;
CREATE TABLE `doctor_register_time_slot` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `doctor_id` int NOT NULL COMMENT '医生id',
  `register_time_slot_id` int NOT NULL COMMENT '挂号预约时间段id',
  `register_total` int NOT NULL COMMENT '已约人数',
  `register_date` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '预约日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `doctor_slot_index` (`doctor_id`,`register_time_slot_id`,`register_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='医生预约挂号时间段表';

-- ----------------------------
-- Records of doctor_register_time_slot
-- ----------------------------
INSERT INTO `doctor_register_time_slot` VALUES ('1', '1', '1', '0', '2022-11-14 00:00:00');

-- ----------------------------
-- Table structure for `drug_info`
-- ----------------------------
DROP TABLE IF EXISTS `drug_info`;
CREATE TABLE `drug_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `drug_name` varchar(255) NOT NULL COMMENT '药品名称',
  `product_address_id` int NOT NULL COMMENT '鑽搧浜у湴琛╥d',
  `unit_id` int NOT NULL COMMENT '计量单位表id',
  `price` int NOT NULL COMMENT '价格表',
  `drug_type_id` int NOT NULL COMMENT '药品类型ID',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='药品字典表';

-- ----------------------------
-- Records of drug_info
-- ----------------------------
INSERT INTO `drug_info` VALUES ('4', '板蓝根', '3', '1', '25', '1', '0');
INSERT INTO `drug_info` VALUES ('5', '老鼠屎', '4', '3', '15', '2', '0');
INSERT INTO `drug_info` VALUES ('6', '板蓝根1号', '2', '1', '10', '1', '0');
INSERT INTO `drug_info` VALUES ('7', '板蓝根2号', '4', '1', '10', '1', '0');
INSERT INTO `drug_info` VALUES ('8', '板蓝根3号', '3', '1', '10', '1', '0');
INSERT INTO `drug_info` VALUES ('9', '22', '1', '1', '1', '1', '0');
INSERT INTO `drug_info` VALUES ('10', '板蓝根5号', '4', '1', '10', '1', '0');
INSERT INTO `drug_info` VALUES ('11', '猪八戒', '2', '1', '12', '2', '0');

-- ----------------------------
-- Table structure for `drug_info_operation_log`
-- ----------------------------
DROP TABLE IF EXISTS `drug_info_operation_log`;
CREATE TABLE `drug_info_operation_log` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `before_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '鍙樻洿鍓嶅唴瀹?',
  `after_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '閸欐ɑ娲块崥搴″敶鐎?',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='药品字典变更日志记录表';

-- ----------------------------
-- Records of drug_info_operation_log
-- ----------------------------
INSERT INTO `drug_info_operation_log` VALUES ('1', '1', null, '{\"drugName\":\"老鼠屎\",\"drugTypeId\":2,\"id\":5,\"price\":1,\"productAddressId\":4,\"status\":0,\"unitId\":3}', '2022-11-03 21:56:18');
INSERT INTO `drug_info_operation_log` VALUES ('2', '1', null, '{\"drugName\":\"板蓝根5号\",\"drugTypeId\":1,\"id\":10,\"price\":10,\"productAddressId\":4,\"status\":0,\"unitId\":1}', '2022-11-03 22:56:06');
INSERT INTO `drug_info_operation_log` VALUES ('3', '1', null, '{\"drugName\":\"猪八戒\",\"drugTypeId\":2,\"id\":11,\"price\":12,\"productAddressId\":2,\"status\":0,\"unitId\":1}', '2022-11-04 19:30:31');
INSERT INTO `drug_info_operation_log` VALUES ('4', '1', '{\"drugName\":\"板蓝根\",\"drugTypeId\":1,\"id\":4,\"price\":19,\"productAddressId\":3,\"status\":0,\"unitId\":1}', '{\"drugName\":\"板蓝根\",\"drugTypeId\":1,\"id\":4,\"price\":21,\"productAddressId\":3,\"status\":0,\"unitId\":1}', '2022-11-06 11:59:02');
INSERT INTO `drug_info_operation_log` VALUES ('5', '1', '{\"drugName\":\"板蓝根\",\"drugTypeId\":1,\"id\":4,\"price\":21,\"productAddressId\":3,\"status\":0,\"unitId\":1}', '{\"drugName\":\"板蓝根\",\"drugTypeId\":1,\"id\":4,\"price\":25,\"productAddressId\":3,\"status\":0,\"unitId\":1}', '2022-11-06 12:01:06');

-- ----------------------------
-- Table structure for `drug_product_address_info`
-- ----------------------------
DROP TABLE IF EXISTS `drug_product_address_info`;
CREATE TABLE `drug_product_address_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `drug_product_address_Name` varchar(255) NOT NULL COMMENT '药品产地名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='药品产地表';

-- ----------------------------
-- Records of drug_product_address_info
-- ----------------------------
INSERT INTO `drug_product_address_info` VALUES ('1', '湛江', '1', '0', '2022-10-20 19:16:17', '2022-10-20 19:16:17');
INSERT INTO `drug_product_address_info` VALUES ('2', '深圳', '1', '0', '2022-10-20 19:17:56', '2022-10-20 19:17:56');
INSERT INTO `drug_product_address_info` VALUES ('3', '云南', '1', '0', '2022-10-20 19:18:02', '2022-10-20 19:18:02');
INSERT INTO `drug_product_address_info` VALUES ('4', '天水', '1', '0', '2022-10-20 19:18:08', '2022-10-20 19:18:08');
INSERT INTO `drug_product_address_info` VALUES ('5', '湖南', '1', '0', '2022-10-23 18:25:45', '2022-10-23 18:25:45');
INSERT INTO `drug_product_address_info` VALUES ('6', '四川', '1', '0', '2022-10-23 18:25:54', '2022-10-23 18:25:54');

-- ----------------------------
-- Table structure for `drug_type_info`
-- ----------------------------
DROP TABLE IF EXISTS `drug_type_info`;
CREATE TABLE `drug_type_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `drug_type_Name` varchar(255) NOT NULL COMMENT '药品分类名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='药品分类表';

-- ----------------------------
-- Records of drug_type_info
-- ----------------------------
INSERT INTO `drug_type_info` VALUES ('1', '口服', '1', '0', '2022-10-20 19:32:02', '2022-10-20 19:32:02');
INSERT INTO `drug_type_info` VALUES ('2', '外敷', '1', '0', '2022-10-20 19:32:12', '2022-10-20 19:32:12');
INSERT INTO `drug_type_info` VALUES ('3', '仪器', '1', '0', '2022-10-25 14:28:29', '2022-10-25 14:28:29');

-- ----------------------------
-- Table structure for `hospitalization_info`
-- ----------------------------
DROP TABLE IF EXISTS `hospitalization_info`;
CREATE TABLE `hospitalization_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `patient_register_id` int NOT NULL COMMENT '挂号信息id',
  `doctor_id` int NOT NULL COMMENT '医生id',
  `bed_info_id` int NOT NULL COMMENT '床位id',
  `bond` int NOT NULL COMMENT '保证金',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '住院时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '信息变更时间',
  `patient_address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='住院表';

-- ----------------------------
-- Records of hospitalization_info
-- ----------------------------

-- ----------------------------
-- Table structure for `my_test`
-- ----------------------------
DROP TABLE IF EXISTS `my_test`;
CREATE TABLE `my_test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rank` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of my_test
-- ----------------------------
INSERT INTO `my_test` VALUES ('1', 'www');

-- ----------------------------
-- Table structure for `operator_info`
-- ----------------------------
DROP TABLE IF EXISTS `operator_info`;
CREATE TABLE `operator_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `operator_Name` varchar(255) NOT NULL COMMENT '经办人姓名',
  `operation_user_id` int DEFAULT NULL COMMENT '鎿嶄綔浜哄憳id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='经办人信息表';

-- ----------------------------
-- Records of operator_info
-- ----------------------------
INSERT INTO `operator_info` VALUES ('1', '诸葛亮', '1', '0', '2022-10-20 15:16:52', '2022-10-20 15:16:52');
INSERT INTO `operator_info` VALUES ('2', '鲁肃', '1', '0', '2022-10-20 15:17:00', '2022-10-20 15:22:19');
INSERT INTO `operator_info` VALUES ('3', '程颐', '1', '1', '2022-10-20 15:22:09', '2022-10-20 15:22:10');
INSERT INTO `operator_info` VALUES ('4', '王霞', '1', '0', '2022-10-23 18:24:24', '2022-10-23 18:24:24');
INSERT INTO `operator_info` VALUES ('5', '苗哥', '1', '0', '2022-10-23 18:24:32', '2022-10-23 18:24:32');
INSERT INTO `operator_info` VALUES ('6', '勇哥', '1', '0', '2022-10-23 18:24:38', '2022-10-23 18:24:38');
INSERT INTO `operator_info` VALUES ('7', '兵哥', '1', '0', '2022-10-23 18:24:50', '2022-10-23 18:24:50');
INSERT INTO `operator_info` VALUES ('8', '西哥', '1', '0', '2022-10-23 18:24:56', '2022-10-23 18:24:56');

-- ----------------------------
-- Table structure for `outer_patient_login`
-- ----------------------------
DROP TABLE IF EXISTS `outer_patient_login`;
CREATE TABLE `outer_patient_login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) NOT NULL,
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of outer_patient_login
-- ----------------------------

-- ----------------------------
-- Table structure for `outpatient_department_charge_project`
-- ----------------------------
DROP TABLE IF EXISTS `outpatient_department_charge_project`;
CREATE TABLE `outpatient_department_charge_project` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `outpatient_department__project_name` varchar(255) NOT NULL COMMENT '门诊收费项目名称',
  `price` int NOT NULL COMMENT '价格',
  `unit_name` varchar(255) NOT NULL COMMENT '操作人员id',
  `unit_id` int NOT NULL COMMENT '操作人员id',
  `inspect` int DEFAULT NULL COMMENT '0:闂団偓鐟曚焦顥呴弻?1閿涙矮绗夐棁鈧Λ鈧弻?',
  `project_big_type_id` int NOT NULL COMMENT '项目大类id',
  `project_big_type_name` varchar(255) NOT NULL COMMENT '项目大类名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  `project_type` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='门诊收费项目';

-- ----------------------------
-- Records of outpatient_department_charge_project
-- ----------------------------
INSERT INTO `outpatient_department_charge_project` VALUES ('1', 'CT', '150', '次', '2', '1', '3', '住院医疗综合服务类', '1', '0', '2022-10-26 11:17:41', '2022-10-26 11:17:41', '1');
INSERT INTO `outpatient_department_charge_project` VALUES ('2', 'qq', '140', '次', '2', null, '3', '住院医疗综合服务类', '1', '0', '2022-10-26 11:33:14', '2022-10-26 11:33:14', '2');

-- ----------------------------
-- Table structure for `patient_info`
-- ----------------------------
DROP TABLE IF EXISTS `patient_info`;
CREATE TABLE `patient_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '病人姓名',
  `gender` int NOT NULL COMMENT '性别',
  `age` int NOT NULL COMMENT '年龄',
  `car_id` varchar(255) NOT NULL COMMENT '身份证号码',
  `phone` varchar(255) NOT NULL COMMENT '手机号码',
  `operation_user_id` int DEFAULT NULL COMMENT '鎿嶄綔浜哄憳',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '鍙樻洿鏃堕棿',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of patient_info
-- ----------------------------
INSERT INTO `patient_info` VALUES ('4', '测试1', '1', '21', '523236199601011235', '18564571235', '1', '2022-10-22 08:53:20', '2022-10-22 08:53:20');
INSERT INTO `patient_info` VALUES ('5', '张飞', '1', '23', '432156199301052452', '17854821542', '1', '2022-10-22 09:02:03', '2022-10-22 09:02:03');
INSERT INTO `patient_info` VALUES ('6', '王霞', '1', '22', '544449199505141253', '18254671254', '1', '2022-10-22 10:56:13', '2022-10-22 10:56:13');
INSERT INTO `patient_info` VALUES ('7', '星期44', '1', '21', '432156199601041254', '18257163652', '1', '2022-10-27 19:31:11', '2022-10-27 19:31:11');
INSERT INTO `patient_info` VALUES ('8', '张飞', '1', '50', '432****52', '182****24', null, '2022-10-28 21:43:52', '2022-10-28 21:43:52');
INSERT INTO `patient_info` VALUES ('9', '刘备', '1', '45', '541****45', '158****51', null, '2022-10-28 22:41:42', '2022-10-28 22:41:42');
INSERT INTO `patient_info` VALUES ('10', '杨六', '0', '22', '432****24', '182****41', null, '2022-10-29 19:34:21', '2022-10-29 19:34:21');

-- ----------------------------
-- Table structure for `patient_register`
-- ----------------------------
DROP TABLE IF EXISTS `patient_register`;
CREATE TABLE `patient_register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int NOT NULL COMMENT '患者基本信息id',
  `patient_name` varchar(255) NOT NULL,
  `doctor_id` int NOT NULL COMMENT '医生id',
  `department_id` int NOT NULL COMMENT '科室id',
  `register_type_id` int NOT NULL COMMENT '挂号类型id',
  `pathogeny` varchar(255) DEFAULT NULL,
  `inspect_instructions` varchar(255) DEFAULT NULL,
  `operation_user_id` int DEFAULT NULL COMMENT '鎿嶄綔浜哄憳id',
  `status` int NOT NULL COMMENT '状态，0：正常、1:已离院',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  `pay_status` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of patient_register
-- ----------------------------
INSERT INTO `patient_register` VALUES ('3', '6', '王霞', '1', '1', '1', '穷病', '221222 | 111 | 22 | 33333333333 | 44444444444', '1', '0', '2022-11-13 18:29:09', '2022-11-13 18:29:09', '0');
INSERT INTO `patient_register` VALUES ('4', '7', '星期44', '1', '1', '1', '星期444的处方病因', 'null | 检查没问题', '1', '0', '2022-10-27 19:31:11', '2022-11-13 18:26:44', '0');
INSERT INTO `patient_register` VALUES ('5', '8', '张飞', '1', '1', '1', '1', 'null | 1', '1', '0', '2022-10-28 21:43:52', '2022-10-28 22:00:15', '0');
INSERT INTO `patient_register` VALUES ('6', '9', '刘备', '1', '1', '1', '1111', 'null | 啊啊啊', '1', '0', '2022-10-28 22:41:42', '2022-10-28 22:48:06', '0');
INSERT INTO `patient_register` VALUES ('7', '10', '杨六', '1', '1', '1', '穷病', 'null | 一切正常，就是特别穷', '1', '0', '2022-10-29 19:34:21', '2022-10-29 19:36:38', '0');

-- ----------------------------
-- Table structure for `prescription_pricing`
-- ----------------------------
DROP TABLE IF EXISTS `prescription_pricing`;
CREATE TABLE `prescription_pricing` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `drug_name` varchar(255) NOT NULL COMMENT '药品名称',
  `patient_register_id` int NOT NULL COMMENT '挂号id',
  `drug_count` int NOT NULL COMMENT '药品数量',
  `price` int NOT NULL COMMENT '售价',
  `total` int NOT NULL COMMENT '小计',
  `inspect_status` int DEFAULT NULL,
  `inspect_instructions` varchar(255) DEFAULT NULL,
  `payment_status` int NOT NULL COMMENT '缴费状态',
  `type` int DEFAULT NULL,
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='处方划价';

-- ----------------------------
-- Records of prescription_pricing
-- ----------------------------
INSERT INTO `prescription_pricing` VALUES ('12', '板蓝根', '3', '1', '1500', '1500', '0', null, '1', '1', '1', '0', '2022-10-27 14:58:38', '2022-10-27 14:58:38');
INSERT INTO `prescription_pricing` VALUES ('17', 'CT', '3', '1', '150', '150', '1', '111', '1', '2', '1', '0', '2022-10-27 15:18:38', '2022-10-27 16:35:34');
INSERT INTO `prescription_pricing` VALUES ('18', 'CT', '3', '1', '150', '150', '1', '22', '1', '2', '1', '0', '2022-10-27 15:18:39', '2022-10-27 16:36:05');
INSERT INTO `prescription_pricing` VALUES ('19', 'CT', '3', '1', '150', '150', '1', '33333333333', '1', '2', '1', '0', '2022-10-27 15:18:40', '2022-10-27 16:36:08');
INSERT INTO `prescription_pricing` VALUES ('20', 'qq', '3', '1', '140', '140', '0', null, '1', '1', '1', '0', '2022-10-27 14:58:38', '2022-10-27 14:58:38');
INSERT INTO `prescription_pricing` VALUES ('21', 'CT', '3', '1', '150', '150', '1', '44444444444', '1', '2', '1', '0', '2022-10-27 15:18:42', '2022-10-27 16:36:12');
INSERT INTO `prescription_pricing` VALUES ('22', '头痛粉', '3', '1', '500', '500', '0', null, '1', '1', '1', '0', '2022-10-27 14:58:38', '2022-10-27 14:58:38');
INSERT INTO `prescription_pricing` VALUES ('23', '板蓝根', '4', '1', '1500', '1500', null, null, '1', '1', '1', '0', '2022-10-27 20:10:27', '2022-10-27 20:10:27');
INSERT INTO `prescription_pricing` VALUES ('24', 'CT', '4', '1', '150', '150', '1', '检查没问题', '1', '2', '1', '0', '2022-10-27 20:09:55', '2022-10-27 20:10:15');
INSERT INTO `prescription_pricing` VALUES ('25', '板蓝根', '5', '1', '1500', '1500', null, null, '1', '1', '1', '0', '2022-10-28 22:00:28', '2022-10-28 22:00:28');
INSERT INTO `prescription_pricing` VALUES ('26', 'CT', '5', '1', '150', '150', '1', '1', '1', '2', '1', '0', '2022-10-28 21:59:59', '2022-10-28 22:00:15');
INSERT INTO `prescription_pricing` VALUES ('27', '板蓝根', '6', '1', '1500', '1500', null, null, '1', '1', '1', '0', '2022-10-28 22:49:36', '2022-10-28 22:49:36');
INSERT INTO `prescription_pricing` VALUES ('28', 'CT', '6', '1', '150', '150', '1', '啊啊啊', '1', '2', '1', '0', '2022-10-28 22:46:39', '2022-10-28 22:48:06');
INSERT INTO `prescription_pricing` VALUES ('29', '板蓝根', '7', '10', '1500', '15000', null, null, '1', '1', '1', '0', '2022-10-29 19:36:50', '2022-10-29 19:36:50');
INSERT INTO `prescription_pricing` VALUES ('30', 'CT', '7', '1', '150', '150', '1', '一切正常，就是特别穷', '1', '2', '1', '0', '2022-10-29 19:36:17', '2022-10-29 19:36:38');

-- ----------------------------
-- Table structure for `project_big_type`
-- ----------------------------
DROP TABLE IF EXISTS `project_big_type`;
CREATE TABLE `project_big_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `project_big_type_name` varchar(255) NOT NULL COMMENT '药品名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目大类';

-- ----------------------------
-- Records of project_big_type
-- ----------------------------
INSERT INTO `project_big_type` VALUES ('2', '门诊医疗综合服务类', '1', '0', '2022-10-25 17:01:22', '2022-10-25 17:01:22');
INSERT INTO `project_big_type` VALUES ('3', '住院医疗综合服务类', '1', '0', '2022-10-25 17:01:53', '2022-10-25 17:01:53');

-- ----------------------------
-- Table structure for `register_time_slot`
-- ----------------------------
DROP TABLE IF EXISTS `register_time_slot`;
CREATE TABLE `register_time_slot` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `time_slot` int NOT NULL COMMENT '时间段类型',
  `max` int NOT NULL COMMENT '最多人数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='预约挂号时间段表';

-- ----------------------------
-- Records of register_time_slot
-- ----------------------------
INSERT INTO `register_time_slot` VALUES ('1', '1', '8');
INSERT INTO `register_time_slot` VALUES ('2', '2', '7');
INSERT INTO `register_time_slot` VALUES ('3', '3', '1');

-- ----------------------------
-- Table structure for `register_type_info`
-- ----------------------------
DROP TABLE IF EXISTS `register_type_info`;
CREATE TABLE `register_type_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `register_type_Name` varchar(255) NOT NULL COMMENT '挂号类型名称',
  `price` int NOT NULL COMMENT '挂号收费价格',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：不挂号',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='挂号类型表';

-- ----------------------------
-- Records of register_type_info
-- ----------------------------
INSERT INTO `register_type_info` VALUES ('1', '专家', '30', '1', '0', '2022-10-19 16:58:45', '2022-10-19 16:58:45');
INSERT INTO `register_type_info` VALUES ('2', '普通挂号', '15', '1', '0', '2022-10-23 18:24:09', '2022-10-23 18:24:09');

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `reportId` int NOT NULL AUTO_INCREMENT,
  `reportName` varchar(100) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `department` int DEFAULT NULL,
  `doctor` int DEFAULT NULL,
  `reportType` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `users` varchar(100) DEFAULT NULL,
  `state` int DEFAULT NULL,
  `phone` varchar(100) NOT NULL,
  `carid` varchar(100) NOT NULL,
  `zhuan` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`reportId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for `storage_in_order_info`
-- ----------------------------
DROP TABLE IF EXISTS `storage_in_order_info`;
CREATE TABLE `storage_in_order_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `drug_info_id` int NOT NULL COMMENT '药品信息表id',
  `warehouse_info_id` int NOT NULL COMMENT '仓库表id',
  `supplier_info_id` int NOT NULL COMMENT '供货商表id',
  `operator_info_id` int NOT NULL COMMENT '经办人表id',
  `whole_sale_price` int NOT NULL COMMENT '批发价',
  `count` int NOT NULL COMMENT '数量',
  `product_date` date NOT NULL COMMENT '生产日期',
  `valid_date` date NOT NULL COMMENT '生产日期',
  `batch_no` varchar(32) NOT NULL COMMENT '批次号',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='入库单表';

-- ----------------------------
-- Records of storage_in_order_info
-- ----------------------------
INSERT INTO `storage_in_order_info` VALUES ('7', '5', '1', '2', '1', '11', '12', '2022-11-06', '2022-11-30', '2022117', '0');
INSERT INTO `storage_in_order_info` VALUES ('8', '11', '1', '2', '1', '32', '10', '2022-11-01', '2022-11-30', '2022117', '0');
INSERT INTO `storage_in_order_info` VALUES ('9', '5', '1', '2', '1', '1', '11', '2022-11-09', '2022-11-26', '20221110', '0');
INSERT INTO `storage_in_order_info` VALUES ('10', '6', '1', '2', '1', '10', '5', '2022-11-02', '2022-11-30', '20221110', '0');
INSERT INTO `storage_in_order_info` VALUES ('11', '8', '1', '2', '1', '11', '22', '2022-11-01', '2022-11-26', '20221110', '0');

-- ----------------------------
-- Table structure for `supplier_info`
-- ----------------------------
DROP TABLE IF EXISTS `supplier_info`;
CREATE TABLE `supplier_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `supplier_Name` varchar(255) NOT NULL COMMENT '供货商名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='供货商表';

-- ----------------------------
-- Records of supplier_info
-- ----------------------------
INSERT INTO `supplier_info` VALUES ('1', '百度', '1', '1', '2022-10-20 21:36:14', '2022-10-20 21:36:14');
INSERT INTO `supplier_info` VALUES ('2', '阿里', '1', '0', '2022-10-20 21:36:25', '2022-10-20 21:36:25');
INSERT INTO `supplier_info` VALUES ('3', '仁和', '1', '0', '2022-10-20 21:36:36', '2022-10-20 21:36:36');
INSERT INTO `supplier_info` VALUES ('4', '速达', '1', '0', '2022-10-23 18:25:30', '2022-10-23 18:25:30');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `spread` int DEFAULT NULL COMMENT '0不展开1展开',
  `target` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `available` int DEFAULT NULL COMMENT '0不可用1可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '医院管理系统', '', '1', null, '&#xe68e;', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '门诊管理', '', '0', null, '&#xe653;', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '住院管理', '', '0', null, '&#xe663;', '1');
INSERT INTO `sys_menu` VALUES ('4', '1', '系统管理', '', '0', '', '&#xe716;', '1');
INSERT INTO `sys_menu` VALUES ('5', '1', '统计管理', '', '0', null, '&#xe629;', '1');
INSERT INTO `sys_menu` VALUES ('6', '2', '用户挂号', '../patient/register/list', '0', null, '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('7', '2', '处方划价', '../prescription/pricing/initPage', '0', null, '&#xe657;', '1');
INSERT INTO `sys_menu` VALUES ('8', '3', '入院登记', '../liao/admin', '0', null, '&#xe65b;', '1');
INSERT INTO `sys_menu` VALUES ('9', '3', '缴费管理', '../liao/pay', '0', null, '&#xe6b2;', '1');
INSERT INTO `sys_menu` VALUES ('11', '3', '药品记账', '../liao/drug', '0', null, '&#xe705;', '1');
INSERT INTO `sys_menu` VALUES ('12', '4', '菜单管理', '../toMenuManager', '0', null, '&#xe60f;', '1');
INSERT INTO `sys_menu` VALUES ('13', '4', '角色管理', '../toLoadAllRole', '0', '', '&#xe66f;', '1');
INSERT INTO `sys_menu` VALUES ('14', '4', '用户管理', '../toLoadAllUser', '0', null, '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('15', '4', '图标管理', '../icon', '0', null, '&#xe655;', '1');
INSERT INTO `sys_menu` VALUES ('17', '4', '数据源监控', '../druid', '0', null, '&#xe857;', '1');
INSERT INTO `sys_menu` VALUES ('18', '5', '门诊月度统计', '../toReportFinance', '0', null, '&#xe63c;', '1');
INSERT INTO `sys_menu` VALUES ('19', '5', '住院月度统计', '../toZhuYaunManage', '0', null, '&#xe62c;', '1');
INSERT INTO `sys_menu` VALUES ('20', '5', '门诊年度统计', '../toBingYear', '0', null, '&#xe62d;', '1');
INSERT INTO `sys_menu` VALUES ('27', '2', '项目划价', '../project/pricing/initPage', '0', null, '&#xe60a;', '1');
INSERT INTO `sys_menu` VALUES ('28', '2', '项目缴费', '../xpay/xiangpay', '0', null, '&#xe65e;', '1');
INSERT INTO `sys_menu` VALUES ('30', '1', '数据中心', '', '0', null, '&#xe60a;', '1');
INSERT INTO `sys_menu` VALUES ('31', '30', '科室中心', '../toDepartments', '0', null, '&#xe68e;', '1');
INSERT INTO `sys_menu` VALUES ('32', '30', '医生列表', '../toDoctor', '0', null, '&#xe66f;', '1');
INSERT INTO `sys_menu` VALUES ('33', '30', '药品产地', '../toArea', '0', null, '&#xe630;', '1');
INSERT INTO `sys_menu` VALUES ('36', '30', '项目大类', '../toProjectTypeManage', '0', null, '&#xe620;', '1');
INSERT INTO `sys_menu` VALUES ('37', '30', '挂号类型', '../toRegisteredType', '0', null, '&#xe672;', '1');
INSERT INTO `sys_menu` VALUES ('40', '30', '仓库', '../toWarehuose', '0', null, '&#xe60a;', '1');
INSERT INTO `sys_menu` VALUES ('41', '30', '经办人', '../toSkull', '0', null, '&#xe612;', '1');
INSERT INTO `sys_menu` VALUES ('42', '30', '计量单位', '../toUnit', '0', null, '&#xe62a;', '1');
INSERT INTO `sys_menu` VALUES ('43', '30', '供货商', '../toSupply', '0', null, '&#xe613;', '1');
INSERT INTO `sys_menu` VALUES ('44', '30', '药品分类', '../toType', '0', null, '&#xe656;', '1');
INSERT INTO `sys_menu` VALUES ('46', '1', '排班管理', '1', '0', null, '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('47', '46', '医生排班', '../toPaiban', '0', null, '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('48', '30', '药品字典', '../toDrugdictionary', '0', null, '&#xe64d;', '1');
INSERT INTO `sys_menu` VALUES ('49', '3', '项目记账', '../liao/item', '0', null, '&#xe705;', '1');
INSERT INTO `sys_menu` VALUES ('52', '5', '住院年度统计', '../toBing2', '0', null, '&#xe630;', '1');
INSERT INTO `sys_menu` VALUES ('53', '2', '项目检查', '../xpay/seljian', '0', null, '&#xe674;', '1');
INSERT INTO `sys_menu` VALUES ('54', '1', '仓库管理', '', '0', null, '&#xe61c;', '1');
INSERT INTO `sys_menu` VALUES ('55', '54', '入库单', '../storage/in/order/init/page', '0', null, '&#xe657;', '1');
INSERT INTO `sys_menu` VALUES ('56', '5', '医生统计对比', '../toDoctorDuibi', '0', null, '&#xe770;', '1');
INSERT INTO `sys_menu` VALUES ('57', '54', '库存查询', '/storage/in/order/listPage', '0', null, '&#xe62a;', '1');
INSERT INTO `sys_menu` VALUES ('58', '54', '出库单', '../dsnavigation/selectchuku', '0', null, '&#xe621;', '1');
INSERT INTO `sys_menu` VALUES ('59', '54', '库存不足', '../dsnavigation/selectless', '0', null, '&#xe6b2;', '1');
INSERT INTO `sys_menu` VALUES ('60', '54', '过期提醒', '../dsnavigation/seldrugDate', '0', null, '&#xe702;', '1');
INSERT INTO `sys_menu` VALUES ('61', '1', '药房管理', '', '0', null, '&#xe705;', '1');
INSERT INTO `sys_menu` VALUES ('62', '61', '药房详情', '../dsnavigation/pharymacyhtml', '0', null, '&#xe632;', '1');
INSERT INTO `sys_menu` VALUES ('64', '2', '药品缴费', '../caoout/out', '0', null, '&#xe65e;', '1');
INSERT INTO `sys_menu` VALUES ('65', '5', '门诊当天统计', '../toCurrent', '0', null, '&#xe60e;', '1');
INSERT INTO `sys_menu` VALUES ('69', '2', '门诊患者库', '../caotake/haun', '0', null, '&#xe66f;', '1');
INSERT INTO `sys_menu` VALUES ('70', '54', '操作记录', '../dsnavigation/record', '0', null, '&#xe6b2;', '1');
INSERT INTO `sys_menu` VALUES ('71', '54', '药品回收', '../dsnavigation/recycle', '0', null, '&#xe669;', '1');
INSERT INTO `sys_menu` VALUES ('72', '61', '门诊取药', '../caotake/seltake', '0', null, '&#xe857;', '1');
INSERT INTO `sys_menu` VALUES ('73', '61', '住院取药', '../liao/pharmacy', '0', null, '&#xe63c;', '1');
INSERT INTO `sys_menu` VALUES ('86', '3', '出院结算', '../liao/leave', '0', null, '&#xe65a;', '1');
INSERT INTO `sys_menu` VALUES ('90', '2', 'test', '', '0', null, '&#xe678;', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `roleid` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  `roledesc` varchar(255) DEFAULT NULL,
  `available` int DEFAULT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有菜单权限', '1');
INSERT INTO `sys_role` VALUES ('4', '门诊管理', '拥有门诊管理的权限', '1');
INSERT INTO `sys_role` VALUES ('5', '挂号', '挂号人员', '1');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `rid` int NOT NULL,
  `mid` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '6');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '27');
INSERT INTO `sys_role_menu` VALUES ('1', '28');
INSERT INTO `sys_role_menu` VALUES ('1', '53');
INSERT INTO `sys_role_menu` VALUES ('1', '64');
INSERT INTO `sys_role_menu` VALUES ('1', '69');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '49');
INSERT INTO `sys_role_menu` VALUES ('1', '86');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '17');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '18');
INSERT INTO `sys_role_menu` VALUES ('1', '19');
INSERT INTO `sys_role_menu` VALUES ('1', '20');
INSERT INTO `sys_role_menu` VALUES ('1', '52');
INSERT INTO `sys_role_menu` VALUES ('1', '56');
INSERT INTO `sys_role_menu` VALUES ('1', '65');
INSERT INTO `sys_role_menu` VALUES ('1', '30');
INSERT INTO `sys_role_menu` VALUES ('1', '31');
INSERT INTO `sys_role_menu` VALUES ('1', '32');
INSERT INTO `sys_role_menu` VALUES ('1', '33');
INSERT INTO `sys_role_menu` VALUES ('1', '36');
INSERT INTO `sys_role_menu` VALUES ('1', '37');
INSERT INTO `sys_role_menu` VALUES ('1', '40');
INSERT INTO `sys_role_menu` VALUES ('1', '41');
INSERT INTO `sys_role_menu` VALUES ('1', '42');
INSERT INTO `sys_role_menu` VALUES ('1', '43');
INSERT INTO `sys_role_menu` VALUES ('1', '44');
INSERT INTO `sys_role_menu` VALUES ('1', '48');
INSERT INTO `sys_role_menu` VALUES ('1', '46');
INSERT INTO `sys_role_menu` VALUES ('1', '47');
INSERT INTO `sys_role_menu` VALUES ('1', '54');
INSERT INTO `sys_role_menu` VALUES ('1', '55');
INSERT INTO `sys_role_menu` VALUES ('1', '57');
INSERT INTO `sys_role_menu` VALUES ('1', '58');
INSERT INTO `sys_role_menu` VALUES ('1', '59');
INSERT INTO `sys_role_menu` VALUES ('1', '60');
INSERT INTO `sys_role_menu` VALUES ('1', '70');
INSERT INTO `sys_role_menu` VALUES ('1', '71');
INSERT INTO `sys_role_menu` VALUES ('1', '61');
INSERT INTO `sys_role_menu` VALUES ('1', '62');
INSERT INTO `sys_role_menu` VALUES ('1', '72');
INSERT INTO `sys_role_menu` VALUES ('1', '73');

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `uid` int NOT NULL,
  `rid` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1');
INSERT INTO `sys_role_user` VALUES ('29', '5');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` int DEFAULT NULL COMMENT '0女1男',
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `type` int DEFAULT '2' COMMENT '1，超级管理员,2，系统用户',
  `available` int DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '412365199601236544', '超级管理员', '1', '中国贵州', '13183380740', '6af4d08340b548cbcce38353d9bcaab4', 'CEO', '1', '1', 'd21fd4');
INSERT INTO `sys_user` VALUES ('28', 'mz', '412827199807156565', '门诊', '1', '中国北京', '13183365365', '8bab0ae05712cd0d765415ee965d29cb', '门诊管理员', '2', '1', 'b16016');
INSERT INTO `sys_user` VALUES ('29', 'tian', '522228199101011256', 'tian', '1', '中国广东', '18257160372', 'd6d655ac49de205b951377f2a07cb656', '老大', '2', '1', '0a07a6');
INSERT INTO `sys_user` VALUES ('30', '挂号', '522228199001011526', '挂号', '0', '中国广东', '18257160372', '2358e8f429fd432054c66e663ac9eb2b', '挂号', '2', '1', 'e0158b');
INSERT INTO `sys_user` VALUES ('31', 'test', '512546199901021358', 'test', '1', '中国广东', '18257160372', '745093b7d052cc17fb134061ad7a06a6', 'asss', '2', '1', '261f80');

-- ----------------------------
-- Table structure for `unit_info`
-- ----------------------------
DROP TABLE IF EXISTS `unit_info`;
CREATE TABLE `unit_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `unit_name` varchar(255) NOT NULL COMMENT '供货商名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='单位表';

-- ----------------------------
-- Records of unit_info
-- ----------------------------
INSERT INTO `unit_info` VALUES ('1', '盒', '1', '0', '2022-10-20 22:35:14', '2022-10-20 22:35:14');
INSERT INTO `unit_info` VALUES ('2', '次', '1', '0', '2022-10-20 22:35:19', '2022-10-20 22:35:19');
INSERT INTO `unit_info` VALUES ('3', '袋', '1', '0', '2022-10-20 22:35:32', '2022-10-20 22:35:32');

-- ----------------------------
-- Table structure for `warehouse_info`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_info`;
CREATE TABLE `warehouse_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `warehouse_Name` varchar(255) NOT NULL COMMENT '仓库名称',
  `operation_user_id` int NOT NULL COMMENT '操作人员id',
  `status` int NOT NULL COMMENT '状态，0：正常，1：已删除',
  `create_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '变更时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='仓库信息表';

-- ----------------------------
-- Records of warehouse_info
-- ----------------------------
INSERT INTO `warehouse_info` VALUES ('1', '仓库', '1', '0', '2022-10-19 22:32:22', '2022-10-19 22:32:22');
INSERT INTO `warehouse_info` VALUES ('2', '广东仓库', '1', '0', '2022-10-23 18:22:52', '2022-10-23 18:22:52');
INSERT INTO `warehouse_info` VALUES ('3', '贵州仓库', '1', '0', '2022-10-23 18:22:58', '2022-10-23 18:22:58');
INSERT INTO `warehouse_info` VALUES ('4', '上海仓库', '1', '0', '2022-10-23 18:23:07', '2022-10-23 18:23:07');
INSERT INTO `warehouse_info` VALUES ('5', '河南仓库', '1', '0', '2022-10-23 18:23:14', '2022-10-23 18:23:14');
INSERT INTO `warehouse_info` VALUES ('6', '湖南仓库', '1', '0', '2022-10-23 18:23:21', '2022-10-23 18:23:21');
INSERT INTO `warehouse_info` VALUES ('7', '江西仓库', '1', '0', '2022-10-23 18:23:27', '2022-10-23 18:23:27');
INSERT INTO `warehouse_info` VALUES ('8', '湖北仓库', '1', '0', '2022-10-23 18:23:40', '2022-10-23 18:23:40');
INSERT INTO `warehouse_info` VALUES ('9', '四川仓库', '1', '0', '2022-10-23 18:23:48', '2022-10-23 18:23:48');
