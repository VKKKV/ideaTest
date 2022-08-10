package atguigu.dataStructures.Recursion;

/**
 * Created on 2022/6/30星期四23:28
 *
 * @author abc
 * 递归调用规则:
 * 当程序执行到一个方法时，就会开辟一个独立的空间（栈）
 * 1.执行一个方法时，就创建一个新的受保护的独立空间（栈空间）
 * 2.方法的局部变量时独立的，不会互相影响
 * 如果方法中使用的是引用类型的变量，就会共享该应用类型的数据
 *
 * 3.递归必须向退出递归的条件逼近，否则就是无限递归
 * 4.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用就将结果返回
 * 给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕
 *
 *
 *
 *
 */
public class recursionTest {
    public static void main(String[] args) {

    }
}
