package com.gui.bilibili.java3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created on 2022/3/9星期三23:12.
 *
 * @author abc
 */
public class MyActionListener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyActionListener");
        frame.setBounds(300,400,400,300);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextArea jTextArea = new JTextArea(20, 20);
        jTextArea.setLineWrap(true);
        JButton house = new JButton("house");

        house.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                jTextArea.setText("不讲");//会把之前的覆盖，导致不能实现重复输出的效果
                jTextArea.append("伍德");//append：追加
            }
        });

        frame.add(jTextArea);
        frame.add(house);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
