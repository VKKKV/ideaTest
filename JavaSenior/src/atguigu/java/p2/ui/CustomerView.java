package atguigu.java.p2.ui;
import atguigu.java.p2.bean.Customer;
import atguigu.java.p2.util.CMUtility;
import atguigu.java.p2.service.CustomerList;

public class CustomerView {
    public CustomerView(){
        Customer customer=new Customer("wang",'男',23,"123456","wt@gmail.com");
    }
    private CustomerList customerList=new CustomerList(10);
    public void enterMainMenu(){
        boolean isFlag=true;
        while (isFlag) {
            System.out.println("\n--------客户信息管理软件---------");
            System.out.println("1添加客户");
            System.out.println("2修改客户");
            System.out.println("3删除客户");
            System.out.println("4客户列表");
            System.out.println("5退 出\n");
            System.out.print("请选择（1-5）");
            char menu = CMUtility.readerMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case'2':
                    modifyCustmer();
                    break;
                case'3':
                    deleteCustomer();
                    break;
                case'4':
                    listAllCustomers();
                    break;
                case'5':
                    System.out.print("退出");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit=='y'){
                        isFlag=false;
                    }
            }
           // isFlag = false;
        }
    }

    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
    private void addNewCustomer () {
            System.out.println("添加客户");
    }
    private void modifyCustmer () {
            System.out.println("修改客户");
    }
    private void deleteCustomer () {
            System.out.println("删除客户");
    }
    private void listAllCustomers() {
            System.out.println("查看客户");
            System.out.println("------------------");
            int total = customerList.getTotal();
            if (total == 0) {
                System.out.println("没有记录");
            } else {
                System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
                Customer[] custs = customerList.getAllCustomers();
                for (int i = 0; i < custs.length; i++) {
                    Customer cust = custs[i];
                    System.out.println((i + 1) + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());
                }
            }
            System.out.println("---------完成--------");
    }


}
