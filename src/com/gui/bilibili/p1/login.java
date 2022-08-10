package com.gui.bilibili.p1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三23:36.
 *
 * @author abc
 *
 *
 * 写一个登录窗口，需求输入账号，输入密码，确认登录按钮，登录成功与登录失败信息，排列整齐
 * 待续-------------------------------------------------------------------------
 */
public class login {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LOGIN");
        frame.setBounds(400,400,300,150);
        frame.setLayout(new GridLayout(4,1,10,10));

        JLabel l1 = new JLabel("账号：");
        JLabel l2 = new JLabel("密码：");

        JTextField jTextField = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();



        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
