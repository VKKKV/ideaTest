package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/7星期四17:03
 *
 * @author abc
 *
 * 冒泡排序
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr ={3,9,-3,10,-2};
        bubbleSort(arr);

    }


    public static void bubbleSort(int[] arr){
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag=false;
            for (int j = 0; j <arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            if (!flag){
                break;
            }

            System.out.println("第"+(i+1)+"次排序："+ Arrays.toString(arr));
        }
    }
}
