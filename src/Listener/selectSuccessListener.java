package Listener;

import BD.BD_service;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class selectSuccessListener implements ActionListener {
    public static String str;
    selectSuccessView view;
    public void setView(selectSuccessView view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.button1){
                str = view.Stu.getId();
            try {
                BD_service.delete();
                JOptionPane.showMessageDialog(null, "删除成功！");
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"删除失败，检查'学号'唯一性！！");
            }
            view.dispose();
        }else if(e.getSource() == view.button2){
            new updateView();
            view.dispose();
        }
    }
}
