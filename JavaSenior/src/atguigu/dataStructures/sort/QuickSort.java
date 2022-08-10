package atguigu.dataStructures.sort;

import java.util.Arrays;

/**
 * Created on 2022/7/25星期一17:17
 *
 * @author abc
 * 快速排序
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={-9,78,0,23,-567,70};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(l+r)/2];

        while (l<r) {
            while (arr[l]<pivot){
                ++l;
            }
            while (arr[r]>pivot){
                --r;
            }

            if(l>=r){
                break;
            }

            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;


            if (arr[l]==pivot){
                l++;
            }
            if (arr[r]==pivot){
                r--;
            }
        }
        if (l==r){
            ++l;
            --r;
        }
        if (left<r){
            quickSort(arr,left,r);
        }
        if (l<right){
            quickSort(arr,l,right);
        }

    }
}
