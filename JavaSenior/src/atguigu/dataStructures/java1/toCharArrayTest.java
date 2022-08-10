package atguigu.dataStructures.java1;

/**
 * Created on 2022/3/4星期五13:55.
 *
 * @author abc
 */
public class toCharArrayTest {
    public static void main(String[] args) {
        String s1 = new String("我是中国人");

        char[] c = s1.toCharArray();

        System.out.println("数组c的长度为：" + c.length);

        System.out.println(c);

        System.out.println(new String(c));


        String s2 = new String(c,0,3);


        System.out.println(s2);
        System.out.println(s2.substring(0,2));
    }
}
