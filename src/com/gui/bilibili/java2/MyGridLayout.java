package com.gui.bilibili.java2;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三22:43.
 *
 * @author abc
 */
public class MyGridLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyGridLayout");
        frame.setBounds(300,400,400,300);
        frame.setLayout(new GridLayout(3,3,10,20));

        JButton b1 = new JButton("b1");
        JButton b2 = new JButton("b2");
        JButton b3 = new JButton("b3");
        JButton b4 = new JButton("b4");
        JButton b5 = new JButton("b5");
        JButton b6 = new JButton("b6");
        JButton b7 = new JButton("b7");
        JButton b8 = new JButton("b8");
        JButton b9 = new JButton("b9");

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.add(b8);
        frame.add(b9);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
