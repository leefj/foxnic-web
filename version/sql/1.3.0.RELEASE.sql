--  2022-11-01  增加备注
ALTER TABLE `foxnic`.`sys_user`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

ALTER TABLE `foxnic`.`sys_menu`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;


ALTER TABLE `foxnic`.`sys_role`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

ALTER TABLE `foxnic`.`sys_busi_role`
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;


--  2022-11-01  调整多语言

ALTER TABLE `foxnic`.`sys_lang`
    CHANGE COLUMN `zh_ch` `zh_cn` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简体中文(大陆)' AFTER `defaults`;


ALTER TABLE `foxnic`.`sys_lang`
    CHANGE COLUMN `en_uk` `en_gb` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '英文英国' AFTER `en_us`;

ALTER TABLE `foxnic`.`sys_lang`
    MODIFY COLUMN `zh_cn` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简体中文' AFTER `defaults`,
    MODIFY COLUMN `zh_tw` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '中文(台湾)' AFTER `zh_cn`,
    ADD COLUMN `zh_hk` varchar(512) NULL COMMENT '中文(香港)' AFTER `version`,
    ADD COLUMN `zh_mo` varchar(512) NULL COMMENT '中文(澳门)' AFTER `zh_hk`;


ALTER TABLE `foxnic`.`sys_lang`
    ADD COLUMN `ko_kr` varchar(512) NULL COMMENT '韩语' AFTER `zh_mo`,
ADD COLUMN `ja_jp` varchar(512) NULL COMMENT '日语' AFTER `ko_kr`;
