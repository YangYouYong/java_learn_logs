CREATE TABLE `sys_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '表ID，主键，供其他表做外键',
  `USERNAME` varchar(30) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) NOT NULL COMMENT '密码',
  `NICKNAME` varchar(30) NOT NULL COMMENT '用户名称',
  `BIRTHDAY` date DEFAULT NULL COMMENT '生日',
  `SEX` int(1) DEFAULT NULL COMMENT '性别：1-男；0-女',
  `ENABLED` int(1) NOT NULL DEFAULT '1' COMMENT '启用标识：1/0',
  `VERSION_NUMBER` int(11) NOT NULL DEFAULT '1' COMMENT '行版本号，用来处理锁',
  `CREATE_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_BY` bigint(11) NOT NULL DEFAULT '-1' COMMENT '创建人',
  `UPDATE_BY` bigint(11) NOT NULL DEFAULT '-1' COMMENT '更新人',
  `UPDATE_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `ATTRIBUTE1` varchar(150) DEFAULT NULL,
  `ATTRIBUTE2` varchar(150) DEFAULT NULL,
  `ATTRIBUTE3` varchar(150) DEFAULT NULL,
  `ATTRIBUTE4` varchar(150) DEFAULT NULL,
  `ATTRIBUTE5` varchar(150) DEFAULT NULL,
  `ATTRIBUTE6` varchar(150) DEFAULT NULL,
  `ATTRIBUTE7` varchar(150) DEFAULT NULL,
  `ATTRIBUTE8` varchar(150) DEFAULT NULL,
  `ATTRIBUTE9` varchar(150) DEFAULT NULL,
  `ATTRIBUTE10` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';