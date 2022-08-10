package atguigu.java.collectionTest;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created on 2022/3/25星期五15:43
 *
 * @author abc
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
 * 说明：此时的存储，主要值的是内存层面的存储，不涉及到持久化的
 * 存储（.txt.jpg）
 * 1.数组再存储多个数据方面的特点：
 *      》一旦初始化以后，其长度就确定了。
 *      》数组一旦定义好，其元素的类型也就确定了。 我也就只能操作指定类型的数据了
 *      比如String[] arr int[] arr1
 * 2.数组再存储多个数据方面的缺点：
 *      》一旦初始化长度不可修改
 *      》数组中提供的方法优先，对于增删改查等操作非常不便，同时效率低
 *      》获取数组中实际元素的个数的需求，无属性和方法
 *      》存储数据的特点：有序，可重复。不能满足无序，不可重复的需求
 *
 *2.集合框架：
 *  collection接口：单列集合，用来存储一个一个的对象
 *          list接口：存储有序可重复的数据 -->“动态”数组
 *              arraylist：list接口主要实现类；线程不安全，效率高；底层使用object[]存储
 *              linkedlist：对于频繁插入删除，效率比arraylist高；底层使用双向链表存储
 *              vector：list接口的古老实现类；线程安全，效率低；底层使用object[]存储
 *
 *          set接口：存储无序不可重复的数据：高中“集合”
 *          要求：向set中添加的数据，其所在类一定要重写hashcode和equals
 *          要求：重写的hashcode和equals尽可能保持一致：相等的对象必须具有相等的散列码
 *              添加元素的过程:以hashset为例：
 *                  向hashset添加元素a，首先调用元素a所在类的hashcode方法，计算元素a的hash值
 *                  此哈希值接着通过算法计算出在hashset底层数组中的存放位置（即为：索引位置）。
 *                  判断此位置上是否已经有元素：
 *                      如果此位置上没有其他元素，则元素a添加成功----------1
 *                      如果此位置上有其他元素b（或以链表形式存在的多个元素），则 比较元素a与b的哈希值：
 *                          如果hash值不相同，添加成功------------------2
 *                          如果hash值相同，需要调用元素a的equals方法，
 *                              equals返回true，相同 ，元素a添加失败
 *                              equals返回false，元素a添加成功。--------3
 *                   对于添加成功的2和3而言：元素a与已经存在指定索引位置上的数据以链表的方式存储
 *                      jdk7：元素a放到数组中，指向原来的元素；
 *                      jdk8：原来的元素在数组中，指向元素a
 *                      总结：七上八下
 *
 *              hashset：set接口主要实现类，线程不安全，可以存储null值
 *                  1.无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据哈希值
 *                  2.不可重复性：保证添加的元素按照equals判断时，不能返回true，即：相同的元素只能添加一个

 *                  linkedhashset：作为hashset的子类；遍历其内部数据时按照添加的顺序遍历
 *                                 对于频繁的遍历操作，linkedhashset效率高于hashset
 *
 *              treeset：可以按照添加对象的指定属性，进行排序
 *
 *  map接口：双列集合，存储一堆键值一对的数据
 *             hashmap: 作为Map的主要实现类；线程不安全，效率高；存储null的key和value
 *                      底层：数组+链表（jdk7之前）
 *                           数组+链表+红黑树（jdk8）
 *                  linkedhashmap：保证在遍历map元素时，可以按照添加顺序实现遍历。
 *                              原因：在原有的hashmap底层结构基础上，添加了一对指针，指向前一个和后一个元素。
 *             treemap：保证按照添加的keyvalue对进行排序，实现排序遍历，此时考虑key的自然排序定制排序
 *                      底层使用红黑树
 *             hashtable：作为古老的实现类；线程安全，效率低；不能存储null的key和value
 *                  properties：处理配置文件。key-value都时string类型
 *
 *  map结构的理解：
 *      map中的key：无序的，不可重复，使用set存储所有的key --->key所在的类要重写equals和hashcode
 *      map中的value：无序的，可重复，使用collection存储所有的value -->value所在类要重写equals
 *      一个键值对：key-value构成了一个entry对象。
 *      map中的entry：无序的，不可重复的，使用set存储所有的entry
 *
 * hashmap的底层实现原理：jdk7为例
 *      new hashmap
 *      实例化以后底层创建了长度是16的一维数组entry[] table
 *      。。。。可能已经执行过多次put。。。
 *      map.put(key,value):
 *          首先，调用key所在类的hashcode计算hash值，某种算法计算后，得到在entry数组中的存放位置
 *          如果此位置上的数据为空，entry添加成功。
 *          如果此位置上的数据不为空，此位置上存在一个或多个数据（链表形式），比较key与已经存在的一个或多个数据的
 *          hash值：
 *                  如果key的hash值与已在的数据不同，key-value添加成功
 *                  如果key的hash值与已经存在的某一个数据的hash值相同，继续比较：调用key的equals方法比较：
 *                      如果equals返回false：key-value添加成功
 *                      如果equals返回true：使用value替换相同key'的value值，（修改）
 *          对于后两种情况： 此时的key-value和原来的数据以链表方式存储
 *
 *          不断添加的过程中，涉及到扩容问题，默认扩容为原来的容量的2倍，并将原有的数据复制过来
 *
 *          jdk8对比jdk7的不同：
 *          1.new的时候底层没有创建一个长度16的数组
 *          2.jdk8底层的数组是：Node[]而非Entry[]
 *          3.首次调用put，底层创建长度16的数组（类似ArrayList
 *          4.jdk7底层结构只有数组+链表。jdk8：数组+链表+红黑树
 *            当数组的某一个索引位置上的元素，以链表形式存在的数据个数>8且当前数组的长度>64时
 *            此时索引位置上的所有数据用红黑树存储
 *
 *
 */

/**
 * 面试题：arraylist linkedList vector：矢量 异同
 *  同：都实现了list接口，存储特点：有序、可重复
 *  不同：
 *      arraylist源码分析：
 *      jdk7中
 *          arraylist list=new arraylist();//底层创建了长度是10的object数组elementData
 *          list.add(123);//elementData[0]=new Interger(123);
 *
 *          list.add(11);//如果此次添加导致底层elementData数组容量不够，则扩容
 *          默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组
 *          结论：建议开发中使用带参的构造器：arraylist list = new arraylist(int capacity)
 *      jdk8中
 *          arraylist list=new arraylist(); //底层object[] elementData初始化为{},并没有创建长度为10的数组
 *          list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将123添加到elementData
 *          后续添加与扩容操作与jdk7无异
 *      小结：jdk7中的arraylist的对象的创建类似于单例的饿汉式，而jdk8中的arraylist的对象
 *           的创建类似于单例的懒汉式，延迟了数组的创建，节省内容。
 *
 *      linkedList:
 *      new linkedList内部声明了Node类型的first和last属性
 *      list.add将数据封装到Node中，创建了node对象
 *
 *      vector:jdk7和jdk8中通过vector构造器创建对象时，底层都创建了长度为10的数组
 *              在扩容方面，默认扩容为原来数组长度的两倍。
 *
 */
public class listhashsetlinkedhashset {
    public static void main(String[] args) {
        Collection<Integer> a =new ArrayList<Integer>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);

        Collection<Integer> b =new ArrayList<Integer>();

        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);


        //对象每次调用iterator方法都得到一个全新的迭代器对象
        Iterator<Integer> iterator = b.iterator();

        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next==1){//数据为1时
                iterator.remove();//删除当前数据
            }
        }



        //iter快捷键
        for (Integer integer : b) {
            System.out.println(integer);
        }


        a.removeAll(b);//差集
        System.out.println(a);

        a.retainAll(b);//交集
        System.out.println(a);



    }

    //map的遍历
    //使用keySet和value
    @Test
    public void test1(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");

        for (Object o : map.keySet()) {
            System.out.println(o);
        }

        System.out.println();

        for (Object value : map.values()) {
            System.out.println(value);
        }

        System.out.println();
        //成对
        for (Map.Entry<Object, Object> objectObjectEntry : map.entrySet()) {
            System.out.println(objectObjectEntry);
        }


    }
}
