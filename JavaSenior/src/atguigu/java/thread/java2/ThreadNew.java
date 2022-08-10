package atguigu.java.thread.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created on 2022/3/11星期五21:54.
 *
 * @author abc
 * 创建线程的方式三：实现Callable接口---JDK5.0新增
 *
 *
 */
class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
            if (i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }

}

public class ThreadNew {
    public static void main(String[] args) {
        //创建callable接口实现类的对象
        NumThread numThread = new NumThread();
        //将此
        FutureTask futureTask = new FutureTask(numThread);


    }

}
