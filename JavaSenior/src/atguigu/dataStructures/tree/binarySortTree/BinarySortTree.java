package atguigu.dataStructures.tree.binarySortTree;

/**
 * Created on 2022/7/31星期日13:23
 *
 * @author abc
 * BST
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] ints = {7, 3, 10, 12, 5, 1, 9};

        BinaryTree binaryTree = new BinaryTree();
        for (int anInt : ints) {
            Node node = new Node(anInt);
            binaryTree.add(node);
        }

        binaryTree.inorder();

        binaryTree.delete(7);
        binaryTree.delete(3);
        binaryTree.delete(10);
        binaryTree.delete(12);
        binaryTree.delete(5);
        binaryTree.delete(9);
        binaryTree.delete(1);

        binaryTree.inorder();

    }


}


class BinaryTree {
    private Node root;

    public void delete(int value) {

        if (root != null) {

            //delete target
            Node target = search(value);
            if (target == null) {
                System.out.println("target not found");
            } else {

                if (root.left == null && root.right == null) {
                    root = null;
                } else {

                    //target parentNode
                    Node parent = searchParent(value);


                    //target is leaf
                    if (target.left == null && target.right == null) {

                        if (target.value < parent.value) {

                            parent.left = null;
                        } else {
                            parent.right = null;
                        }

                    }

                    //target has two leaf
                    else if (target.left != null && target.right != null) {
                        target.value = searchMinNode(target.right);
                    }

                    //target has one leaf
                    else {
                        if (parent != null) {
                            if (target.value < parent.value) {
                                parent.left = target.left;
                            } else {
                                parent.right = target.right;
                            }
                        } else {
                            if (target.left != null) {
                                root = target.left;

                            } else {
                                root = target.right;
                            }

                        }

                    }
                }
            }
        }
    }


    public int searchMinNode(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delete(target.value);
        return target.value;
    }


    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        }
        return null;
    }


    public Node searchParent(int value) {
        if (root != null) {
            return root.searchParent(value);
        }
        return null;
    }

    public void add(Node node) {
        if (root != null)
            root.add(node);
        else root = node;
    }


    public void inorder() {
        if (root == null) {
            System.out.println("tree is empty");
        } else root.inorder();
    }


}


class Node {
    int value;
    Node left;
    Node right;


    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value < this.value && this.left != null) {
            return this.left.search(value);
        }
        if (value > this.value && this.right != null) {
            return this.right.search(value);
        }
        return null;
    }

    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value) {
            return this;
        }
        if (this.right != null && this.right.value == value) {
            return this;
        }

        if (value < this.value && this.left != null) {
            return this.left.searchParent(value);
        }

        if (value >= this.value && this.right != null) {
            return this.right.searchParent(value);
        }


        return null;
    }


    public void add(Node node) {

        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left != null) {
                this.left.add(node);
            } else {
                this.left = node;
            }
        } else {
            if (this.right != null) {
                this.right.add(node);
            } else {
                this.right = node;
            }
        }

    }


    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }


        System.out.println(this.value);

        if (this.right != null) {

            this.right.inorder();
        }


    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + value +
                '}';
    }
}
