package atguigu.dataStructures.tree;

/**
 * Created on 2022/7/27星期三14:55
 *
 * @author abc
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node1 = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(node1);


        binaryTree.preorder();

        binaryTree.delete(1);
        System.out.println();
        binaryTree.preorder();



    }


}

class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preorder() {
        if (this.root != null)
            this.root.preorder();
        else System.out.println("tree is empty");
    }

    public void inorder() {
        if (this.root != null)
            this.root.inorder();
        else System.out.println("tree is empty");

    }

    public void postorder() {
        if (this.root != null)
            this.root.postorder();
        else System.out.println("tree is empty");

    }

    public Node preorderSearch(int no) {
        return this.root.preorderSearch(no);
    }

    public Node inorderSearch(int no) {
        return this.root.inorderSearch(no);

    }

    public Node postorderSearch(int no) {
        return this.root.postorderSearch(no);
    }

    public void delete(int no) {
        if (root == null) {
            System.out.println("binaryTree is empty");
            return;
        } else if (root.getNo() == no) {
            root = null;
            return;
        }
        root.delete(no);
    }


}

class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void delete(int no) {
        Node temp = this;

        if (temp.getLeft() != null) {
            if (temp.getLeft().getNo() == no) {
                temp.setLeft(null);
                return;
            }
            temp.getLeft().delete(no);
        }
        if (temp.getRight() != null) {
            if (temp.getRight().getNo() == no) {
                temp.setRight(null);
                return;
            }
            temp.getRight().delete(no);
        }
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历

    public void preorder() {

        System.out.println(this);

        if (this.getLeft() != null) {
            this.getLeft().preorder();
        }
        if (this.getRight() != null) {
            this.getRight().preorder();
        }


    }
    //中序遍历

    public void inorder() {

        if (this.getLeft() != null) {
            this.getLeft().inorder();
        }

        System.out.println(this);

        if (this.getRight() != null) {
            this.getRight().inorder();
        }
    }
    //后序遍历

    public void postorder() {

        if (this.getLeft() != null) {
            this.getLeft().postorder();
        }

        if (this.getRight() != null) {
            this.getRight().postorder();
        }

        System.out.println(this);

    }

    public Node preorderSearch(int no) {
        Node res = null;

        if (this.no == no) {
            return this;
        }
        if (this.getLeft() != null) {
            res = this.getLeft().preorderSearch(no);
        }
        if (res != null) {
            return res;
        }

        if (this.getRight() != null) {
            res = this.getRight().preorderSearch(no);
        }

        return res;
    }

    public Node inorderSearch(int no) {
        Node res = null;

        if (this.getLeft() != null) {
            res = this.getLeft().inorderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.no == no) {
            return this;
        }
        if (this.getRight() != null) {
            res = this.getRight().inorderSearch(no);
        }

        return res;
    }

    public Node postorderSearch(int no) {
        Node res = null;

        if (this.getLeft() != null) {
            res = this.getLeft().postorderSearch(no);
        }
        if (res != null) {
            return res;
        }
        if (this.getRight() != null) {
            res = this.getRight().postorderSearch(no);
        }

        if (this.no == no) {
            return this;
        }
        return res;
    }
}



