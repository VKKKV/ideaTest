package atguigu.java.collectionTest.itcast.mapiterator;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created on 2022/3/16星期三20:46
 *
 * @author abc
 */
public class MyLinkedHashMap {
    public static void main(String[] args) {
        Map<Object, Object> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        for (Object o : map.keySet()) {
            System.out.println(o);
        }


    }
}
