package atguigu.java.basic.多态;

public class AccountTest {
    public static void main(String[] args) {
        Account account=new Account(1122,20000,0.045);
        account.withdraw(30000);
        System.out.println(account.getBalance());
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("余额 "+account.getBalance()
                +" 月利率 "+(account.getMonthlyInterest()*100)+"%");
    }
}
