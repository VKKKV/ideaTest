package com.pta.problem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays.sort()对字符串排序？？？？？？？？？？？？
 *
 *         String[] a ={"11-3","11-2","10-5","10-2"};
 *         Arrays.sort(a);
 *         for (int i = 0; i < a.length; i++) {
 *             System.out.println(a[i]);
 *         }
 *
 * 10-2
 * 10-5
 * 11-2
 * 11-3
 *
 * 进程已结束,退出代码0
 *
 */


public class 身份证排序 {

    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int n;
        n=sc.nextInt();
        String s[]=new String[n];
        String birth[]=new String[n];

        String str;
        for(int i=0;i<n;i++) {
            s[i]=sc.next();
        }
        while(true) {
            str=sc.next();
            if(str.equals("e")) {
                System.out.println("exit");
                break;
            }else if(str.equals("sort1")) {
                for(int i=0;i<n;i++) {
                    birth[i]=s[i].substring(6,10 )+'-'+	s[i].substring(10, 12)+'-'+s[i].substring(12, 14);

                }
                Arrays.sort(birth);
                for(int i=0;i<n;i++) {
                    System.out.println(birth[i]);
                }

            }else if(str.equals("sort2")) {
                for(int i=0;i<n;i++) {
                    birth[i]=s[i].substring(6,10 )+	s[i].substring(10, 12)+s[i].substring(12, 14);

                }
                Arrays.sort(birth);
                for(int i=0;i<n;i++) {
                    for(int j=0;j<n;j++){
                        if(s[j].contains(birth[i])) {
                            System.out.println(s[j]);
                            break;
                        }
                    }
                }
            }
        }
    }

}