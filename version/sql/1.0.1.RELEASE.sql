CREATE TABLE `act_id_sync`  (
                                `ID` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主体ID',
                                `TYPE` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主体类型',
                                `SYNC_TIME` datetime NULL DEFAULT NULL COMMENT '同步时间',
                                PRIMARY KEY (`ID`, `TYPE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

ALTER TABLE `sys_user`
    ADD COLUMN `real_name` varchar(255) NULL COMMENT '姓名' AFTER `name`;

ALTER TABLE `sys_user`
    CHANGE COLUMN `name` `account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账户' AFTER `id`;


ALTER TABLE `sys_user`
    MODIFY COLUMN `account` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账户' AFTER `id`,
    MODIFY COLUMN `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名' AFTER `account`,
    MODIFY COLUMN `passwd` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码' AFTER `real_name`,
    MODIFY COLUMN `phone` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号码' AFTER `passwd`,
    MODIFY COLUMN `language` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '语言' AFTER `portrait_id`;


ALTER TABLE `sys_job`
ADD COLUMN `code` varchar(64) NULL COMMENT '代码，任务代码' AFTER `id`;