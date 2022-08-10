package atguigu.java.collectionTest.test1;

/**
 * Created on 2022/3/28星期一10:45
 *
 * @author abc
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }


    // 利用泛型可以省略instanceof
//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Employee){
//            Employee e=(Employee)o;
//            return this.name.compareTo(e.name);
//        }
//        //else throw new RuntimeException("数据类型错误");
//        return 0;
//    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
