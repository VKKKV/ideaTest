package com.Study.java;

/**
 * Created on 2022/3/15星期二19:21.
 *
 * @author abc
 */
public class MyChar {
    public static void main(String[] args) {
        String str =null;
        char ch = 'B';
        ch= (char) (ch+1);
        str= String.valueOf(ch);
        System.out.println(str);
    }
}
