package wang.javior.hackathon.tingting.dao.mapper;


import wang.javior.hackathon.tingting.dao.model.BookBasicInfoDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface BookBasicInfoMapper {

    String fields = "id, book_id, book_name, cover_image, author, category, tag, catalog_url,word_count,chapter_count,description,update_time";

    @Results(id = "BookBasicInfo", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "book_id", property = "bookId", javaType = Long.class),
            @Result(column = "book_name", property = "bookName", javaType = String.class),
            @Result(column = "cover_image", property = "coverImage", javaType = String.class),
            @Result(column = "author", property = "author", javaType = String.class),
            @Result(column = "category", property = "category", javaType = String.class),
            @Result(column = "tag", property = "tag", javaType = String.class),
            @Result(column = "catalog_url", property = "catalogUrl", javaType = String.class),
            @Result(column = "word_count", property = "wordCount", javaType = Integer.class),
            @Result(column = "chapter_count", property = "chapterCount", javaType = Integer.class),
            @Result(column = "description", property = "description", javaType = String.class),
            @Result(column = "update_time", property = "updateTime", javaType = Date.class),
    })
    @Select("select " + fields + " from book_basic_info limit  #{limit}")
    List<BookBasicInfoDao> getAll(@Param("limit") int limit);

    @ResultMap("BookBasicInfo")
    @Select("select " + fields + " from book_basic_info where book_name = #{bookName}")
    BookBasicInfoDao getBookBasicInfoByName(@Param("bookName") String bookName);

    @ResultMap("BookBasicInfo")
    @Select("select " + fields + " from book_basic_info where book_name != #{query} and book_name like CONCAT('%',#{query},'%') limit #{limit}")
    List<BookBasicInfoDao> queryFuzzBooks(@Param("query") String query, @Param("limit") int limit);


}
