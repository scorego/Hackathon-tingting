package wang.javior.hackathon.tingting.bookTest;

import wang.javior.hackathon.tingting.App;
import wang.javior.hackathon.tingting.controller.BookController;
import wang.javior.hackathon.tingting.core.BookServiceAdapter;
import wang.javior.hackathon.tingting.dao.model.BookBasicInfoDao;
import wang.javior.hackathon.tingting.entity.VO.BookQueryVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class BookTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private BookServiceAdapter bookServiceAdapter;

    @Test
    public void testGetBookBasicInfoByName() {
        String bookName = "假如给我三天光明";
//        BookBasicInfoDao bookBasicInfo = bookServiceAdapter.getBookBasicInfoByName(bookName);
//        System.out.println(bookBasicInfo);
    }

    @Test
    public void testQueryBooks() {
        String query = "假如";
        BookQueryVo bookQueryVo = null;
        try {
//            bookQueryVo = bookController.queryBooks("abc", query, 3);
        } catch (Exception e) {

        }
        System.out.println(bookQueryVo);
    }

    @Test
    public void testQueryFuzzBooks() {
        String query = "假如";
//        System.out.println(bookServiceAdapter.queryFuzzBooks(query, 3));
    }

}
