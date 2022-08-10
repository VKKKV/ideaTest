package atguigu.dataStructures.LinkedList;

/**
 * Created on 2022/5/28星期六14:45
 *
 * @author abc
 * <p>
 * 双向链表的第二种添加方式,按照编号顺序 [示意图]按照单链表的顺序添加，稍作修改即可.
 */
public class DoubleLInkedListDemo {
    public static void main(String[] args) {
        DoubleList doublelist1 = new DoubleList();
        doublelist1.add(new DoubleLinkNode(1));
        doublelist1.add(new DoubleLinkNode(3));
        doublelist1.add(new DoubleLinkNode(5));
        doublelist1.add(new DoubleLinkNode(7));
        doublelist1.add(new DoubleLinkNode(9));

        DoubleList doublelist2 = new DoubleList();
        doublelist2.add(new DoubleLinkNode(0));
        doublelist2.add(new DoubleLinkNode(1));
        doublelist2.add(new DoubleLinkNode(2));
        doublelist2.add(new DoubleLinkNode(3));
        doublelist2.add(new DoubleLinkNode(4));


        System.out.println("1");
        doublelist1.list();

        System.out.println("----------------?");
        doublelist1.addByOrder(new DoubleLinkNode(7));
        doublelist1.list();

        System.out.println("2");
        doublelist2.list();

    }
}


class DoubleList {
    private DoubleLinkNode head = new DoubleLinkNode(-1);

    //末尾添加
    public void add(DoubleLinkNode doubleLinkNode) {
        DoubleLinkNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = doubleLinkNode;
        doubleLinkNode.pre = temp;
    }

    //****
    //顺序添加
    public void addByOrder(DoubleLinkNode heroNode) {
        DoubleLinkNode temp = head;
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
            System.out.printf("准备插入的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp 的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
            heroNode.pre=temp;
            temp.next.pre=heroNode;
        }

    }

    //list
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        DoubleLinkNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        DoubleLinkNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            } else {
                System.out.printf("要删除的 %d 节点不存在\n", no);
            }
        }
    }
}

class DoubleLinkNode {
    public int no;
    public DoubleLinkNode next;
    public DoubleLinkNode pre;

    public DoubleLinkNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "no=" + no +
                '}';
    }
}