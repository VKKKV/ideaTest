package atguigu.dataStructures.java1;

import java.util.Scanner;

/**
 * Created on 2022/3/4星期五10:47.
 *
 * @author abc
 *
 * charAt(int index)
 *           返回指定索引处的 char 值。
 *
 *  int	indexOf(int ch)
 *           返回指定字符在此字符串中第一次出现处的索引。
 *
 *  int	indexOf(int ch, int fromIndex)
 *           返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
 *
 *  int	indexOf(String str)
 *           返回指定子字符串在此字符串中第一次出现处的索引。
 *
 *  int	indexOf(String str, int fromIndex)
 *           返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
 *
 *
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();

        int sumA = 0;
        int noABC = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'A' || s1.charAt(i) == 'a') {
                sumA++;

            } else if (s1.charAt(i) < 65 || (s1.charAt(i) > 90 && s1.charAt(i) < 97) || s1.charAt(i) > 122) {
                noABC++;
            }
        }
        System.out.println("字母A或a次数：" + sumA);

        System.out.println("非字母次数" + noABC);

    }

}