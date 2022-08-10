package atguigu.java.IOTest;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Created on 2022/3/30星期三9:45
 *
 * @author abc
 *
 * 处理流二：
 * 1.转换流：属于字符流
 *  InputStreamReader/OutputStreamWriter
 *  字节 --> 字符 -->字节
 *
 */
public class InputStreamReaderTest {

    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("hello_gbk.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");



        char[] chars = new char[10];
        int len;
        while ((len=inputStreamReader.read(chars))!=-1){
            outputStreamWriter.write(chars,0,len);
        }


        inputStreamReader.close();
        outputStreamWriter.close();

    }



}
