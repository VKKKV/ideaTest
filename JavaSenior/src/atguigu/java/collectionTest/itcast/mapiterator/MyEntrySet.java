package atguigu.java.collectionTest.itcast.mapiterator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/3/16星期三20:02
 *
 * @author abc
 *
 * 使用map.entry嵌套类迭代map
 *
 */
public class MyEntrySet {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        for (Map.Entry<Object, Object> objectObjectEntry : map.entrySet()) {
            //获取键与值
            System.out.println(objectObjectEntry.getKey()+ ":"+objectObjectEntry.getValue());
            //
            System.out.println(objectObjectEntry.getValue());
        }


    }
}
