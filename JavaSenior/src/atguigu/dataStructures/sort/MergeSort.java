package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/25星期一20:09
 *
 * @author abc
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        divide(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));

    }

    private static void divide(int[] arr, int left, int right, int[] temp) {
        int mid = ( left+right)  / 2;
        if (left != right) {
            divide(arr, left, mid, temp);
            divide(arr, mid + 1, right, temp);
        }
        conquer(arr, left, mid, right, temp);
    }

    private static void conquer(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[count++] = arr[i++];

            } else {
                temp[count++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[count++] = arr[i++];

        }
        while (j <= right) {
            temp[count++] = arr[j++];

        }
        count = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = temp[count++];
        }
    }


}
