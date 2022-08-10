package com.Test.exe;

public class 随机吃饭 {
    public static void main(String[] args) {
        int a = (int) (0 + Math.random() * (1 + 1));
        System.out.println(a);
        if (a == 1) {
            System.out.println("KFC");
        } else {
            System.out.println("McDonald");
        }
    }
}
