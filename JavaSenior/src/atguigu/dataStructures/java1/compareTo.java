package atguigu.dataStructures.java1;

/**
 * Created on 2022/3/4星期五15:14.
 *
 * @author abc
 *
 * Java提供了一个Comparable接口，该接口里定义了一个compareTo(Object obj)方法，该方法返回一个整数值，实现该接口的类必须实现该方法，实现了该接口的类的对象就可以比较大小。当一个对象调用该方法与另一个对象进行比较时，例如obj1.compareTo(obj2)，如果该方法返回0，则表示两个对象相等，如果该方法返回一个正整数，则表明obj1大于obj2；如果该方法返回一个负整数，则表明obj1小于obj2。
 *
 * 下面是一些已经实现了Comparable接口的常用类
 *
 * BigDecimal类、BigInteger以及所有的数值型对应的包装类：按他们对应的数值大小进行比较
 * Character：按照字符的UNICODE值进行比较
 * Boolean：true对应的包装类实例大于false对应的包装类实例
 * String：按照字符的UNICODE值进行比较
 * Date\Time：后面的时间、日期比前面的时间、日期大
 *
 */
public class compareTo {
    public static void main(String[] args) {
        // 即参与比较的两个字符串如果首字符相同，则比较下一个字符，直到有不同的为止，
        // 返回该不同的字符的asc码差值，如果两个字符串不一样长，可以参与比较的字符又完全一样，则返回两个字符串的长度差值
        String str1 = "abc", str2 = "ab", str3 = "abccc", str4 = "abe";
        System.out.println("str1.compareTo(str2):" + str1.compareTo(str2));
        System.out.println("str2.compareTo(str1):" + str2.compareTo(str1));
        System.out.println("str1.compareTo(str3):" + str1.compareTo(str3));
        System.out.println("str1.compareTo(str4):" + str1.compareTo(str4));
        Integer num1 = 1, num2 = 4;
        System.out.println("num1.compareTo(num2):" + num1.compareTo(num2));
        System.out.println("num2.compareTo(num1):" + num2.compareTo(num1));
        Character a = 'a', d = 'd';
        System.out.println("a.compareTo(d):" + a.compareTo(d));
    }
}
