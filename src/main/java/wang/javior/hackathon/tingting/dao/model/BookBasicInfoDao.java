package wang.javior.hackathon.tingting.dao.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBasicInfoDao {

    private long id;

    private long bookId;

    private String bookName;

    private String coverImage;

    private String author;

    private String category;

    private String tag;

    private String catalogUrl;

    private int wordCount;

    private int chapterCount;

    private String description;

    private Date updateTime;

}
