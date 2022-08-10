package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三21:44.
 *
 * @author abc
 */
public class MyJTextArea {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJTextArea");
        frame.setBounds(300,400,400,300);
        frame.setLayout(new FlowLayout());

        //添加一个文本域可以换行
        JTextArea jTextArea = new JTextArea(20, 20);
        jTextArea.setLineWrap(true);//是否自动换行默认为false

        jTextArea.getText();//获取文本//如何输出？？？？？？？？？？？

        frame.add(jTextArea);



        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
