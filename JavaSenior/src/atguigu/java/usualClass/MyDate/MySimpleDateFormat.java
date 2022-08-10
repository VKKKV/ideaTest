package atguigu.java.usualClass.MyDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2022/3/22星期二12:06
 *
 * @author abc
 */
public class MySimpleDateFormat {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        String format = simpleDateFormat.format(new Date());
//        System.out.println(format);


        Date date=simpleDateFormat.parse("2012-01-01 00:00:00");

        System.out.println(date);
    }
}
