package com.gui.bilibili.java2;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三22:03.
 *
 * @author abc
 */
public class MyBorderLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyBorderLayout");
        frame.setBounds(300, 400, 400, 300);
        frame.setLayout(new BorderLayout());

        JButton north = new JButton("北");
        JButton south = new JButton("南");
        JButton west = new JButton("西");
        JButton east = new JButton("东");
        JButton center = new JButton("中");

        frame.add(north,BorderLayout.NORTH);
        frame.add(south,BorderLayout.SOUTH);
        frame.add(west,BorderLayout.WEST);
        frame.add(east,BorderLayout.EAST);
        frame.add(center,BorderLayout.CENTER);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
