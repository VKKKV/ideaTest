package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/8星期五15:33
 *
 * @author abc
 *
 * 选择排序
 * 时间复杂度O(n^2)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1};

        select(arr);


    }

    private static void select(int[] arr) {
        int min;
        int minIndex=0;
        for (int i = 0; i < arr.length-1; i++) {
            boolean flag=true;
            min=arr[i];
            for (int j = i; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    minIndex=j;

                    flag=false;
                }
            }

            if (flag){
                break;
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println("第"+(i+1)+"次排序："+ Arrays.toString(arr));
        }
    }
}
