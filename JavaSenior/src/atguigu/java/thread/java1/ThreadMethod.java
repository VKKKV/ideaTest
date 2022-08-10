package atguigu.java.thread.java1;

/**
 * Created on 2022/3/1星期二23:30.
 *
 * @author abc
 * <p>
 * 测试Thread中的常用方法
 * 1.start启动当前线程；调用当前线程的run方法
 * 2.run通常需要重写Thread类中的此方法，将创建的线程执行的操作声明于此
 * 3.currentThread静态方法，返回当前代码的线程
 * 4.getName获取当前线程的名字
 * 5.setName设置当前线程的名字
 * 6.yield释放当前CPU执行权
 * 7.join在线程a中调用线程b的join，此时线程a进入阻塞状态，直到线程b完全执行后在执行线程a
 * 8.stop已过时。执行此方法，强制结束当前线程
 * 9.sleep(long millitime)让当前线程睡眠指定的millitime毫秒。在指定时间内当前线程是阻塞状态
 * 10.isAlive判断当前线程是否存活
 * <p>
 * <p>
 * 线程优先级
 * 1.MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5
 * 2.如何获取和设置当前线程的优先级
 *   getPriority获取线程的优先级
 *   setPriority设置线程的优先级
 *
 *  说明：高优先级线程要抢占低优先级CPU的执行权，但是只是从概率上讲，高优先级高概率被执行
 *  ，并不意味着只有高优先级的线程执行完毕低优先级的线程才执行
 *
 *
 *
 */

class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if (i % 2 == 0) {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName()
                        +getPriority()+ ":" + i);
            }


            if (i % 20 == 0) {
                this.yield();
            }


        }
    }

    //构造器方式命名
    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethod {

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("Thread:1");

        helloThread.setPriority(Thread.MIN_PRIORITY);

        helloThread.start();

        //给主线程命名

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()
                        +Thread.currentThread().getPriority()+ ":" + i);
            }
//            if (i == 20) {
//                try {
//                    helloThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(helloThread.isAlive());
    }
}
