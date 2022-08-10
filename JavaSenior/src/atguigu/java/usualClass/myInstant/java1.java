package atguigu.java.usualClass.myInstant;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Created on 2022/3/22星期二21:12
 *
 * @author abc
 * instant：瞬时
 *      时间线上的一个瞬时点。
 *
 * 常用方法：now/ofEpochMilli/atOffset/toEpochMilli(时间戳)
 */
public class java1 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);//中时区

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
}
