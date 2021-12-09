ALTER TABLE pcm_catalog_attribute`
    MODIFY COLUMN `not_null` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 01 COMMENT '是否必填' AFTER `field`;

ALTER TABLE `pcm_catalog_allocation`
DROP INDEX `uk`,
ADD UNIQUE INDEX `uk`(`catalog_id`, `attribute_id`,`version_no`) USING BTREE;
