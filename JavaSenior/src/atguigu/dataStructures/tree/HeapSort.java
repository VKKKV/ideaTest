package atguigu.dataStructures.tree;

import java.util.Arrays;

/**
 * Created on 2022/7/28星期四16:22
 *
 * @author abc
 * 大顶堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);

    }
    public static void heapSort(int[] arr) {
        int temp;

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >0; i--) {
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;

            adjustHeap(arr,0, i);
        }

        System.out.println(Arrays.toString(arr));


    }
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //*修改后变小顶堆
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //*修改后变小顶堆
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else break;

            arr[i] = temp;
        }
    }
}
