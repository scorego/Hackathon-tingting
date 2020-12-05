package wang.javior.hackathon.tingting.entity.VO;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("书籍正文信息实体")
public class BookContentVo {

    public BookContentVo(String openId, String bookName, long chapterIndex) {
        this.openId = openId;
        this.bookName = bookName;
        this.chapterIndex = chapterIndex;
        updateIsEmptyContent();
    }

    public void updateContent(List<String> content) {
        this.content = new ArrayList<>(content);
        updateIsEmptyContent();
    }

    private void updateIsEmptyContent() {
        this.emptyContent = CollectionUtils.isEmpty(this.content);
    }

    @ApiModelProperty("用户openId")
    private String openId;

    @ApiModelProperty("书籍id")
    private long bookId;

    @ApiModelProperty("第几章")
    private long chapterIndex;

    @ApiModelProperty("章节")
    private long chapterId;

    @ApiModelProperty("书名")
    private String bookName;

    @ApiModelProperty("章节正文，按规则分割的数组")
    private List<String> content;

    @ApiModelProperty("正文是否为空")
    private boolean emptyContent;

}
