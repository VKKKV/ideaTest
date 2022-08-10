package atguigu.java.p2.service;
import atguigu.java.p2.bean.Customer;

public class CustomerList {
    private Customer[] customers;
    private int total;
    public CustomerList(int total){
        customers=new Customer[total];
    }
    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            return false;
        }
        customers[total++]=customer;
        return true;
    }
    public boolean repalceCustomer(int index,Customer cust){
        if (index < 0 || index >= total){
            return false;
        }
        customers[index]=cust;
        return true;
    }
    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total) {
            return false;
        }
        for(int i=index;i< total;i++){
            customers[i]=customers[i+1];
        }
        customers[--total]=null;
        return true;
    }
    public Customer[] getAllCustomers(){
            Customer[] custs=new Customer[total];
            for(int i=0;i<total;i++){
                custs[i]=customers[i];
            }
            return custs;
    }
    public Customer getCustomers(int index){
        if (index<0||index>=total){
            return null;
        }
        return customers[index];
    }
    public int getTotal(){
        return total;
    }
}
