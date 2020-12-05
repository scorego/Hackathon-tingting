package wang.javior.hackathon.tingting.dao.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentBasicInfoDao {

    private long id;

    private long bookId;

    private long chapterId;

    private String contentText;

    private Date updateTime;

}
