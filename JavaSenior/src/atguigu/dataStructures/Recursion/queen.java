package atguigu.dataStructures.Recursion;

/**
 * Created on 2022/7/4星期一21:26
 *
 * @author abc
 * <p>
 * 八皇后问题
 */
public class queen {

    int max = 8;
    int[] arr = new int[max];

    int count;

    public static void main(String[] args) {

        queen queen = new queen();
        queen.check(0);

        System.out.println(queen.count);
    }

    public void check(int n) {
        if (n == max) {
            print();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }

    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;

    }


    public void print() {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }


}
