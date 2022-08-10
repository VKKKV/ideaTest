package atguigu.dataStructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2022/7/26星期二21:31
 *
 * @author abc
 * <p>
 * 插值查找
 *
 * 仅适用有序数组
 *
 * int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])
 *
 * 对于数据量较大，关键字分部比较均匀的查找表来说，速度较快。关键字分部不均匀的情况下，
 * 该方法不一定比折半（二分查找好）
 *
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int target = 1000;

        List<Integer> list = insertValue(arr, 0, arr.length - 1, target);
        if (!list.isEmpty())
            System.out.printf(String.valueOf(list));
        else
            System.out.println("target not found");


    }

    //可以查找到全部目标角标
    private static ArrayList<Integer> insertValue(int[] arr, int left, int right, int target) {
        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
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
                return insertValue(arr, mid + 1, right, target);

            } else
                return insertValue(arr, left, mid - 1, target);
        }

        return new ArrayList<>();
    }


}
