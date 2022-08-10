package atguigu.dataStructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2022/7/26星期二19:08
 *
 * @author abc
 * <p>
 * 二分查找/折半查找
 * <p>
 * 仅适用有序数组
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int target = 1000;

        int res = binary(arr, 0, arr.length - 1, target);
        if (res == -1) {
            System.out.println("target not found");
        } else {
            System.out.println(res);
        }


        List<Integer> list = binaryPlus(arr, 0, arr.length - 1, target);
        if (!list.isEmpty())
            System.out.printf(String.valueOf(list));
        else
            System.out.println("target not found");


    }

    private static int binary(int[] arr, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (left <= right) {
            if (arr[mid] < target) {
                return binary(arr, mid + 1, right, target);

            } else
                return binary(arr, left, mid - 1, target);
        }

        return -1;
    }

    //可以查找到全部目标角标
    private static ArrayList<Integer> binaryPlus(int[] arr, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (arr[mid] == target) {
            ArrayList<Integer> list = new ArrayList<>();

            int temp = mid;
            while (arr[--temp] == target) {
                list.add(temp);
            }

            temp = mid;
            while (arr[++temp] == target) {
                list.add(temp);
            }
            list.add(mid);

            return list;

        }

        if (left <= right) {
            if (arr[mid] < target) {
                return binaryPlus(arr, mid + 1, right, target);

            } else
                return binaryPlus(arr, left, mid - 1, target);
        }

        return new ArrayList<>();
    }
}
