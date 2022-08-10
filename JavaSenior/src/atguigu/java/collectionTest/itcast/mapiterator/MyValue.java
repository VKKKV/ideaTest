package atguigu.java.collectionTest.itcast.mapiterator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created on 2022/3/16星期三20:11
 *
 * @author abc
 *
 * 使用value方法迭代hashmap
 *
 *
 */
public class MyValue {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", "zhangy");
        map.put("2", "xiongwei");
        map.put("3", "wangxi");
        map.put("4", "wuhao");
        map.put("5", "zhangyi");
        map.put("6", "chucheng");
        map.put("7", "jiaxu");

        Collection<Object> values = map.values();

        Iterator<Object> iterator = values.iterator();

        //itcast:输出会无序。实测结果不符
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }


    }
}
