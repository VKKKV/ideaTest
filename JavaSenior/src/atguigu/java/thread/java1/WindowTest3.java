package atguigu.java.thread.java1;

/**
 * Created on 2022/3/2星期三16:45.
 *
 * @author abc
 * <p>
 * 使用同步方法实现Runnable接口的线程安全问题
 *
 *
 *
 */
class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();

        }
    }
//public static synchronized void show (){}静态同步监视器唯一 Window3.class
    public synchronized void show() {//同步监视器this当前对象
//        synchronized (this) {
            if (ticket > 0) {

                System.out.println(Thread.currentThread().getName()
                        + "\t" + ticket);
                ticket--;
            }
//        }
    }


}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();

        Thread t1 = new Thread(window3);
        Thread t2 = new Thread(window3);
        Thread t3 = new Thread(window3);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}