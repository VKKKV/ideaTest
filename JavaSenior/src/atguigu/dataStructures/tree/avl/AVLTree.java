package atguigu.dataStructures.tree.avl;

/**
 * Created on 2022/7/31星期日16:56
 *
 * @author abc
 *
 * 平衡二叉树
 */
public class AVLTree {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        BinaryTree AVLTree = new BinaryTree();

        for (int i : arr) {
            AVLTree.add(new Node(i));
        }

        System.out.println(AVLTree.getRoot().leftHeight());
        System.out.println(AVLTree.getRoot().rightHeight());

    }
}


class BinaryTree {
    private Node root;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

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

    public Node() {
    }

    public Node(int value) {
        this.value = value;
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

//
        if (leftHeight() + 1 < rightHeight()) {
            if (right != null && right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
                leftRotate();
            }else leftRotate();

        } else if (rightHeight() + 1 < leftHeight()) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            }else rightRotate();
        }

    }


    private void leftRotate() {
        Node node = new Node(value);
        node.left = left;
        node.right = right.left;
        value = right.value;
        right = right.right;
        left = node;
    }

    private void rightRotate() {
        Node node = new Node(value);
        node.right = right;
        node.left = left.right;
        value = left.value;
        left = left.left;
        right = node;
    }


    public int leftHeight() {
        return left == null ? 0 : left.height();
    }

    public int rightHeight() {
        return right == null ? 0 : right.height();
    }

    //以该结点为root的高度

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //preorder search

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


    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }


        System.out.println(this.value);

        if (this.right != null) {

            this.right.inorder();
        }


    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + value +
                '}';
    }
}
