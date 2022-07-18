ALTER TABLE `sys_session_online`
    ADD COLUMN `access_token` varchar(2048) NULL COMMENT 'accessToken' AFTER `node_id`,
ADD COLUMN `refresh_token` varchar(2048) NULL COMMENT 'refreshToken' AFTER `access_token`;
