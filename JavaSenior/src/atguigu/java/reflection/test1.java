package atguigu.java.reflection;

/**
 * Created on 2022/8/7星期日11:41
 *
 * @author abc
 */
public class test1 {

    //Class的实例化
    public static void main(String[] args) throws ClassNotFoundException {
        People people = new People();

        //1
        Class<People> p1 = People.class;
        System.out.println(p1);

        //2
        Class<? extends People> aClass = people.getClass();
        System.out.println(aClass);

        //3
        Class<?> c1 = Class.forName("atguigu.java.reflection.People");
        System.out.println(c1);


    }


}

class People {
    private int age;
    private String name;

    public People() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public People(int age) {
        this.age = age;
    }

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }
}