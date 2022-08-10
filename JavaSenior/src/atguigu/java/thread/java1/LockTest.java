package atguigu.java.thread.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁JDK5.0新增
 *
 * 1.面试题synchronized与Lock的异同
 * 同：二者都可以解决线程安全问题
 * 不同synchronized在执行同步代码后自动释放监视器
 *      lock需要手动启动和结束同步
 *
 *
 * Created on 2022/3/2星期三19:55.
 *
 * @author abc
 */
class WindowLock implements Runnable{
    private int ticket=100;
//实例化reentrantlock
    private ReentrantLock lock=new ReentrantLock();


    @Override
    public void run() {
        while (true){
            try {
                //调用锁定方法
                lock.lock();

                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+ticket);
                    ticket--;
                }else break;
            } finally {
                //调用解锁方法
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        WindowLock windowLock = new WindowLock();
        Thread t1 = new Thread(windowLock);
        Thread t2 = new Thread(windowLock);
        Thread t3 = new Thread(windowLock);

        t1.setName("窗口1 ");
        t2.setName("窗口2 ");
        t3.setName("窗口3 ");


        t1.start();
        t2.start();
        t3.start();
    }

}
