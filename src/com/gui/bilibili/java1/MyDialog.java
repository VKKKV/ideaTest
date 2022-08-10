package com.gui.bilibili.java1;

import javax.swing.*;

/**
 * Created on 2022/3/9星期三18:20.
 *
 * @author abc
 */
public class MyDialog {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MySecondJFrame");
        frame.setBounds(400,400,300,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JDialog myDialog = new JDialog(frame, "MyDialog");
        myDialog.setBounds(400,400,100,100);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        myDialog.setVisible(true);
    }
}
