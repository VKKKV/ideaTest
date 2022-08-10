package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三19:26.
 *
 * @author abc
 */
public class MyJCheckBox {//复选框
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyCheckBox");
        frame.setBounds(300,400,400,300);

        JCheckBox male = new JCheckBox("male");//默认为false,不自动勾上
        JCheckBox female = new JCheckBox("female" , false);//出场没勾
        JCheckBox g = new JCheckBox("g" , true);//自动勾了
        JCheckBox b = new JCheckBox("b" ,true);

        frame.setLayout(new FlowLayout());
        frame.add(male);
        frame.add(female);
        frame.add(g);
        frame.add(b);

        //两个方框勾选
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}