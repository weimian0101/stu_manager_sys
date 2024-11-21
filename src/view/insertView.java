package view;

import Listener.*;
import entity.stu;

import javax.swing.*;
import java.awt.*;

public class insertView extends Component {
    public JFrame frame;
    public JLabel label1, label2, label3,label4;
    public JTextField textField1, textField2, textField3,textField4;
    public JButton button1, button2;

    public void insert() {
        frame = new JFrame("添加学生信息");
        frame.setSize(800, 300);

        insertViewListener listener;
        JPanel panel = new JPanel();
        FlowLayout flow = new FlowLayout();;


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("输入姓名");
        textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(100, 30));
        label4 = new JLabel("输入学号");
        textField4 = new JTextField();
        textField4.setPreferredSize(new Dimension(100, 30));
        label2 = new JLabel("输入性别");
        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(100, 30));
        label3 = new JLabel("输入分数");
        textField3 = new JTextField();
        textField3.setPreferredSize(new Dimension(100, 30));
        button1 = new JButton("添加");
        button2 = new JButton("取消");

        listener = new insertViewListener();
        listener.setView(this);
        button1.addActionListener(listener);
        button2.addActionListener(listener);


        panel.add(label1);
        panel.add(textField1);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(button1);
        panel.add(button2);

        frame.add(panel);
        frame.setVisible(true);

    }

    public void dispose() {
        frame.dispose();
    }
}
