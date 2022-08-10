package atguigu.java.GenericTest.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created on 2022/3/29星期二10:59
 *
 * @author abc
 */
public class DAO<T> {
    private Map<String,T> map;

    public DAO(Map<String, T> map) {
        this.map = map;
    }

    public void save(String id,T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        map.replace(id,entity);
    }

    public List<T> list(){

        return new ArrayList<>(map.values());
    }

    public void delete(String id){
        map.remove(id);
    }


}
