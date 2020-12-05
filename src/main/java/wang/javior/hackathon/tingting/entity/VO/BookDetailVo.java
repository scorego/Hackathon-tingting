package wang.javior.hackathon.tingting.entity.VO;


import wang.javior.hackathon.tingting.dao.model.BookBasicInfoDao;
import io.swagger.annotations.ApiModel;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("书籍信息实体")
public class BookDetailVo {

    private boolean exists;

    private String bookName;

    private long bookId;

    private String author;

    private String description;

    public BookDetailVo(BookBasicInfoDao bookBasicInfoDao) {
        this.exists = bookBasicInfoDao != null;
        if (bookBasicInfoDao != null) {
            this.bookName = bookBasicInfoDao.getBookName();
            this.bookId = bookBasicInfoDao.getBookId();
            this.author = bookBasicInfoDao.getAuthor();
            this.description = bookBasicInfoDao.getDescription();
        }
    }


}
