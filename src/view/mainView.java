package view;
import Listener.mainViewListener;

import javax.swing.*;
import java.awt.*;

public  class mainView extends JFrame {
    public JLabel label;
    public JTextField textField;
    public JButton button1;
    public JButton button2;
    //主界面
    public void Mainview(){

        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setVisible(true);

        mainViewListener listener;
        JPanel panel = new JPanel();
        FlowLayout flow = new FlowLayout();;
        panel.setLayout(flow);

        label = new JLabel("欢迎使用学生管理系统");
        label.setFont(new Font("楷体", Font.BOLD, 50));
        panel.add(label);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));

        button1 = new JButton("查询");
        button2 = new JButton("添加");

        listener = new mainViewListener();
        listener.setView(this);

        panel.add(textField);
        textField.addActionListener(listener);

        panel.add(button1);
        button1.addActionListener(listener);

        panel.add(button2);
        button2.addActionListener(listener);

        frame.add(panel);
        frame.setVisible(true);
    }
}