package atguigu.dataStructures.algorithm.divideAndConquer;

/**
 * Created on 2022/8/5星期五15:14
 *
 * @author abc
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoi(5, 'a', 'b', 'c');
    }
    private static void hanoi(int i, char a, char b, char c) {
        if (i == 1) {
            System.out.println(i + " " + a + " to " + c);
        } else {
            hanoi(i - 1, a, c, b);
            System.out.println(i + " " + a + " to " + c);
            hanoi(i - 1, b, a, c);
        }
    }
}