package atguigu.java.collectionTest.exer;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created on 2022/3/28星期一19:31
 *
 * @author abc
 * <p>
 * 把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字
 * TreeSet(Student(name,score,id));
 * <p>
 */
public class exer2 {
    public static void main(String[] args) {
        student student1 = new student("zhang", 99, "001");
        student student2 = new student("yang", 98, "002");
        student student3 = new student("zhang1", 98, "003");
        student student4 = new student("zhang3", 97, "004");

        TreeSet<student> objects = new TreeSet<>();
        objects.add(student1);
        objects.add(student2);
        objects.add(student3);
        objects.add(student4);

        Iterator<student> iterator = objects.iterator();
        for (int i = 0; i < 3; i++) {
            System.out.println(iterator.next());
        }


    }
}

class student implements Comparable {
    private String name;
    private int score;
    private String id;

    public student() {
    }

    public student(String name, int score, String id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof student student) {
            int i = -(this.score - student.getScore());
            if (i == 0) {
                return this.id.compareTo(student.id);
            } else return i;

        }
        return 0;
    }
}
