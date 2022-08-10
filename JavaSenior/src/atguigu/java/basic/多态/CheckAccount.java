package atguigu.java.basic.多态;

public class CheckAccount extends Account{

    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft=overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void withdraw(double amount){
        if (getBalance()>=amount){//余额足够
//            super.setBalance()-=amount;错误

            super.withdraw(amount);
            //setBalance(getBalance()-amount);

            return;
        }else if (overdraft>=amount-getBalance()){
            overdraft-=(amount-getBalance());
   //         setBalance(0);
            super.withdraw(getBalance());
        }else{
            System.out.println("超过可透支限额");
        }
    }
}
