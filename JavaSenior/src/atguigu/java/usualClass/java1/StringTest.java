package atguigu.java.usualClass.java1;

/**
 * Created on 2022/3/20星期日10:38
 *
 * @author abc
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "HelloWorld";
        String s2=s1.toLowerCase();
        System.out.println(s1);//s1调用方法不会修改s1
        System.out.println(s2);

        System.out.println(s1.equalsIgnoreCase(s2));//比较忽略大小写

        String s3="   Hello  World   ";
        String s4 = s3.trim();//忽略前后空白
        System.out.println(s3);
        System.out.println(s4);
    }
}
