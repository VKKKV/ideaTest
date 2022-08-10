package atguigu.java.collectionTest.itcast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created on 2022/3/15星期二21:25
 *
 * @author abc
 *
 * 利用迭代器在集合中查找并删除一个元素
 *
 */
public class IteratorTest {
    public static void main(String[] args) {
        //可将其看作长度可变的数组
        ArrayList<Object> arr = new ArrayList<>();
        arr.add("1");
        arr.add("删我");
        arr.add("3");
        arr.add("4");

        Iterator<Object> it =arr.iterator();

//迭代器
        while (it.hasNext()){
            //查找删除
            if (it.next().equals("删我")){

//          删除了3      arr.remove(it.next());
                it.remove();
            }
        }
//增强for循环
        for (Object object:arr){
            System.out.println(object);
        }

    }
}
