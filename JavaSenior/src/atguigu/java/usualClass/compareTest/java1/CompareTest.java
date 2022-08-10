package atguigu.java.usualClass.compareTest.java1;

import java.util.Arrays;

/**
 * Created on 2022/3/23星期三11:49
 *
 * @author abc
 *
 * 说明：Java中的对象，正常情况下，只能进行比较：== 或 ！=。不能使用 > 或 < 的
 *      但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小》
 *    两个接口：Comparable 或 Comparator
 *
 */
public class CompareTest {

    /**
     *
     * @param args
     *
     * Comparable接口的使用举例：
     *      1.像String、包装类等实现了Comparable接口，重写了compareTO方法，给出比较两个
     *      对象的方法
     *      2.像String、包装类重写compareTo方法以后，进行了从小到大的排列
     *      3.重写compareTo规则：
     *              如果当前对象this大于形参对象obj，则返回正整数
     *              如果当前对象this小于形参对象obj，则返回负整数
     *              如果当前对象this等于形参对象obj，则返回零
     *      4.对于自定义类来说，如果需要排序，我们可以让自定义类实现comparable接口，重写
     *      compareTo
     *      在compareTo中指明如何排序
     *
*      Comparator接口的使用：定制排序
     *      1.背景：
     *          当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
     *          或者实现了java.lang.Comparator的对象来排序
 *          2.重写compare(o1,o2)方法,比较大小：如果返回正整数......
     *
     */


    public static void main(String[] args) {
        String[] str= new String[]{"AA", "BB", "YY", "XX"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
    }
}
