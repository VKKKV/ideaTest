package atguigu.java.basic.多态;

/**
 *多态性
 * 对象的多态性
 * ：父类的引用指向子类的对象
 *
 * 虚拟方法调用
 * 编译看左 运行看右
 *
 * 多态性的使用前提
 * 1.类的继承关系
 * 2.方法的重写
 * 对象的多态性只适用于方法 不适用于属性（编译运行都看右）
 * 运行时行为
 *
 * 内存中实际加载了子类特有的属性和方法，由于声明变量为父类类型导致编译
 * 时只能调用父类中声明的属性和方法 子类特有的属性和方法不能调用
 *
 * 如何调用子类特有的属性和方法
 * 使用强制类型转换符 向下转型
 * Man m1=(Man)p2;
 */
public class CheckAccountTest {
    public static void main(String[] args) {
        CheckAccount checkAccount=new CheckAccount(1122,20000,0.045,5000);
        checkAccount.withdraw(5000);
        System.out.println("您的账户余额："+ checkAccount.getBalance());
        System.out.println("您的可透支额："+checkAccount.getOverdraft());

        checkAccount.withdraw(18000);
        System.out.println("您的账户余额："+ checkAccount.getBalance());
        System.out.println("您的可透支额："+checkAccount.getOverdraft());

        checkAccount.withdraw(3000);
        System.out.println("您的账户余额："+ checkAccount.getBalance());
        System.out.println("您的可透支额："+checkAccount.getOverdraft());

    }
}
