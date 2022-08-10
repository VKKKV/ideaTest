package atguigu.java.collectionTest.itcast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * version .1
 * 输入bug*未修改
 *
 * Created on 2022/3/15星期二21:40
 *
 * @author abc
 */
public class LinkedListTest {


    //可使用arraylist类实现，只需修改形参列表与部分方法，arraylist中的指定add可以替代addfirstlast---
    //但是arraylist查询快增删效率低，并不适合

    static LinkedList<String> linkedList = new LinkedList<>();
    static String str = "";
    static int abc = 0;

    public static void main(String[] args) {

        boolean isflag = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------欢迎来到点歌系统----------------");
        addMenuMusic(linkedList);

        do {
            System.out.println("0.添加歌曲至列表");
            System.out.println("1.将歌曲置顶");
            System.out.println("2.将歌曲前移一位");
            System.out.println("3.退出");


            System.out.print("初始歌曲列表：");
            System.out.println(Arrays.toString(linkedList.toArray()));
            System.out.print("请输入要执行的操作序号:");

            abc = scanner.nextInt();
            switch (abc) {
                case 0:
                    System.out.print("请输入要添加的歌曲名称：");
                    addMusic(linkedList);
                    break;
                case 1:
                    System.out.print("请输入要置顶的歌曲名称：");

                    putFirst(linkedList);
                    break;
                case 2:
                    System.out.print("请输入要置前的歌曲名称：");

                    forward(linkedList);
                    break;
                case 3:
                    System.out.println("--------退出--------");
                    isflag = false;
                    break;
                default:
                    System.out.println("------------------");
                    System.out.println("error");
            }
            System.out.println("-------------------------");
        } while (isflag);

        System.out.println("您已退出系统");
    }

    private static void forward(LinkedList<String> linkedList) {
        str = new Scanner(System.in).nextLine();
        String temp;
        abc = linkedList.indexOf(str) - 1;//前一首歌的角标
        temp = String.valueOf(linkedList.get(abc));//暂存前一首歌
        linkedList.remove(abc);
        linkedList.add(abc, str);
        linkedList.remove(abc + 1);
        linkedList.add(abc + 1, temp);

//        System.out.println("temp"+temp);
    }

    private static void putFirst(LinkedList<String> linkedList) {
        str = new Scanner(System.in).nextLine();
        linkedList.removeLast();
        linkedList.addFirst(str);
    }

    private static void addMusic(LinkedList<String> linkedList) {
        str = new Scanner(System.in).nextLine();
        linkedList.add(str);
    }

    private static void addMenuMusic(LinkedList<String> linkedList) {
        linkedList.add("半岛铁盒");
        linkedList.add("花海");
        linkedList.add("反方向的钟");
        linkedList.add("发如雪");
        linkedList.add("晴天");
    }

}