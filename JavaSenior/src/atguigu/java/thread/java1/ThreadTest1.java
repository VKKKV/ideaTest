package atguigu.java.thread.java1;

/**
 * Created on 2022/3/2星期三13:20.
 *
 * @author abc
 * <p>
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法run
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 *
 *
 * 比较创建线程的两种方式。
 *开发中：优先选择实现Runnable接口
 * 原因：没有类的单继承性的局限性
 *       更适合多线程共享数据的情况
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明
 * 在run中
 *
 *
 */

// 1.创建一个实现了Runnable接口的类
class MThread implements Runnable {
    //  2.实现类去实现Runnable中的抽象方法run
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
        }
    }
}


public class ThreadTest1 {

    public static void main(String[] args) {

         // 3.创建实现类的对象
        MThread m1 = new MThread();

//  4.将此对象作为参数传递到Thread构造器中，创建Thread类的对象
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);

        //  5.通过Thread类的对象调用start()
        t1.start();
        t2.start();



    }

}

