package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import BD.BD_service;
import entity.stu;
import view.*;

import javax.swing.*;

public class updateViewListener implements ActionListener {
    public static stu Student = new stu();
    updateView view;
    public void setView(updateView view) {
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.button1){
            Student.setId(view.textField1.getText().trim());
            Student.setName(view.textField2.getText().trim());
            Student.setSex(view.textField3.getText().trim());
            Student.setScore(Double.parseDouble(view.textField4.getText().trim()));
            try {
                BD_service.update();
                JOptionPane.showMessageDialog(null, "修改成功！");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"修改失败，检查'学号'唯一性！！");
            }
            view.dispose();
        }
    }
}
