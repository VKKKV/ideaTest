package com.pta.problem;

import java.util.Scanner;

/**
 * Created on 2022/3/7星期一19:36.
 *
 * @author abc
 */
public class 输出全排列 {
    public static void permutation(char[] ss, int i) {
        if (ss == null || i < 0 || i > ss.length) {//1
            return;
        }
        if (i == ss.length - 1) {//2
            System.out.println(new String(ss));
        } else {
            for (int j = i; j < ss.length; j++) {//3
                char temp = ss[j];//交换前缀,使之产生下一个前缀
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);//4
                temp = ss[j]; //将前缀换回来,继续做上一个的前缀排列.//5
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int sb = scanner.nextInt();
        char[] ch = new char[sb];
        for (int i = 0; i < sb; i++) {
            ch[i] = (char) (49 + i);
        }
        permutation(ch, 0);
    }
}

