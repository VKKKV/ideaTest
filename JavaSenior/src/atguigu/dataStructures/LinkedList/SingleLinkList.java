package atguigu.dataStructures.LinkedList;

/**
 * Created on 2022/4/26星期二17:33
 *
 * @author abc
 * <p>
 * Version 1
 * 合并两个有序的单链表，合并之后的链表依然有序
 */
public class SingleLinkList {
    public static void main(String[] args) {
        SingleList singleList1 = new SingleList();
        singleList1.add(new LinkNode(6));
        singleList1.add(new LinkNode(7));
        singleList1.add(new LinkNode(8));
        singleList1.add(new LinkNode(8));
        singleList1.add(new LinkNode(10));

        SingleList singleList2 = new SingleList();
        singleList2.add(new LinkNode(0));
        singleList2.add(new LinkNode(1));
        singleList2.add(new LinkNode(2));
        singleList2.add(new LinkNode(3));
        singleList2.add(new LinkNode(4));

        System.out.println("1");
        singleList1.list();
        singleList1.addByOrder(new LinkNode(9));
        System.out.println("-----------");
        singleList1.list();

        System.out.println("2");
        singleList2.list();

        SingleList singleList3 = singleList1.combine(singleList2);
        System.out.println("3");
        singleList3.list();
    }


}

class SingleList {
    private LinkNode head = new LinkNode(-1);

    public void add(LinkNode linkNode) {
        LinkNode temp = head; //遍历链表，找到最后
        while (true) { //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 将将 temp 后移
            temp = temp.next;
        }
        //当退出while 循环时，temp 就指向了链表的最后
        // 将最后这个节点的 next 指向 新的节点
        temp.next = linkNode;
    }

    public void addByOrder(LinkNode heroNode) {
        LinkNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }

        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp 的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    public void list() {
        if (head.next == null) {
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        LinkNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            } //输出节点的信息
            System.out.println(temp);
            //将 temp 后移， 一定小心
            temp = temp.next;
        }
    }

    public SingleList combine(SingleList singleList2) {
        SingleList result = new SingleList();
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历

        if (head.next == null && singleList2.head.next == null) {
            return null;
        } else if (head.next != null && singleList2.head.next == null) {
            return this;
        } else if (head.next == null) return singleList2;

        LinkNode temp1 = head;
        LinkNode temp2 = singleList2.head;
        LinkNode cur;

        while (true) {
//            判断是否到链表最后
            if (temp1.next == null && temp2.next == null) {
                break;
            } else if (temp1.next != null && temp2.next == null) {
                result.add(temp1.next);
                break;
            } else if (temp1.next == null) {
                result.add(temp2.next);
                break;
            }
            //输出节点的信息
            if (temp1.next.no < temp2.next.no) {
                //将 temp 后移， 一定小心
                cur = temp1.next;
                temp1.next = cur.next;
                cur.next = null;
                result.add(cur);
            } else if (temp1.next.no > temp2.next.no) {
                cur = temp2.next;
                temp2.next = cur.next;
                cur.next = null;
                result.add(cur);
            } else {
                cur = temp1.next;
                temp1.next = cur.next;
                cur.next = null;
                result.add(cur);

                cur = temp2.next;
                temp2.next = cur.next;
                cur.next = null;
                result.add(cur);
            }

        }

        return result;
    }
}


class LinkNode {
    public int no;
    public LinkNode next;

    public LinkNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "no=" + no +
                '}';
    }
}