package view;

import BD.BD_service;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

import Listener.*;
import entity.stu;

public class selectSuccessView {
    public JFrame frame;
    public JLabel label1 = null;
    public JButton button1, button2;
    public stu Stu;
    public void showMessage() throws SQLException, ClassNotFoundException {
        if (BD_service.Query().getId() != null){


        frame= new JFrame("查询成功");
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        selectSuccessListener listener;
        JPanel panel = new JPanel();

        Stu = BD_service.Query();
        label1 = new JLabel(Stu.toString());
        button1 = new JButton("删除");
        button2 = new JButton("更新");


        listener = new selectSuccessListener();
        listener.setView(this);

        panel.add(label1);
        button1.addActionListener(listener);
        panel.add(button1);
        button2.addActionListener(listener);
        panel.add(button2);

        frame.add(panel);
        frame.setVisible(true);

        }
    }

    public void dispose() {
        frame.dispose();
    }
}
