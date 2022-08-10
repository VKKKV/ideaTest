package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/8星期五16:04
 *
 * @author abc
 *
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={5,1,4,2};
        insert(arr);


    }

    private static void insert(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertVal=arr[i];
            insertIndex=i-1;

            while (insertIndex>=0&&arr[insertIndex]>insertVal){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;

            }
            if (insertIndex+1==i){
                break;
            }
            arr[insertIndex+1]=insertVal;

            System.out.println("第"+i+"次排序："+ Arrays.toString(arr));
        }

    }
}
