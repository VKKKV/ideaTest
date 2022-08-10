package atguigu.dataStructures.java1;

/**
 * Created on 2022/3/18星期五11:23
 *
 * @author abc
 */
public class fibonacci {
    public static void main(String[] args) {
        System.out.println(f(10));
    }

    static int f(int i){
        if (i==0){
            return 0;
        }else if (i==1){
            return 1;
        }
        else{
            return f(i-1)+f(i-2);
        }
    }
}
