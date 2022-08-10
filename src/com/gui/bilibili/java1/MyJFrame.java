package com.gui.bilibili.java1;

import javax.swing.*;

/**
 * Created on 2022/3/9星期三17:47.
 *
 * @author abc
 */
public class MyJFrame {
    public static void main(String[] args) {
        JFrame frame=new JFrame("jframe");
//        frame.setSize(500,500);
//        frame.setLocationRelativeTo(null);
        frame.setBounds(500,400,500,400);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);


    }
}
