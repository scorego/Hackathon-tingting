package wang.javior.hackathon.tingting.userTest;

import wang.javior.hackathon.tingting.App;
import wang.javior.hackathon.tingting.core.UserServiceAdapter;
import wang.javior.hackathon.tingting.service.UserHistoryService;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class UserHistoryTest {

    @Autowired
    private UserHistoryService userHistoryService;

    @Autowired
    UserServiceAdapter userServiceAdapter;

    @Test
    public void testGetUserHistoryLastChapterIndex() {
        String openId = "abcdefg";
        String bookName = "假如给我三天光明";
//        val lastUserHistory = userHistoryService.getUserHistoryLastChapterIndex(openId, bookName);
//        System.out.println(lastUserHistory);
    }

}
