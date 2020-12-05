drop table if exists `user`;

CREATE TABLE `user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `open_id` varchar(255) UNIQUE NOT NULL COMMENT 'user open id',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci