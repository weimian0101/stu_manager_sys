package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import BD.BD_service;
import entity.stu;
import view.*;

import javax.swing.*;

public class insertViewListener implements ActionListener {
    public static stu student;
    insertView view;

    public void setView(insertView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.button1) {
            //添加学生信息
            student = new stu();
            student.setId(view.textField4.getText().trim());
            student.setName(view.textField1.getText().trim());
            student.setSex(view.textField2.getText().trim());
            student.setScore(Double.parseDouble(view.textField3.getText().trim()));
            try {
                BD_service.insert();
                JOptionPane.showMessageDialog(null, "添加成功！");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "添加失败！");
            }
            view.dispose();

        }
        if (e.getSource() == view.button2) {
            //关闭窗口
            view.dispose();
        }
    }
}
