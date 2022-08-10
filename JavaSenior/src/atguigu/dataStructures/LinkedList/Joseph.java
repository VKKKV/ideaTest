package atguigu.dataStructures.LinkedList;

/**
 * Created on 2022/6/1星期三15:29
 *
 * @author abc
 */
public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(25);
        circleSingleLinkedList.show();


    }
}


class CircleSingleLinkedList {
    private Boy first = new Boy(-1);

    public void add(int num) {
        Boy curBoy = null;
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                Boy boy = new Boy(i);
                if (i == 1) {
                    first = boy;
                    first.setNext(first);
                    curBoy = first;
                } else {
                    curBoy.setNext(boy);
                    boy.setNext(first);
                    curBoy = boy;
                }
            }
        } else {
            System.out.println("num error");
            return;
        }
    }

    public void show() {
        if (first == null) {
            System.out.println("list null");
        } else {
            Boy temp = first;
            while (true) {
                System.out.println(temp);
                temp = temp.getNext();
                if (temp == first) {
                    break;
                }

            }
        }
    }

}


class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no + "}";
    }
}



