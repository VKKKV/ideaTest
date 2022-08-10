package atguigu.dataStructures.Stack;

import java.util.Stack;

/**
 * Created on 2022/4/26星期二11:16
 *
 * @author abc
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Object> objects = new Stack<>();
        int[] ints = new int[100];

        for (int i = 0; i < 100; i++) {
            ints[i] = i + 1;
        }

        for (int anInt : ints) {
            System.out.println(anInt);
            objects.add(anInt);
        }

        while (objects.size() > 0) {
            System.out.println(objects.pop());
        }


    }
}
