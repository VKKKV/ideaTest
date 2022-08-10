package atguigu.dataStructures.java1;

/**
 * Created on 2022/3/18星期五11:35
 *
 * @author abc
 */
public class gcd {
    public static void main(String[] args) {
        System.out.println(g(4, 8));
    }

    static int g(int a,int b){
        if (a%b==0){
            return b;
        }
        else{
            return g(b,a%b);
        }
    }
}
