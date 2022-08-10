package atguigu.java.usualClass.java1;

/**
 * Created on 2022/3/20星期日17:07
 *
 * @author abc
 *
 * String\StringBuffer\StringBuilder区别
 * String 不可变的字符序列
 * StringBuffer\StringBuilder 可变的字符序列
 *
 * StringBuffer 线程安全的 效率低
 * StringBuilder 线程不安全的 效率高 5.0新增
 *
 *
 */
public class StringBufferBuilder {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("helloWorld");
        str.reverse();//反转
        System.out.println(str);
        str.setCharAt(0 ,'O');//修改charAt
        System.out.println(str);
    }
}
