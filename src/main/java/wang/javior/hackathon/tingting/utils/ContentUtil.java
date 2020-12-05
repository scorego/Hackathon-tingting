package wang.javior.hackathon.tingting.utils;

import lombok.NonNull;
import lombok.val;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class ContentUtil {

    private static final Set<String> end =
            new HashSet<>(Arrays.asList("<p>", "</p>", "“", "”", ".", "。", "!", "！", "?", "？", "…", "\"", "\"", "』", ":", "："));

    public static List<String> cutTextIntoSentences(String text) {
        List<String> sentences = new ArrayList<>();
        if (StringUtils.isEmpty(text)) {
            return sentences;
        }
        // 数据清洗
        String cleanedText = cleanText(text);
        // 切句
        val split = cutText(cleanedText);
        sentences.addAll(Arrays.asList(split));

        return sentences.stream()
                .map(ContentUtil::trimSentence)
                .filter(ContentUtil::filterSentence)
                .collect(Collectors.toList());
    }

    private static String trimSentence(String sentence) {
        return StringUtils.isEmpty(sentence) ? sentence : sentence.trim();
    }

    /**
     * 过滤不合格的句子
     */
    private static boolean filterSentence(String sentence) {
        return !StringUtils.isEmpty(sentence) && !"\n".equals(sentence);
    }

    private static String[] cutText(@NonNull String text) {
        return text.split("\n");
    }

    /**
     * 数据清洗
     */
    public static String cleanText(@NonNull String originalText) {
        String text = originalText;
        for (String s : end) {
            text = text.replace(s, "\n");
        }
        return text;
    }

}
