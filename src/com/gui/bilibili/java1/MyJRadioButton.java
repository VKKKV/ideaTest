package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三19:16.
 *
 * @author abc
 */
public class MyJRadioButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJRadioButton");
        frame.setBounds(300,400,300,400);

        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");

        //建立一个按钮组
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        //框架也需要添加
        frame.add(male);
        frame.add(female);

        //两个圆圈选
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
