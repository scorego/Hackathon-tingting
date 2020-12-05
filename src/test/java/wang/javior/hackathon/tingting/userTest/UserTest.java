package wang.javior.hackathon.tingting.userTest;

import wang.javior.hackathon.tingting.App;
import wang.javior.hackathon.tingting.core.UserServiceAdapter;
import wang.javior.hackathon.tingting.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    UserServiceAdapter userServiceAdapter;

    @Test
    public void testUser() {
//        String openId = "abcdefg";
//
//        val cnt = userService.countUserByOpenid(openId);
//        System.out.println(cnt);
//        userService.insertUser(openId);
//        System.out.println(userServiceAdapter.countAll());
    }

}
