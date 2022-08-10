package atguigu.java.IOTest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 2022/3/29星期二11:54
 *
 * @author abc
 * <p>
 * file类的使用
 * 1.file类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
 * 2.file类声明在java.io包下
 * 3.file类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 * 并未涉及到写入或读取文件内容的操作。如果需要读取写入文件类容，必须使用IO流来完成。
 * 4.file类的对象常会作为参数传递到流的构造器中，指明读取或写入的终点
 * <p>
 * 1.创建file类的实例
 * 2.相对路径：相较于某个路径下，指明的路径。
 * 绝对路径：包含盘符在内的文件或文件目录的路径。
 *
 * 一、流的分类：
 * 1.操作数据单位：字节流、字符流
 * 2.数据的流向：输入流、输出流
 * 3.流的角色：节点流、处理流（缓冲流buffered-
 *
 *
 *
 * <p>
 * 1.造文件
 * 2.造流
 * 3.读数据
 * 4.关闭资源
 *
 * 结论：
 * 1.对于文本文件（txt、java、c、cpp），使用字符流处理
 * 2.对于非文本文件（jpg、mp3、mp4、avi、doc、ppt……）使用字节流处理；可以复制文本文件但是控制台观察会乱码
 */
public class FileTest {


    //copy car.jpg
    //fileReader&fileWriter不能写入图片：char[]不能输出二进制
    @Test
    public void test3() {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            //1.造文件
            File srcFile = new File("car.jpg");
            File destFile = new File("car1.jpg");


            //2.造流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            //一般用1kb
            byte[] bytes = new byte[1024];
            int len;
            //3.读数据
            while ((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();

            //4.关闭资源
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void test2() throws IOException {
        File file = new File("hello.txt");
        boolean newFile = file.createNewFile();
    }


    @Test
    public void test1() {
        File file = new File("hello.txt");
        /*路径中每级目录之间用一个分隔符隔开。
            >windows和DOS系统默认\表示
            >UNIX和URL使用/表示
            为了解决这个隐患，file类提供了一个常量：
                public static final String separator
                根据操作系统，动态的分隔符

         */
        File file1 = new File("D:\\ideaproject");
        File file2 = new File("D:" + File.separator + "ideaproject");

        //此时没有涉及到文件的删改，仅仅是内存层面的一个对象
        System.out.println(file);
        System.out.println(file1);
        System.out.println(file2);

        //目录中的文件
        for (File s : file1.listFiles()) {
            System.out.println(s);
        }

    }
}
