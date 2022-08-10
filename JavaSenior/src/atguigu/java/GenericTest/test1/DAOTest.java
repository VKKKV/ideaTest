package atguigu.java.GenericTest.test1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created on 2022/3/29星期二11:10
 *
 * @author abc
 */
public class DAOTest {


    @Test
    public void test2(){
        DAO<User> objectDAO = new DAO<>(new HashMap<>());
        objectDAO.save("001",new User(1,12,"yi"));
        objectDAO.save("002",new User(2,35,"er"));
        objectDAO.save("003",new User(3,23,"san"));
        objectDAO.save("004",new User(4,59,"si"));
        User user = objectDAO.get("001");

        System.out.println(user);

        objectDAO.update("004", new User(5,87,"huo"));
        List<User> list = objectDAO.list();
//        for (User o1 : list) {
//            System.out.println(o1);
//        }
        list.forEach(System.out::println);
        objectDAO.delete("001");


    }
















    @Test
    public void test1 (){
        DAO<String> objectDAO = new DAO<>(new HashMap<>());
        objectDAO.save("001", "save");
        Object o = objectDAO.get("001");
        System.out.println(o);
        objectDAO.update("001", "update");
        List<String> list = objectDAO.list();
        for (String o1 : list) {
            System.out.println(o1);
        }
        objectDAO.delete("001");
    }
}
