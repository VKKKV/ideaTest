package com.pta.problem;

import java.util.ArrayList;
import java.util.Scanner;

//https://blog.csdn.net/l870358133/article/details/102720770

class Person {
    String firstName;
    String sex;

    public Person(String firstName, String sex) {
        super();
        this.firstName = firstName;
        this.sex = sex;
    }
}

public class 冰岛人csdn {
    static int[] tree;
    static ArrayList<Integer> family = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<String> allName = new ArrayList<String>();
        Person[] per = new Person[N];
        tree = new int[N];    //家庭树，建立并查集
        sc.nextLine();
        //构建家庭树
        for (int i = 0; i < N; i++) {
            String Name = sc.nextLine();
            String[] name = Name.split(" ");
            //男后裔
            if (name[1].indexOf("sson") != -1) {
                name[1] = name[1].replace("sson", "");
                per[i] = new Person(name[0], "m");
            }
            //女后裔
            else if (name[1].indexOf("sdottir") != -1) {
                name[1] = name[1].replace("sdottir", "");
                per[i] = new Person(name[0], "f");
            }
            //男祖先
            else if (name[1].charAt(name[1].length() - 1) == 'm') {
                per[i] = new Person(name[0], "m");
            }
            //女祖先
            else if (name[1].charAt(name[1].length() - 1) == 'f') {
                per[i] = new Person(name[0], "f");
            }
            allName.add(name[0]);    //存储名字
            //根据其父亲是否存在建立并查集队列
            int index = allName.indexOf(name[1]);
            if (index == -1)
                tree[i] = i;
            else
                tree[i] = index;
        }
        //查询
        N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String Name = sc.nextLine();
            String[] name = Name.split(" ");
            int index1 = allName.indexOf(name[0]);
            int index2 = allName.indexOf(name[2]);
            if (index1 != -1 && index2 != -1) {
                if (per[index1].sex.equals(per[index2].sex)) {
                    System.out.println("Whatever");
                } else {
                    if (find(index1) != find(index2) || judge(index1, index2)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
            } else {
                System.out.println("NA");
            }
        }
    }

    //并查集查找
    public static int find(int i) {
        if (tree[i] != i) {
            return find(tree[i]);
        } else
            return i;
    }

    public static boolean judge(int index1, int index2) {
        int ret = 1;
        while (index1 != tree[index1] && index2 != tree[index2]) {
            index1 = tree[index1];
            index2 = tree[index2];
            ++ret;
            if (ret == 5) return true;    //不在五代以内
            if (index1 == index2) return false;    //五代以内存在共同祖先
        }
        return false;
    }
}