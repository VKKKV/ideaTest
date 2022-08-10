package atguigu.dataStructures.search;

/**
 * Created on 2022/7/26星期二18:50
 *
 * @author abc
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int target = 11;


        int res = seq(arr, target);
        if (res != -1)
            System.out.println(res);
        else System.out.println("target not found");
    }

    private static int seq(int[] arr, int target) {
        int res;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                res = i;
                return res;
            }
        }
        return -1;
    }


}
