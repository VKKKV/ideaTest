package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三21:24.
 *
 * @author abc
 */
public class MyJTextField_MyJPasswordField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJTextField&MyJPasswordField");
        frame.setBounds(300,400,400,300);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label1 = new JLabel("账号：");
        JLabel label2 = new JLabel("密码：");

//        文本框不可换行
        JTextField textField = new JTextField("Please enter:",22);
        frame.add(label1);
        frame.add(textField);
        frame.add(label2);
        JPasswordField jPasswordField = new JPasswordField("", 22);
        jPasswordField.setEchoChar('*');//默认为····
        frame.add(jPasswordField);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
