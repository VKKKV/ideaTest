package atguigu.java.thread.java1;

/**
 * 多线程的创建方式一：继承Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类的对象
 * 4.通过对象调用start()
 *
 *
 * 例子遍历100偶数
 *
 * Created on 2022/3/1星期二21:24.
 *
 * @author abc
 */
public class ThreadTest {

    public static void main(String[] args) {
        MyThread t0 = new MyThread();
        MyThread t1 = new MyThread();


        //通过此对象调用start() 启动当前线程 调用当前线程的run()
        t0.start();
        t1.start();


        System.out.println("hello");

        //直接调run不是多线程
        //一个对象一个start



        //main中执行
        for (int i = 1 ; i <100; i++) {
            if (i%2!=0) {
                System.out.println(i + "-----------------main");
            }
        }

    }
}


class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }

    }
}

