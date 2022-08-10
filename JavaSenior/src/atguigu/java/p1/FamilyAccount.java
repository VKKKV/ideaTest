package atguigu.java.p1;
/**
 * 无限循环结构
 * while(true)或for(;;)
 * */

public class FamilyAccount {

    public static void main(String[] args) {

        boolean loopFlag=true;
        int balance=10000;
        String details = "";
        do {
            System.out.print("-----------------家庭收支记账软件----------------\n" +
                    "\n                  1 收支明细 " +
                    "\n                  2 登记收入 " +
                    "\n                  3 登记支出 " +
                    "\n                  4 退 出" +
                    "\n\n" +
                    "                请选择(1-4)：");
            char chose=Utility.readMenuSelection();
            System.out.println();
            switch (chose) {
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.print("收支\t账户金额\t收支金额\t说 明\n");
                    System.out.print(details);
                    System.out.println("-----------------------------------------------");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    int money=Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String info = Utility.readString();
                    System.out.println("登记完成");
                    balance+=money;
                    details="收入\t"+balance+"\t"+money+"\t\t"+info+"\n";
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    int minusMoney=Utility.readNumber();
                    if (minusMoney>balance){
                        System.out.println("超出额度");
                        break;
                    }
                    balance-=minusMoney;
                    System.out.print("本次支出说明：");
                    String minusInfo = Utility.readString();
                    System.out.println("登记完成");
                    details="支出\t"+balance+"\t"+minusMoney+"\t\t"+minusInfo+"\n";
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    if (Utility.readConfirmSelection() == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }
        while (loopFlag);
    }
}
