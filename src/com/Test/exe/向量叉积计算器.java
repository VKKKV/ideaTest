package com.Test.exe;

import java.util.Scanner;

/**
 * Created on 2022/3/12星期六9:38.
 *
 * @author abc
 */
public class 向量叉积计算器 {
    public static void main(String[] args) {
        int[] first=new int[3];
        int[] second=new int[3];
        int[] answer=new int[3];


        Scanner scanner=new Scanner(System.in);;

        while (true) {

            System.out.print("enter the first array:");
            for (int i = 0; i < 3; i++) {
                first[i] = scanner.nextInt();
            }

            System.out.print("enter the second array:");
            for (int i = 0; i < 3; i++) {
                second[i] = scanner.nextInt();
            }

            System.out.print("answer:");
            answer[0] = first[1] * second[2] - first[2] * second[1];
            answer[1] = -(first[0] * second[2] - first[2] * second[0]);
            answer[2] = first[0] * second[1] - first[1] * second[0];

            System.out.print(answer[0] + " ");
            System.out.print(answer[1] + " ");
            System.out.print(answer[2] + " ");
            System.out.println();
        }

    }
}
