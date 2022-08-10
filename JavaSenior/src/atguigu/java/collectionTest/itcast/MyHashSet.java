package atguigu.java.collectionTest.itcast;

import java.util.HashSet;

/**
 * Created on 2022/3/16星期三19:10
 *
 * @author abc
 *
 * hashset特性
 *
 */
public class MyHashSet {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();

        String str="space";

        //使用hashset通常需要重写hashcode和equals
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add(str);
        hashSet.add(str);//存在覆盖


        for (Object o : hashSet) {
            System.out.println(o);
        }
    }
}
