package atguigu.java.collectionTest.test1;

import java.util.TreeSet;

/**
 * Created on 2022/3/28星期一10:49
 *
 * @author abc
 */
public class treeSetTest {
    public static void main(String[] args) {
        Employee tom = new Employee("Tom", 22, new MyDate(2002, 12, 5));
        Employee jerry = new Employee("Jerry", 22, new MyDate(2002, 12, 5));


        TreeSet<Employee> treeSet = new TreeSet<>();
        treeSet.add(tom);
        treeSet.add(jerry);

        for (Employee o : treeSet) {
            System.out.println(o);
        }

    }
}
