package atguigu.java.usualClass.MyDate;

import java.util.Date;

/**
 * Created on 2022/3/21星期一19:45
 *
 * @author abc
 * 1970/01/01 0:0:0
 *
 *
 * Date.getTime()
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        String str="";
//        str.indexOf()

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());//获得时间戳



    }
    public static int MyindexOf(byte[] value, int valueCount, byte[] str, int strCount, int fromIndex) {
        byte first = str[0];
        int max = (valueCount - strCount);
        for (int i = fromIndex; i <= max; i++) {
            // Look for first character.
            if (value[i] != first) {
                while (++i <= max && value[i] != first);
            }
            // Found first character, now look at the rest of value
            if (i <= max) {
                int j = i + 1;
                int end = j + strCount - 1;
                for (int k = 1; j < end && value[j] == str[k]; j++, k++);
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
    }


}
