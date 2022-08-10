package atguigu.java.thread.java1;

/**
 * Created on 2022/3/2星期三15:49.
 *
 * @author abc
 */


class Window2 extends Thread {
    private static int ticket = 100;
//    private static Object obj=new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (Window3.class){
            //synchronized (this) {//当前对象，唯一
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
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


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.start();
        t2.start();
        t3.start();

    }
}

