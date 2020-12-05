package wang.javior.hackathon.tingting.dao.mapper;


import wang.javior.hackathon.tingting.dao.model.UserHistoryDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UserHistoryMapper {


    @Results(id = "userHistory", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "open_id", property = "openId", javaType = String.class),
            @Result(column = "book_name", property = "bookName", javaType = String.class),
            @Result(column = "chapter_index", property = "chapterIndex", javaType = Long.class),
            @Result(column = "update_time", property = "updateTime", javaType = Date.class),
    })
    @Select("select id, open_id, book_name, chapter_index, update_time from user_history")
    List<UserHistoryDao> getAll();


    @ResultMap("userHistory")
    @Select("select id, open_id, book_name, chapter_index, update_time from user_history where open_id = #{openId} and book_name = #{bookName} order by update_time desc limit #{limit}")
    List<UserHistoryDao> getUserHistory(@Param("openId") String openId, @Param("bookName") String bookName, @Param("limit") int limit);

    @Insert("insert into user_history (open_id, book_name, chapter_index) values (#{openId}, #{bookName}, #{chapterIndex})")
    int insertUserHistory(@Param("openId") String openId, @Param("bookName") String bookName, @Param("chapterIndex") long chapterIndex);
}
