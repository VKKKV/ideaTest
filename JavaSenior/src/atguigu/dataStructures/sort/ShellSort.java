package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/8星期五16:47
 *
 * @author abc
 *
 * 希尔排序
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序，随着增量逐渐减少
 * 每组包含的关键词原来越多，当增量减至1时，整个文件被分成一组，算法便终止
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={8,9,1,7,2,3,4,6,0};
//        shell(arr);

        shellPlus(arr);

    }

    //移位法
    private static void shellPlus(int[] arr) {
        int count=1;
        int temp;
        int j;
        for (int gap = arr.length/2; gap >0; gap/=2) {

            for (int i = gap; i < arr.length; i++) {
                j=i;
                temp=arr[j];

                if(arr[j]<arr[j-gap]) {
                    while (j-gap >= 0 && arr[j-gap] > temp) {
                        arr[j] = arr[j-gap];
                        //
                        j-=gap;
                    }
                }
                arr[j]=temp;
            }
            System.out.println("第"+(count++)+"次排序："+ Arrays.toString(arr));
        }
    }


    //交换法
    private static void shell(int[] arr) {
        int temp;
        int count=1;
        //步长（间隔）
        for (int gap = arr.length/2; gap >0; gap/=2) {
            //分组
            for (int i = gap; i < arr.length; i++) {
                //多组排序同时进行
                for (int j = i-gap; j >=0; j-=gap) {

                    if (arr[j]>arr[j+gap]){

                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }
            //计数

            System.out.println("第"+(count++)+"次排序："+ Arrays.toString(arr));
        }
    }
}
