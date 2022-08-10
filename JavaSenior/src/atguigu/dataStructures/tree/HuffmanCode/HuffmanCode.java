package atguigu.dataStructures.tree.HuffmanCode;

import java.io.*;
import java.util.*;

/**
 * Created on 2022/7/30星期六17:55
 *
 * @author abc
 * <p>
 * <p>
 * 哈夫曼编码实现文件解压缩
 */
public class HuffmanCode {


    public static void main(String[] args) {
//        String str = "i need you";
//
//        //字符串对应的byte数组
//        byte[] bytes = str.getBytes();
//
//        byte[] bytes1 = huffmanZip(bytes);
//        System.out.println(Arrays.toString(bytes1));
//        byte[] bytes2 = decode(huffmanCodes, bytes1);
//
//        System.out.println(new String(bytes2));

//        zipFile("car.jpg", "car.zip");
        unzipFile("car.zip", "car2.jpg");

    }

    /**
     * 文件解压
     *
     * @param src 源文件路径
     * @param dst 目标路径
     */
    public static void unzipFile(String src, String dst) {
        FileInputStream is = null;
        ObjectInputStream ois = null;
        FileOutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dst);
            ois = new ObjectInputStream(is);


            byte[] bytes = (byte[]) ois.readObject();

            Map<Byte, String> map = (Map<Byte, String>) ois.readObject();
            byte[] bytes1 = decode(map, bytes);

            os.write(bytes1);


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 文件压缩
     *
     * @param src 源文件路径
     * @param dst 目标路径
     */
    public static void zipFile(String src, String dst) {

        FileInputStream is = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dst);
            byte[] bytes = new byte[is.available()];


            byte[] huffmanZip = huffmanZip(bytes);

//            os.write(huffmanZip);

            oos = new ObjectOutputStream(os);
            oos.writeObject(huffmanZip);
            oos.writeObject(huffmanCodes);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (os != null) {
                    os.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }


    }


    /**
     * @param map   huffman编码表
     * @param bytes 二进制编码
     * @return ascii码
     */
    public static byte[] decode(Map<Byte, String> map, byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(byteToBitString(i != bytes.length - 1, bytes[i]));
        }


        HashMap<String, Byte> map1 = new HashMap<>();

        for (Map.Entry<Byte, String> entry : map.entrySet()) {
            map1.put(entry.getValue(), entry.getKey());
        }

        ArrayList<Byte> list = new ArrayList<>();

        Byte b;
        String str = "";

        for (int i = 0; i < stringBuilder.length(); i++) {
            str += stringBuilder.charAt(i);
            b = map1.get(str);
            if (b != null) {
                list.add(b);
                str = "";
            }
        }

        byte[] bytes1 = new byte[list.size()];

        for (int i = 0; i < list.size(); i++) {
            bytes1[i] = list.get(i);
        }


        return bytes1;
    }


    /**
     * @param flag 表示是否补位
     * @param b    传入huffmanZip
     * @return 二进制字符串
     */
    private static String byteToBitString(boolean flag, byte b) {
        int i = b;

        if (flag) {
            i |= 256;
        }

        String str = Integer.toBinaryString(i);

        if (!flag) {
            return str;
        }
        return str.substring(str.length() - 8);

    }


    public static byte[] huffmanZip(byte[] bytes) {

        List<Node> list = getNodes(bytes);
        Node node = create(list);


        return zip(bytes, getCodes(node));
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> map) {

        StringBuilder stringBuilder = new StringBuilder();


        for (byte aByte : bytes) {
            stringBuilder.append(map.get(aByte));
        }


        int len = (stringBuilder.length() + 7) / 8;


        byte[] bytes1 = new byte[len];
        int count = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {

            String str;

            if (i + 8 <= stringBuilder.length()) {
                str = stringBuilder.substring(i, i + 8);
            } else {
                str = stringBuilder.substring(i);

            }
            bytes1[count++] = (byte) Integer.parseInt(str, 2);
        }

        return bytes1;
    }


    static Map<Byte, String> huffmanCodes = new HashMap<>();


    //返回哈夫曼编码表
    private static Map<Byte, String> getCodes(Node node) {
        if (node != null) {
            getCodes(node, "", new StringBuilder());
            return huffmanCodes;
        }
        return null;
    }

    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);

        if (node.data == null) {
            getCodes(node.left, "0", stringBuilder2);
            getCodes(node.right, "1", stringBuilder2);
        } else {
            huffmanCodes.put(node.data, stringBuilder2.toString());

        }
    }


    public static Node create(List<Node> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }


    public static List<Node> getNodes(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();

        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = counts.get(aByte);
            if (count == null) {
                counts.put(aByte, 1);
            } else {

                counts.put(aByte, ++count);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }


        return nodes;


    }
}

class Node implements Comparable<Node> {
    int weight;
    Byte data;
    Node left;
    Node right;


    public Node(Byte data, int weight) {
        this.weight = weight;
        this.data = data;

    }


    @Override
    public String toString() {
        return "Node1{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
