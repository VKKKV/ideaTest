package com.gui.bilibili.java1;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2022/3/9星期三21:00.
 *
 * @author abc
 *
 *
 * JMenuBar>JMenu>JMenuItem
 */
public class MyJMenuBar {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyJMenuBar");
        frame.setBounds(300,400,400,300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu1 = new JMenu("Menu1");
        JMenu jMenu2 = new JMenu("Menu2");
        JMenu jMenu3 = new JMenu("Menu3");

        JMenuItem jMenuItem1 = new JMenuItem("Item1");
        JMenuItem jMenuItem2 = new JMenuItem("Item2");
        JMenuItem jMenuItem3 = new JMenuItem("Item3");
        JMenuItem jMenuItem4 = new JMenuItem("Item4");
        JMenuItem jMenuItem5 = new JMenuItem("Item5");
        JMenuItem jMenuItem6 = new JMenuItem("Item6");
        JMenuItem jMenuItem7 = new JMenuItem("Item7");
        JMenuItem jMenuItem8 = new JMenuItem("Item8");
        JMenuItem jMenuItem9 = new JMenuItem("Item9");

        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);

        jMenu2.add(jMenuItem4);
        jMenu2.add(jMenuItem5);
        jMenu2.add(jMenuItem6);

        jMenu3.add(jMenuItem7);
        jMenu3.add(jMenuItem8);
        jMenu3.add(jMenuItem9);

        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);

        frame.add(jMenuBar);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}
