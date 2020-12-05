drop table if exists `chapter_basic_info`;
CREATE TABLE `chapter_basic_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chapter_url` varchar(512) NOT NULL DEFAULT '' COMMENT '章节内容页链接',
  `book_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '书籍所属书籍id',
  `chapter_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '章节所属书籍id',
  `chapter_index` int(10) NOT NULL DEFAULT '0' COMMENT '章节序号',
  `chapter_title` varchar(128) NOT NULL DEFAULT '' COMMENT '章节标题',
  `is_delete` tinyint(3) NOT NULL DEFAULT '0' COMMENT '章节标记删除字段 1-删除',
  `word_count` int(10) NOT NULL DEFAULT '0' COMMENT '章节字数',
  `chapter_agg_sign` bigint(20) NOT NULL DEFAULT '0' COMMENT '同章节的多个chapter_url共同生成的一个sign。转码用于关联对齐表',
  `description` varchar(1024) NOT NULL DEFAULT '' COMMENT '章节简介',
  `edit_text` text NOT NULL COMMENT '干预字段',
  `level` tinyint(3) NOT NULL DEFAULT '0' COMMENT '目录层级',
  `parent_cid` bigint(21) NOT NULL DEFAULT '0' COMMENT '目录父节点的chapter_id',
  `page_count` int(10) NOT NULL DEFAULT '0' COMMENT '章节正文页数',
  `secondary_chapter_url` varchar(512) NOT NULL DEFAULT '' COMMENT '二级cp章节内容页链接',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci