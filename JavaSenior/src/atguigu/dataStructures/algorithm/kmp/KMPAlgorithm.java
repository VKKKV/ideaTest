package atguigu.dataStructures.algorithm.kmp;

/**
 * Created on 2022/8/5星期五20:10
 *
 * @author abc
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        //部分匹配值
        int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]


        int res=kmpSearch(str1,str2,next);
        System.out.println(res);
    }

    /**
     * @param str1 src
     * @param str2 target
     * @param next sub match
     * @return index
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0,j=0; i <str1.length(); i++) {
            //匹配最长前后缀
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    private static int[] kmpNext(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < str.length(); i++) {

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = next[j - 1];

            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            next[i] = j;

        }
        return next;
    }
}
