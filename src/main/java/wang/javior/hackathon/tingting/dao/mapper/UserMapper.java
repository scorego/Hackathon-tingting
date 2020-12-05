package wang.javior.hackathon.tingting.dao.mapper;


import wang.javior.hackathon.tingting.dao.model.UserDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UserMapper {


    @Results(id = "user", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "open_id", property = "openId", javaType = String.class),
            @Result(column = "update_time", property = "updateTime", javaType = Date.class),
    })
    @Select("select id, open_id, update_time from user")
    List<UserDao> getAll();


    @Select("select count(*) from user")
    long countAll();

    @Select("select count(*) from user where open_id = #{openId}")
    int countUserByOpenId(@Param("openId") String openId);

    @Insert("insert into  user (open_id) values (#{openId})")
    int insertUser(@Param("openId") String openId);

}
