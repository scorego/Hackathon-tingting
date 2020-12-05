package wang.javior.hackathon.tingting.dao.mapper;


import wang.javior.hackathon.tingting.dao.model.ChapterBasicInfoDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ChapterBasicInfoMapper {

    String fields = "id, chapter_url, book_id, chapter_id, chapter_index, chapter_title, is_delete, word_count, chapter_agg_sign, description, edit_text, level, parent_cid, page_count, secondary_chapter_url, update_time";

    @Results(id = "ChapterBasicInfo", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "chapter_url", property = "chapterUrl", javaType = String.class),
            @Result(column = "book_id", property = "bookId", javaType = Long.class),
            @Result(column = "chapter_id", property = "chapterId", javaType = Long.class),
            @Result(column = "chapter_index", property = "chapterIndex", javaType = Integer.class),
            @Result(column = "chapter_title", property = "chapterTitle", javaType = String.class),
            @Result(column = "is_delete", property = "isDelete", javaType = Integer.class),
            @Result(column = "word_count", property = "wordCount", javaType = Integer.class),
            @Result(column = "chapter_agg_sign", property = "chapterAggSign", javaType = Long.class),
            @Result(column = "description", property = "description", javaType = String.class),
            @Result(column = "edit_text", property = "editText", javaType = String.class),
            @Result(column = "level", property = "level", javaType = Integer.class),
            @Result(column = "parent_cid", property = "parentCid", javaType = Long.class),
            @Result(column = "page_count", property = "pageCount", javaType = Long.class),
            @Result(column = "secondary_chapter_url", property = "secondaryChapterUrl", javaType = String.class),
            @Result(column = "update_time", property = "updateTime", javaType = Date.class),
    })
    @Select("select " + fields + " from chapter_basic_info")
    List<ChapterBasicInfoDao> getAll();

    @ResultMap("ChapterBasicInfo")
    @Select("select " + fields + " from chapter_basic_info where book_id = #{bookId} and chapter_index = #{chapterIndex}")
    ChapterBasicInfoDao getChapterBasicInfoByBookIdChapterIndex(@Param("bookId") long bookId, @Param("chapterIndex") long chapterIndex);


}
