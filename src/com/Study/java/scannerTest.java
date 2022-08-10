package com.Study.java;

import java.util.Scanner;

/**
 * Created on 2022/3/6星期日15:05.
 *
 * @author abc
 *
 * next（）
 *
 * 一定要读取到有效的字符后才可以结束输入
 *  对输入有效字符之前的遇到的空白，next（）方法会自动将其去掉
 * 只有输入有效字符之后才将其后面输入的空白作为分隔符或者结束符
 * next（）不能得到带有空格的字符串
 *
 * nextline（）
 *
 * 以enter为结束符，返回回车之前的所有字符
 * 可以有空格
 *
 * next方法不能录入空格，在特定情况下会把空格当作回车，nextLine方法可以识录入空格
 * hasNext和hasNextLine的返回值都是boolean类型，但只有可能返回true，不可能返回false，并且都默认以回车键为结束（hasNext可以设置为任意符号为结束键，不在本文研究范围之内）
 * hasNext、next不能直接识别裸回车，而hasNextLine和nextLine都可以直接识别裸回车。换句话讲：对于不输入符号而直接裸敲一个回车的操作，只有后两个能识别
 * hasNext、hasNextLine在返回一个boolean类型结果true的同时，会在堆空间中开辟一块专门用于存放刚刚输入的字符串，用于下次next或者nextLine：即下次next或者nextLine不需要再从键盘输入，相当于系统自动把刚刚输入的字符串再原封不动的输入了一遍。同时这个存储寿命＝调用对象的寿命
 * 对于hasNext来说，每次敲击回车都相当于在堆空间中开辟一行，敲几次回车就会直接给后续next、nextLine方法赋值几次
 * hasNext是线程阻塞的，对于hasNext来说，如果一直不输入字符，反而一直敲回车的话，整个线程会卡在这个输入的地方，直到有字符输入
 *
 *
 */
public class scannerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalExpense=0;
        do {
            System.out.println("请选择商品");
            do {
                int drinks = scanner.nextInt();
                if (drinks != -1) {
                    totalExpense++;;
                } else break;
            } while (true);

            System.out.println("确认商品选择完毕(y/n)");
            String confirm = scanner.next();
            if (confirm.toLowerCase().equals("y")) {
                break;
            }
        } while (true);
        System.out.println("final");







    }
}
