package com.gui.bilibili.java1;

import javax.swing.*;

/**
 * Created on 2022/3/9星期三18:53.
 *
 * @author abc
 */
public class MyJLabel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MYJLABLE");
        frame.setBounds(300,400,400,300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel jLabel = new JLabel("myjlable",SwingConstants.CENTER);

        frame.add(jLabel);


        frame.setVisible(true);
    }
}
