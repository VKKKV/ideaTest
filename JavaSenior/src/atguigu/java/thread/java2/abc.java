package atguigu.java.thread.java2;

/**
 * Created on 2022/3/18星期五22:41
 *
 * @author abc
 */
public class abc implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
