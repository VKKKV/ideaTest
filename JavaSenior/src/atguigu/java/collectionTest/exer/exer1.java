package atguigu.java.collectionTest.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created on 2022/3/28星期一19:27
 *
 * @author abc
 *
 * 从键盘随机输入十个整数保存到list中，并按倒序、从大到小的顺序显示出来
 *
 *
 */
public class exer1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入十个整数：");
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);
        Collections.reverse(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }



    }

}
