package atguigu.dataStructures.LinkedList;

/**
 * Created on 2022/2/28星期一23:10.
 *
 * @author abc
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

//row行col列sum数据

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArrays = new int[sum + 1][3];

        sparseArrays[0][0] = 11;
        sparseArrays[0][1] = 11;
        sparseArrays[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArrays[count][0] = i;
                    sparseArrays[count][1] = j;
                    sparseArrays[count][2] = chessArr1[i][j];
                }
            }
        }
        for (int[] sparseArray : sparseArrays) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sparseArray[j] + "\t");
            }
            System.out.println();
        }


        int[][] chessArr2 = new int[sparseArrays[0][0]][sparseArrays[0][1]];
        for (int i = 1; i < sparseArrays.length; i++) {
            chessArr2[sparseArrays[i][0]][sparseArrays[i][1]] = sparseArrays[i][2];
        }
        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }


    }
}
