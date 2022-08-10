package atguigu.java.usualClass.MyDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created on 2022/3/23星期三11:17
 *
 * @author abc
 *
 * 格式化与解析日期或时间
 * 格式化方法：
 *          ofPattern(str)指定格式
 *          format格式化一个日期时间
 *          parse将指定格式的字符序列解析为日期时间
 *
 */
public class TestDateTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter dateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String s = dateTime.format(LocalDateTime.now());
        System.out.println(s);

        //自定义格式化
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = pattern.format(LocalDateTime.now());
        System.out.println(format);

    }
}
