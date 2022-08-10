package atguigu.java.usualClass.MyDate;

import java.util.Calendar;
import java.util.Date;

/**
 * Created on 2022/3/22星期二18:34
 *
 * @author abc
 *
 *
 * jkd8前的日期api
 *
 * Calendar日历类(抽象类)的使用
 *
 * 1.实例化
 *  方式一：创建其子类(GregorianCalendar)的对象
 *  方式二：调用其静态方法getInstance()
 *
 * 2.常用方法：
 *  get/set/add/getTime/setTime
 *
 * set一月是0
 * 周日是1
 *
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        //get
        int date=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);

        //set
        calendar.set(Calendar.DAY_OF_MONTH,1);//calender的属性可以修改
        date=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);

        //add
        calendar.add(Calendar.DAY_OF_MONTH,2);//calender的属性可以加减(amount为负数为减)
        date=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);

        //getTime:get calendar -->date
        Date time = calendar.getTime();
        System.out.println(time);//如果有修改输出calendar修改后的时间

        //setTime:set date --> calendar
        Date date1 = new Date();
        calendar.setTime(date1);
        date=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(date);



    }
}