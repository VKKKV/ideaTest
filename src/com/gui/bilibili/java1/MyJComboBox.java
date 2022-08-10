package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三20:16.
 *
 * @author abc
 *
 *
 * 下拉列表框
 */
public class MyJComboBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJComboBox");
        frame.setBounds(300,400,400,300);


        //与泛型有关？？？？？
        JComboBox objectJComboBox = new JComboBox();
        objectJComboBox.addItem("first");
        objectJComboBox.addItem("second");
        objectJComboBox.addItem("third");

        //小三角打开列表选框
        frame.setLayout(new FlowLayout());
        frame.add(objectJComboBox);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}