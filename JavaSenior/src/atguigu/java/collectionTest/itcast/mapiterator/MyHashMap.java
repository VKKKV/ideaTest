package atguigu.java.collectionTest.itcast.mapiterator;

import java.util.HashMap;

/**
 * Created on 2022/3/16星期三19:47
 *
 * @author abc
 *
 * 遍历hashmap
 *
 */
public class MyHashMap {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,2);
        map.put(1,3);//同key覆盖

        map.put("1","2");
        map.put('1','4');

        //通过key获取value
        for (Object o : map.keySet()) {
            System.out.println(map.get(o));
        }



    }
}
