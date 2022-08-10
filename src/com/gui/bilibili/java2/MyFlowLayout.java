package com.gui.bilibili.java2;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三21:58.
 *
 * @author abc
 */
public class MyFlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyFlowLayout");
        frame.setBounds(300,400,400,300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton b1 = new JButton("b1");
        JButton b2 = new JButton("b2");
        JButton b3 = new JButton("b3");
        JButton b4 = new JButton("b4");
        JButton b5 = new JButton("b5");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
