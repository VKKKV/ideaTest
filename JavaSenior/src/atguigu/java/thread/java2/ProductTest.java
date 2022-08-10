package atguigu.java.thread.java2;

/**
 * Created on 2022/3/8星期二13:24.
 *
 * @author abc
 *
 * 线程通信：生产者/消费者问题
 *
 *
 *
 *
 *
 *
 *
 */
class Clerk{
    private int product=0;

    public synchronized void pro(){

        if (product<20) {
            product++;
            System.out.println(Thread.currentThread().getName()+
                    "开始生产第"+product);
            notify();

        }

        if (product==20) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void cus(){


        if (product>0) {
            System.out.println(Thread.currentThread().getName()+
                "开始消费第"+product);
            product--;
            notify();
        }

        if (product==0) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
                    System.out.println(Thread.currentThread().getName()
                            + "生产");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.pro();
        }
    }
}

class Customer extends Thread{
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
                    System.out.println(Thread.currentThread().getName()
                    +"消费");
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.cus();

        }
    }

}

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer = new Customer(clerk);

        producer.setName("Producer");
        customer.setName("Customer");

        producer.start();
        customer.start();
    }
}
