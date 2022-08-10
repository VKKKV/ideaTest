package atguigu.java.thread.java1;

/**
 * Created on 2022/3/3星期四9:57.
 *
 * @author abc
 */

class Account{
private double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public void deposit(double amt){
        if (amt>0){
            balance+=amt;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+
                    "余额为"+balance);
        }
    }
}

class customer extends Thread{
    private Account acct;

    public customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }
    }
}



public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(0);
        customer customer = new customer(acct);
        customer customer12 = new customer(acct);

        customer.setName("甲");
        customer12.setName("乙");

        customer.start();
        customer12.start();
    }

}
