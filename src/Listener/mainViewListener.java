package Listener;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class mainViewListener implements ActionListener {
    public static String str1;
    mainView view;
    public void setView(mainView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //
        if(e.getSource() == view.button1){
            str1 = view.textField.getText();
            try {
                new selectSuccessView().showMessage();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"数据库连接失败，检查'学号'唯一性！！");
            }

        }else if(e.getSource() == view.button2){

            new insertView().insert();

        }

    }
}
