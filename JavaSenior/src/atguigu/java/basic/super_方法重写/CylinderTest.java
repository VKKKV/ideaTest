package atguigu.java.basic.super_方法重写;
/**
 *super关键字
 * super.属性 super.方法显式的调用父类中声明的属性或方法  通常习惯省略super
 * 当同名属性 必须显式的使用super.属性的方式，表明调用的身
 * 调用 父类 属性 方法 构造器父类中声明的属性
 * 间接父类 逐层向上调用
 *
 *super调用构造器
 * 1.在子类的构造器中显式的使用super（形参列表）的方式 调用父类中声明的指定的构造器
 * 2.super（形参列表）必须声明在子类构造器的首行
 * 3.在类的构造器中 对于this（形参列表）或super（形参列表只能二选一）
 * 4.在构造器的首行，没有显式的声明 this（形参列表）或super（形参列表） 则默认调用
 * 的是父类中空参的构造器super（）
 *5.在类的多个构造器中 至少有一个类的构造器中使用了super（形参列表）调用父类中的构造器
 *
 *
 */

/**
 *
 * 方法重写
 * 子类继承父类 对父类中同名同参数的方法进行覆盖操作
 * 区分方法的重载与重写
 *
 * 规定
 *方法的声明 权限修饰符 返回值类型 方法名（形参列表） throws 异常的类型｛方法体｝
 * 子类中重写的方法
 * 父类中被重写的方法
 * 1.子类重写的方法的方法名和形参列表与父类被重写的方法的方法名和形参列表相同
 * 2.权限修饰符不小于被重写的方法的权限修饰符
 *      子类不能重写父类中声明为private权限的方法
 * 3.返回值类型：
 *      父类被重写的方法的返回值类型是void 重写只能是void
 *      返回值是a类 重写只能是a类或a类的子类
 *      基本数据类型（double），相同基本数据类型（double）
 * 4.子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 * 子类和父类中的同名同参数的方法要么都声明为非static的（考虑重写），要么都声明为static的（不重写）
 *
 */

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder();
        cylinder.setRadius(10);
        cylinder.setLength(10);
        System.out.println(cylinder.findArea());
        System.out.println(cylinder.findVolume());
    }
}
