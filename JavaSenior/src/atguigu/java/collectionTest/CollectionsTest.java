package atguigu.java.collectionTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on 2022/3/28星期一18:43
 *
 * @author abc
 *
 * Collections:操作Collection、Map的工具类
 *
 * 面试题：Collection和Collections的区别
 *
 * reverse(list)：反转list中元素的顺序
 * shuffle(list)：对list集合元素进行随机排序
 * sort(list)：根据元素的自然顺序对指定list集合元素按升序排序
 * sort(list,comparator)：根据指定的comparator产生的顺序对list集合元素进行排序
 * swap(list,int,int):将指定list集合中的i处元素和j处元素进行交换
 *
 * void copy(list dest,list src):将src中的内容复制到dest中
 */
public class CollectionsTest {
//void copy(list dest,list src):将src中的内容复制到dest中
@Test
    public void test1(){
    ArrayList<Object> list = new ArrayList<>();
    list.add(123);
    list.add(123);
    list.add(123);
    list.add(123);

    //注意：dest的长度
    List<Object> list1 = Arrays.asList(new Object[list.size()]);
    Collections.copy(list1,list);

    for (Object o : list1) {
        System.out.println(o);
    }
}

//如果需要线程安全的collection或map
@Test
    public void test2(){
    ArrayList<Object> list = new ArrayList<>();
    List<Object> objects = Collections.synchronizedList(list);



}


}
