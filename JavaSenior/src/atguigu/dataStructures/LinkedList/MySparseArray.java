package atguigu.dataStructures.LinkedList;

import java.io.*;

/**
 * Created on 2022/3/30星期三17:12
 *
 * @author abc
 */
public class MySparseArray {
    public static void main(String[] args) throws IOException {
        int[][] ints = new int[11][11];
        ints[1][2] = 1;
        ints[7][8] = 2;
        ints[2][7] = 1;
        ints[6][3] = 2;

        //输出原始数组
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (ints[i][j] != 0) {
                    count++;
                }
            }
        }


        //存入数组
        int[][] ints1 = new int[count + 1][3];
        ints1[0][0] = 11;
        ints1[0][1] = 11;
        ints1[0][2] = count;
        int sum = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (ints[i][j] != 0) {
                    ints1[sum][0] = i;
                    ints1[sum][1] = j;
                    ints1[sum][2] = ints[i][j];
                    sum++;
                }
            }
        }

        //文件路径会自动创建在工程下？？？？？？
//        output(ints1);

        input("map.data");


    }

    public static void output(int[][] map) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("map.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    public static void input(String str) {
        ObjectInputStream objectInputStream = null;
        int[][] intArr;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            objectInputStream = new ObjectInputStream(fileInputStream);
            intArr = (int[][]) objectInputStream.readObject();

            //读取
            for (int[] ints2 : intArr) {
                for (int i : ints2) {
                    System.out.print(i + "\t");
                }
                System.out.println();
            }

            int[][] ints2 = new int[intArr[0][0]][intArr[0][1]];
            for (int i = 1; i <= intArr[0][2]; i++) {
                ints2[intArr[i][0]][intArr[i][1]] = intArr[i][2];
            }

            for (int[] ints3 : ints2) {
                for (int i : ints3) {
                    System.out.print(i + "\t");
                }
                System.out.println();
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }
}


