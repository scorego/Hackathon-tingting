package wang.javior.hackathon.tingting.entity.VO;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("搜书书籍返回实体")
public class BookQueryVo {

    public BookQueryVo(String query, BookDetailVo bookDetail, List<BookDetailVo> fuzzBooks) {
        this.query = query;
        exists = bookDetail.isExists();
        this.exactBook = bookDetail;
        this.fuzzBooks = fuzzBooks;
    }

    private String query;

    private boolean exists;

    private BookDetailVo exactBook;

    private List<BookDetailVo> fuzzBooks;

}
