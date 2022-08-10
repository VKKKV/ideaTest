package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/26星期二16:39
 *
 * @author abc
 * <p>
 * 基数排序
 * <p>
 * 负数适用？
 * https://blog.csdn.net/qq_62940063/article/details/123369263
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    private static void radixSort(int[] arr) {
        int[][] bucket;
        int[] count;
        int count2;

        //max number
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);

        //digit
//        int count3=0;
//        while(max > 0){
//            max=max / 10;
//            count3++;
//        }

        //max, int to string
        int count3 = (max + "").length();
        System.out.println(count3);


        for (int k = 0; k < count3; k++) {
            count2 = 0;
            count = new int[10];
            bucket = new int[10][arr.length];
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / num(k) % 10;
                bucket[digit][count[digit]++] = arr[i];
            }
            for (int i = 0; i < 10; i++) {
                if (count[i] != 0) {
                    for (int j = 0; j < count[i]; j++) {
                        arr[count2++] = bucket[i][j];

                    }
                }
            }
        }

    }

    private static int num(int k) {
        int num = 1;
        for (int i = 0; i < k; i++) {
            num *= 10;

        }
        return num;
    }
}
