package atguigu.dataStructures.algorithm.dynamic;

import java.util.Arrays;

/**
 * Created on 2022/8/5星期五18:16
 *
 * @author abc
 * 背包问题
 *
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值
        int m = 4; //背包的容量
        int n = val.length; //物品的个数
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);

                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }


        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }


        for (int[] ints : path) {
            System.out.println(Arrays.toString(ints));
        }


        for (int i = path.length-1; i >0 ; ) {
            for (int j = path[0].length-1; j >0 ; ) {
                if (path[i][j]==1){
                    System.out.println(i);
                    j-=w[i-1];
                }
                i--;
            }
        }


    }


}
