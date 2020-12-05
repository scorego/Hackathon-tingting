drop table if exists `content_basic_info`;
CREATE TABLE `content_basic_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '书籍所属书籍id',
  `chapter_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '章节所属书籍id',
  `content_text` text NOT NULL COMMENT '干预字段',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci