package atguigu.dataStructures.tree.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created on 2022/7/30星期六16:58
 *
 * @author abc
 * <p>
 *
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node node = create(arr);
        node.preorder();
    }

    //构造哈夫曼树
    public static Node create(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            Node parent = new Node(left.value, right.value);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public void preorder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preorder();
        }
        if (this.right != null) {
            this.right.preorder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, int value2) {
        this.value = value + value2;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
