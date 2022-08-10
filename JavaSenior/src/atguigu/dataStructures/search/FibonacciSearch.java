package atguigu.dataStructures.search;

/**
 * Created on 2022/7/26星期二21:58
 *
 * @author abc
 */
public class FibonacciSearch {


    public static int MaxSize = 20;


    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int target = 1234;

        int[] fib = fib();
        int k = initK( fib,arr);
        int[] arr2 = initArr2(fib,k, arr);

        int res = fibonacci(k, arr2, fib(), 0, arr.length - 1, target);

        if (res>=arr.length){
            System.out.println(arr.length-1);
        }
        else if (res == -1) {
            System.out.println("target not found");
        } else {
            System.out.println(res);
        }

    }

    private static int fibonacci(int k, int[] arr, int[] fib, int left, int right, int target) {

        int mid = left + fib[k - 1] - 1;
        if (arr[mid] == target) {
            return mid;
        }

        if (left <= right) {
            if (arr[mid] < target) {
                return fibonacci(k-1,arr,fib, mid + 1, right, target);

            } else
                return fibonacci(k-2,arr,fib,left, mid - 1, target);
        }

        return -1;
    }

    public static int initK(int[] fib, int[] arr) {
        int k = 0;
        for (int i = 0; i < fib.length; i++) {
            if (fib[i] >= arr.length) {
                k = i;

                break;
            }
        }
        return k;
    }

    public static int[] initArr2(int[] fib,int k, int[] arr) {
        int[] arr2;

        arr2 = new int[fib[k]];
        for (int j = 0; j < arr2.length; j++) {
            if (j < arr.length) {
                arr2[j] = arr[j];
            } else {
                arr2[j] = arr[arr.length - 1];
            }
        }

        return arr2;
    }


    public static int[] fib() {
        int[] f = new int[MaxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < MaxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
