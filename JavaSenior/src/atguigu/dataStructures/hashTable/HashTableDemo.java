package atguigu.dataStructures.hashTable;

import java.util.Scanner;

/**
 * Created on 2022/7/27星期三11:04
 *
 * @author abc
 * <p>
 * <p>
 * 哈希表 （散列表）
 * <p>
 * 雇员管理
 * <p>
 * 未实现delete
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("user:");
            key = scanner.next();

            switch (key) {
                case "h":
                    System.out.println();
                    System.out.println("a add");
                    System.out.println("l list");
                    System.out.println("d delete");
                    System.out.println("e exit");
                    System.out.println();
                    break;

                case "a":
                    System.out.println();

                    System.out.print("id:");
                    int id = scanner.nextInt();
                    System.out.print("name:");
                    String name = scanner.next();
                    hashTable.add(new Emp(id, name));

                    System.out.println();
                    break;
                case "l":
                    System.out.println();

                    hashTable.list();

                    System.out.println();
                    break;
                case "s":
                    System.out.println();
                    System.out.print("search:");
                    id = scanner.nextInt();

                    System.out.println(hashTable.search(id));

                    System.out.println();
                    break;

                case "d":

                case "e":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println();
                    System.out.println("h help");
                    System.out.println();

            }


        }


    }
}


class Emp {
    private int id;
    private String name;
    private Emp next;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}

class EmpLinkedList {
    private Emp head;

    public void add(Emp emp) {
        if (head == null) {
            head = emp;

        } else {
            Emp temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(emp);
        }
    }

    public void list(int no) {

        if (head == null) {
            System.out.println("list " + no + " is empty");
            return;
        }

        System.out.println("list " + no + " is:");

        Emp temp = head;
        System.out.println(temp);
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.println(temp);
        }

    }


    public Emp search(int id) {
        if (head == null) {
            return null;
        }

        Emp temp = head;
        if (temp.getId() == id) {
            return temp;
        }

        while (temp.getNext() != null) {
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

}

class HashTable {
    private EmpLinkedList[] arr;
    private int length;

    public HashTable(int length) {
        this.length = length;
        this.arr = new EmpLinkedList[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new EmpLinkedList();
        }

    }

    public void add(Emp emp) {
        int index = hashFun(emp.getId());
        arr[index].add(emp);
    }

    public void list() {
        for (int i = 0; i < length; i++) {
            arr[i].list(i);

        }

    }

    public int hashFun(int id) {
        return id % length;

    }

    public Emp search(int id) {
        for (int i = 0; i < length; i++) {
            EmpLinkedList list = arr[i];
            if (list.search(id) != null) {
                return list.search(id);
            }

        }
        return null;
    }
}
