CREATE TABLE `act_id_sync`  (
                                `ID` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主体ID',
                                `TYPE` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主体类型',
                                `SYNC_TIME` datetime NULL DEFAULT NULL COMMENT '同步时间',
                                PRIMARY KEY (`ID`, `TYPE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;
