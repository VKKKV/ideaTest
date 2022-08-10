package atguigu.dataStructures.tree;

/**
 * Created on 2022/7/28星期四10:22
 *
 * @author abc
 * <p>
 * <p>
 * 顺序存储二叉树
 * 使用数组，利用树的规则
 * <p>
 * 1) 顺序二叉树通常只考虑完全二叉树
 * <p>
 * 2) 第 n 个元素的左子节点为 2 * n + 1
 * <p>
 * 3) 第 n 个元素的右子节点为 2 * n + 2
 * <p>
 * 4) 第 n 个元素的父节点为 (n-1) / 2
 * <p>
 * 5) n : 表示二叉树中的第几个元素(按 0 开始编号如图所示)
 */
public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinary arrBinary = new ArrBinary(arr);
        arrBinary.preorder();
        System.out.println();
        arrBinary.inorder();
        System.out.println();
        arrBinary.postorder();

    }


}

class ArrBinary {
    private final int[] arr;

    public ArrBinary(int[] arr) {
        this.arr = arr;
    }

    public void preorder() {
        this.preorder(0);
    }

    public void inorder() {
        this.inorder(0);
    }

    public void postorder() {
        this.postorder(0);
    }


    public void preorder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("tree is empty");

        } else {
            System.out.println(arr[index]);
            if ((2 * index + 1) < arr.length) {
                preorder(2 * index + 1);
            }

            if ((2 * index + 2) < arr.length) {
                preorder(2 * index + 2);
            }

        }

    }

    public void inorder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("tree is empty");

        } else {
            if ((2 * index + 1) < arr.length) {
                inorder(2 * index + 1);
            }
            System.out.println(arr[index]);

            if ((2 * index + 2) < arr.length) {
                inorder(2 * index + 2);
            }

        }

    }

    public void postorder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("tree is empty");

        } else {
            if ((2 * index + 1) < arr.length) {
                postorder(2 * index + 1);
            }

            if ((2 * index + 2) < arr.length) {
                postorder(2 * index + 2);
            }

            System.out.println(arr[index]);
        }

    }

}
