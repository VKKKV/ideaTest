package com.gui.bilibili.java1;

//import javax.swing.*;

//import javax.swing.*;

import javax.swing.*;

/**
 * Created on 2022/3/9星期三18:30.
 *
 * @author abc
 */
public class MyJPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJPanel");
        frame.setBounds(400,300,1200,200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton b1 = new JButton("b1");
        JButton b2 = new JButton("b2");
        b1.setSize(800,200);
        b2.setSize(200,500);

        frame.setVisible(true);

        JPanel jPanel = new JPanel();

        jPanel.add(b1);
        jPanel.add(b2);

//        JScrollPane jScrollPane = new JScrollPane(b1);


        frame.add(jPanel);//套娃


    }
}
