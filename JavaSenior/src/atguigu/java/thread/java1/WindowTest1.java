package atguigu.java.thread.java1;

/**
 * Created on 2022/3/2星期三13:35.
 *
 * @author abc
 *
 *
 * 例子：创建三个窗口卖票，总票数为100张，使用实现Runnable
 * 接口的方式
 * 1.存在线程的安全问题，待解决
 * 2.问题出现的原因：：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来
 * 也操作车票。
 * 3.如何解决：当一个线程在操作共享数据的时候其他线程不能参与进来。知道线程a
 * 操作完，其他线程才开始操作。这种情况即使线程a出现了阻塞，也不能被改变
 * 4.在java中通过同步机制解决线程安全问题
 * 方式一：同步代码块
 * synchronized(同步监视器){
 *     //需要同步的代码
 * }
 * 说明：1操作共享数据的代码，即为需要被同步的代码
 *      2共享数据：多个线程共同操作的变量.比如：ticket就是共享数据
 *      3同步监视器，：锁。任何一个类的对象
 *          要求：多个线程必须要公用同一把锁。
 *      补充：：在实现Runnable接口创建多线程的方式中，我们可以考虑使用
 *      this充当同步监视器
 *
 * 方式二：同步方法。
 *      如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
 *      同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
 *
 *
 *
 */


class Window1 implements Runnable{
    private  int ticket=100;
    Object obj =new Object();

    @Override
    public void run() {

        while (true){
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "\t" + ticket);

                    ticket--;
                } else break;
            }
        }
    }
}



public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();


        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);
        t1.start();
        t2.start();
        t3.start();

    }
}
