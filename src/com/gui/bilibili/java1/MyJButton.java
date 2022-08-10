package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三19:01.
 *
 * @author abc
 */
public class MyJButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJButton");
        frame.setLayout(new FlowLayout());
        frame.setBounds(300,400,400,300);

        JButton b1 = new JButton("b1");
        b1.setToolTipText("tipTest");//提示文字/瞄准了有提示

        b1.setEnabled(false);//是否可用/默认true
        b1.setBorderPainted(false);//显示边界/文字多个框/默认true

//        JPanel p1 = new JPanel(new FlowLayout());
//        p1.add(b1);

        frame.add(b1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
