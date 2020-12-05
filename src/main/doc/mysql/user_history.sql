drop table if exists `user_history`;

CREATE TABLE `user_history` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `open_id` varchar(255) NOT NULL DEFAULT '' COMMENT 'user open id',
    `book_name` varchar(255) DEFAULT '' COMMENT 'book_name',
    `chapter_index` bigint(10) DEFAULT '0' COMMENT 'chapter_index',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci