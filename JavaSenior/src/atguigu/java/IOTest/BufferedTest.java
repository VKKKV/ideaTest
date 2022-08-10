package atguigu.java.IOTest;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Created on 2022/3/29星期二20:28
 *
 * @author abc
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader（readLine、newLine
 * BufferedWriter
 * <p>
 * 2.作用：提供流的读取、写入的效率
 *   提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3.处理流，就是“套接”在已有的流的基础上。
 *
 *
 * <p>
 * 资源关闭：先关闭外层的流，再关闭内层的流
 * 说明：关闭外层流的同时，内层流也会自动关闭。关于内层流的关闭可以省略
 */
public class BufferedTest {
    @Test
    public void test1() {

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.造文件
            File srcFile = new File("car.jpg");
            File destFile = new File("car2.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream inputStream = new FileInputStream(srcFile);
            FileOutputStream outputStream = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            //3.复制的细节：读取、写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {

                //加密
//                for (int i = 0; i < len; i++) {
//                    bytes[i]= (byte) (bytes[i]^5);
//                }

                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null)
                try {

                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bufferedOutputStream != null)
                try {

                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }

}
