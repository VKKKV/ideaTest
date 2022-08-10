package atguigu.java.collectionTest.itcast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created on 2022/3/15星期二19:59.
 *
 * @author abc
 * 迭代器
 * 使用迭代器遍历集合中的数组
 *
 */
public class MyIterator {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        objects.add("two");
        objects.add("3");
        objects.add("4");

        Iterator<Object> iterator= objects.iterator();



        while (iterator.hasNext()){//判断是否有下一个元素

//            Object obj=iterator.next();
            //自动转型
            System.out.println(iterator.next());
        }

        //增强for循环
//        for (Object obj:objects){
//            System.out.println(obj);
//        }



//        iterator.next();
//        iterator.next();
//        iterator.next();
//        iterator.next();
//        iterator.next();
        //.NoSuchElementException
    }
}
