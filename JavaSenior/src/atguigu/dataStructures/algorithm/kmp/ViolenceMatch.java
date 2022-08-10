package atguigu.dataStructures.algorithm.kmp;

/**
 * Created on 2022/8/5星期五18:59
 *
 * @author abc
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";

        System.out.println(str1.substring(1, 3));
        int index = match(str1, str2);
        System.out.println("index=" + index);


    }

    public static int match(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;

        int i = 0;
        int j = 0;

        while (i < l1 && j < l2) {
            if (c1[i] == c2[j]) {
                i++;
                j++;

            } else {
                i = i - j + 1;
                j = 0;
            }

        }

        if (j == l2) {
            return i - j;
        }
        return -1;
    }


}
