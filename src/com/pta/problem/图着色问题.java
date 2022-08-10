package com.pta.problem;

import java.util.Scanner;

/**
 * Created on 2022/2/22.
 *
 * @author abc
 */
public class 图着色问题 {

    private static void readKeyboard() {
        Scanner reader = new Scanner(System.in);
        int V = reader.nextInt();
        int E = reader.nextInt();
        int K = reader.nextInt();
        int[] arrV = new int[V];
        int[] arrK = new int[K];
        int[] arrE1 = new int[E];
        int[] arrE2 = new int[E];

        for (int i = 0; i < arrE1.length; i++) {
            arrE1[i] = reader.nextInt();
            arrE2[i] = reader.nextInt();
        }

        int N = reader.nextInt();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < arrV.length; j++) {
                arrV[i] = reader.nextInt();
            }

            if (isFlag(arrV)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    private static boolean isFlag(int[] arr) {
        return true;
    }

    public static void main(String[] args) {
        readKeyboard();
    }


}
