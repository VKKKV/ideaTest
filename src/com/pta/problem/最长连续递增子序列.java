package com.pta.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 最长连续递增子序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sr.readLine());
        int[] res=new int[n];
        String s[] = sr.readLine().split(" ");
        for(int i=0;i<n;i++)
            res[i]=Integer.parseInt(s[i]);
        int max=0,count=0,ss=0,x=0,y=0;
        for(int i=0;i<n-1;i++) {
            y=i+1;
            if(res[i+1]>res[i]) {
                count++;
                if(count>max) {
                    max=count;
                    ss=x;
                }
            }else {
                count=0;
                x=y;
            }
        }
        for(int i=ss;i<=ss+max;i++) {
            if(i==(ss+max)) {
                System.out.print(res[i]);
            }else {
                System.out.print(res[i]+" ");
            }
        }
    }
}