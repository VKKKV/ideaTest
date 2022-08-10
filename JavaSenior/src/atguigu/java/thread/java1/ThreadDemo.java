package atguigu.java.thread.java1;

/**
 * Created on 2022/3/1星期二23:14.
 *
 * @author abc
 *
 * 创建两个分线程，一个遍历100偶数，一个奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        myEvenThread even=new myEvenThread();
//        myOddThread odd = new myOddThread();
//        even.start();
//        odd.start();


//创建Thread的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();


    }
}

class myEvenThread extends Thread{
    @Override
    public void run() {
        for (int i = 2; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class myOddThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
