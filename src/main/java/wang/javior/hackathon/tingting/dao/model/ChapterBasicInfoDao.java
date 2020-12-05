package wang.javior.hackathon.tingting.dao.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChapterBasicInfoDao {

    private long id;

    private String chapterUrl;

    private long bookId;

    private long chapterId;

    private int chapterIndex;

    private String chapterTitle;

    private int isDelete;

    private int wordCount;

    private long chapterAggSign;

    private String description;

    private String editText;

    private int level;

    private long parentCid;

    private long pageCount;

    private String secondaryChapterUrl;

    private Date updateTime;

}