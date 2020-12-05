package wang.javior.hackathon.tingting.dao.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDao {

    private long id;

    private String openId;

    private Date updateTime;

}
