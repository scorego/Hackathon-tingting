package wang.javior.hackathon.tingting.utilTest;

import wang.javior.hackathon.tingting.App;
import wang.javior.hackathon.tingting.utils.RandomUtil;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class RandomTest {


    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            val randomInt = RandomUtil.getRandomInt(0, 30);
            System.out.print(" " + randomInt);
        }
    }

    @Test
    public void testRandomArr() {
        val randomNums = RandomUtil.getRandomNums(100, 10);
        System.out.println(randomNums);
    }

}
