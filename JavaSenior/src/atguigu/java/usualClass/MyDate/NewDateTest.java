package atguigu.java.usualClass.MyDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created on 2022/3/22星期二20:32
 *
 * @author abc
 *
 * jdk8新增日期api
 *
 * localdate
 * localtime
 * localdatetime
 *
 * now/of/get/with(设置)不可变性/minusXxx,plusXxx相比calendar区分加减
 *
 *
 *
 */
public class NewDateTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1);

        LocalDateTime of = LocalDateTime.of(2022, 3, 22, 20, 53, 0);
        System.out.println(of);




        System.out.println(now1.getHour());
        System.out.println(now1.getMinute());

        //体现不可变性
        LocalDateTime localDateTime = now1.withDayOfMonth(1);
        System.out.println(now1);
        System.out.println(localDateTime);

        //不可变性
        LocalDateTime localDateTime1 = now1.plusDays(1);
        LocalDateTime localDateTime2 = now1.minusYears(1);
        System.out.println(now1);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);


    }
}
