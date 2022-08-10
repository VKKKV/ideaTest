package atguigu.java.thread.java1;

/**
 * Created on 2022/3/2星期三9:43.
 *
 * @author abc
 *
 * 创建三个窗口卖票，100张
 *
 */

class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(getName()+":票号为"+ticket);
                ticket--;
            }else break;
        }
    }
}




public class WindowTest {
    public static void main(String[] args) {
        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();



    }
}
