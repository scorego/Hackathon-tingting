drop table if exists `book_basic_info`;
CREATE TABLE `book_basic_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `book_id` bigint(20) NOT NULL COMMENT '书籍唯一id',
  `book_name` varchar(128) NOT NULL DEFAULT '' COMMENT '书籍名称',
  `cover_image` varchar(1024) NOT NULL DEFAULT '' COMMENT '书籍封面图',
  `author` varchar(128) NOT NULL DEFAULT '' COMMENT '书籍作者',
  `category` varchar(128) NOT NULL DEFAULT '' COMMENT '书籍频道和类别',
  `tag` varchar(512) NOT NULL DEFAULT '' COMMENT '书籍tag',
  `catalog_url` varchar(512) NOT NULL DEFAULT '' COMMENT '正版-资源方书籍接口,转码-目录链接',
  `word_count` int(10) NOT NULL DEFAULT '0' COMMENT '书籍字数',
  `chapter_count` int(10) NOT NULL DEFAULT '0' COMMENT '书籍上线章节总数',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '书籍简介',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci