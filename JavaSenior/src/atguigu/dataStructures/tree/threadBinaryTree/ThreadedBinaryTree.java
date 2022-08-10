package atguigu.dataStructures.tree.threadBinaryTree;

/**
 * Created on 2022/7/28星期四13:53
 *
 * @author abc
 * <p>
 * 线索化二叉树
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node10 = new Node(10);
        Node node14 = new Node(14);

        node1.setLeft(node3);
        node3.setLeft(node8);
        node3.setRight(node10);
        node1.setRight(node6);
        node6.setLeft(node14);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(node1);

        binaryTree.threadedNode();

        binaryTree.threadedList();


    }

}

class BinaryTree {
    private Node root;
    private Node pre;


    public void threadedList() {
        boolean flag = false;

        if (root == null) {
            System.out.println("tree is empty");
            return;
        }

        Node temp = root;

        while (temp != null) {

            while (temp != null && temp.getLeftType() == 0) {
                temp = temp.getLeft();
            }
            if (temp == null) {
                flag = true;
                break;
            }


            System.out.println(temp);
            while (temp.getRightType() == 1) {
                temp = temp.getRight();
                System.out.println(temp);
            }

            temp = temp.getRight();

        }

        if (flag) {
            System.out.println("tree is not threaded");
        }
    }


    public void threadedNode() {
        this.threadedNode(root);
    }


    //中序线索化
    public void threadedNode(Node node) {
        if (node == null) {
            return;
        }

        threadedNode(node.getLeft());
        if (node.getLeft() == null) {

            node.setLeft(pre);
            node.setLeftType(1);

        }
        if (pre != null && pre.getRight() == null) {

            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        threadedNode(node.getRight());
    }


    public void setRoot(Node root) {
        this.root = root;
    }


}

class Node {
    private final int no;
    private Node left;
    private Node right;

    //1. 如果 leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    // 2. 如果 rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点

    private int leftType;
    private int rightType;


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node(int no) {
        this.no = no;
    }


    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }


}