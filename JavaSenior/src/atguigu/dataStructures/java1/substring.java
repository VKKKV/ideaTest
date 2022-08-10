package atguigu.dataStructures.java1;

/**
 * Created on 2022/3/4星期五15:18.
 *
 * @author abc
 *
 *
 *1)、substring(a,b)中的参数a其值可以从索引值0开始，
 *
 *        当a等于0时，则表示其从字符串的第一个字符开始算起，
 *
 *        也就是其子字符串是包含第一个字符的，当然，你也可以从后续的其他字符开始；
 *
 * 2)、substring(a,b)中的参数b,其值最大可以为 父字符串的长度，
 *
 *        但并不包含索引值为b的那个字符。
 *
 */
public class substring {
    public static void main(String[] args) {

                String test = "Hello World !";

                String subTest1 = test.substring(0,3);
                System.out.println("subTest:" + subTest1);

                String subTest2 = test.substring(0,test.length());
                System.out.println("subTest:" + subTest2);


    }
}
