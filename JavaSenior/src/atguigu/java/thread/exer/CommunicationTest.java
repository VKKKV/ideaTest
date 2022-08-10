package atguigu.java.thread.exer;

/**
 * 线程通信的例子：使用两个线程打印1-100.线程1，线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行，线程阻塞，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒wait的一个方法。
 *              如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll()：唤醒所有被wait的线程
 *
 * 说明：
 * 1.wait() notify()notifyAll()必须使用在同步代码块
 * 或同步方法中。
 *
 * 2.wait() notify()notifyAll()的调用者必须是同步代码块
 * 或同步方法中的同步监视器。
 * 否则会出现IllegalMonitorStateException
 *
 * 3.wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中
 *
 *
 * 面试题：sleep()和wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2.不同点：1）两个方法声明的位置不同，Thread类中声明sleep()，
 *              object类中声明wait()
 *          2)调用的要求不同,sleep()可以在任何需要场景下调用，wait()必须使用在同步代码块或同步方法中
 *          3)如果两个方法都使用在同步方法中或同步代码块中，sleep不会释放锁，wait会释放锁
 *
 *
 * Created on 2022/3/8星期二12:27.
 *
 * @author abc
 */
class Number implements Runnable{
    private Object obj=new Object();
    private int number=1;
    @Override
    public void run() {

        while (true){

            synchronized (this) {//obj

                notify();//obj.notify

                if (number<=100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+
                            ":"+number);
                    number++;

                    try {
                        wait();//使得线程阻塞 释放lock//obj.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
