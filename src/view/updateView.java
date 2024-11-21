package view;

import Listener.updateViewListener;

import javax.swing.*;

public class updateView {

    public JFrame frame;

    public JButton button1,button2;
    public JTextField textField1,textField2,textField3,textField4;

    public JLabel label1,label2,label3,label4;
    updateViewListener listener;

    public updateView() {
        frame = new JFrame("Update Student Details");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("学号");
        label2 = new JLabel("姓名");
        label3 = new JLabel("性别");
        label4 = new JLabel("分数");

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        textField4 = new JTextField(10);

        listener = new updateViewListener();
        listener.setView(this);

        button1 = new JButton("更新");
        button1.addActionListener(listener);
        button2 = new JButton("取消");
        button2.addActionListener(listener);

        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(button1);
        panel.add(button2);

        frame.add(panel);

        frame.setVisible(true);
    }

    public void dispose() {
        frame.dispose();
    }
}
