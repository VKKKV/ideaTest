package atguigu.dataStructures.java1;

/**
 * Created on 2022/3/4星期五13:18.
 *
 * @author abc
 * <p>
 * Character字符函数使用：（返回boolean）
 * 1：Character.isLetter('a'); 判断是不是字符
 * 2：Character.isDigit('3'); 判断是不是数字
 * 3：Character.isWhitespace('\t'、'\n'、' ') 判断是不是空格
 * 4：Character.isUpperCase('A') 判断是不是大写
 * 5：Character.isLowerCase('a') 判断是不是小写
 * 6：Character.toUpterCase('a') 指定为大写，返回字符
 * 7：Character.toLowerCase('A') 指定为小写，返回字符
 * 8：Character.toString('a') 返回字符串的形式
 */
public class CharacterTest {
    public static void main(String[] args) {
        //public static boolean isUpperCase(char ch):判断给定的字符是否是大写字符
        System.out.println("isUpperCase:" + Character.isUpperCase('A'));
        System.out.println("isUpperCase:" + Character.isUpperCase('a'));
        System.out.println("isUpperCase:" + Character.isUpperCase('0'));
        System.out.println("---------------------------------");

        //public static boolean isLowerCase(char ch):判断给定的字符是否是小写字符
        System.out.println("isLowerCase:" + Character.isLowerCase('A'));
        System.out.println("isLowerCase:" + Character.isLowerCase('a'));
        System.out.println("isLowerCase:" + Character.isLowerCase('0'));
        System.out.println("---------------------------------");

        //public static boolean isDigit(char ch):判断给定的字符是否是数字字符
        System.out.println("isDigit:" + Character.isDigit('A'));
        System.out.println("isDigit:" + Character.isDigit('a'));
        System.out.println("isDigit:" + Character.isDigit('0'));
        System.out.println("---------------------------------");

        //public static char toUpperCase(char ch):把给定的字符转换为大写字符
        System.out.println("toUpperCase:" + Character.toUpperCase('A'));
        System.out.println("toUpperCase:" + Character.toUpperCase('a'));
        System.out.println("---------------------------------");

        //public static char toLowerCase(char ch):把给定的字符转换为小写字符
        System.out.println("toLowerCase:" + Character.toLowerCase('A'));
        System.out.println("toLowerCase:" + Character.toLowerCase('a'));

    }
}
