package wang.javior.hackathon.tingting.utilTest;

import wang.javior.hackathon.tingting.App;
import wang.javior.hackathon.tingting.utils.ContentUtil;
import lombok.val;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest(classes = App.class)
public class ContentTest {

    @Test
    public void testRandom() {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("");
        strList.add("</p><p>“够了！””</p><p>你没看见吗？她打我！”</p><p>打红了！");
        for (String originalStr : strList) {
            val newStr = ContentUtil.cutTextIntoSentences(originalStr);
            System.out.println(originalStr);
            for (String s : newStr) {
                System.out.println(s);
            }
        }

    }

}
