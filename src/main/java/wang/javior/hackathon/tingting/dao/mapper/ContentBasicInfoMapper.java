package wang.javior.hackathon.tingting.dao.mapper;


import wang.javior.hackathon.tingting.dao.model.ContentBasicInfoDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ContentBasicInfoMapper {

    String fields = "id, book_id, chapter_id, content_text, update_time";

    @Results(id = "ContentBasicInfo", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "book_id", property = "bookId", javaType = Long.class),
            @Result(column = "chapter_id", property = "chapterId", javaType = Long.class),
            @Result(column = "content_text", property = "contentText", javaType = String.class),
            @Result(column = "update_time", property = "updateTime", javaType = Date.class),
    })
    @Select("select " + fields + " from content_basic_info")
    List<ContentBasicInfoDao> getAll();

    @ResultMap("ContentBasicInfo")
    @Select("select " + fields + " from content_basic_info where book_id = #{bookId} and chapter_id = #{chapterId}")
    ContentBasicInfoDao getContentBasicInfoDaoByIds(@Param("bookId") long bookId, @Param("chapterId") long chapterId);


}
