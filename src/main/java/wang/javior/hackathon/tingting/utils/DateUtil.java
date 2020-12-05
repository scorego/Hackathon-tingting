package wang.javior.hackathon.tingting.utils;


import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateUtil {

    public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";

    public static String getFormatDate(Date source, String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(source);
        } catch (Exception e) {
            log.warn("getFormatDate exception, source: [{}], pattern: [{}]", source.toString(), pattern);
        }
        return null;
    }

    public static String parseDefaultFormat(Date date) {
        return getFormatDate(date, DEFAULT_FORMAT);
    }

}
