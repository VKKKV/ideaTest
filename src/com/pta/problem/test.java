package com.pta.problem;

import java.util.Scanner;

/**
 * Created on 2022/3/7星期一20:32.
 *
 * @author abc
 */
public class test {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=10;
        m=10+(n-1)*2;
        System.out.println("Number "+n+" is "+m+" age!");
    }
}
