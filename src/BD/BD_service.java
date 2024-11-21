package BD;

import java.sql.*;
import Listener.*;
import entity.stu;

import javax.swing.*;

public class BD_service {
    public static final String url = "jdbc:mysql://localhost:3306/studb";
    public static final String username = "root";
    public static final String password = "123456";
    public static final String driver = "com.mysql.cj.jdbc.Driver";


    public static stu Query() throws SQLException, ClassNotFoundException {
        stu Student = new stu();
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        try {
            String sql = "select * from stu_info where id = ? and deleted = 1";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mainViewListener.str1);
            ResultSet rs = stmt.executeQuery();

            if(!rs.next()){
                JOptionPane.showMessageDialog(null, "查无此人!!","查询结果"
                        ,JOptionPane.WARNING_MESSAGE);
            }
            else
            {//不为空
                 do {
                    Student.setId(rs.getString("id"));
                    Student.setName(rs.getString("name"));
                    Student.setSex(rs.getString("sex"));
                    Student.setScore(rs.getDouble("score"));  //循环执行某操作
                }while(rs.next());
            }
        }
        catch (SQLException e) {}

     return Student;
    }

    public static void insert() throws SQLException, ClassNotFoundException {

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        Statement conn = con.createStatement();
        try {
            String sql = "insert into stu_info (id , name, sex, score,deleted)values(?,?,?,?,1)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,insertViewListener.student.getId());
            stmt.setString(2,insertViewListener.student.getName());
            stmt.setString(3,insertViewListener.student.getSex());
            stmt.setDouble(4,insertViewListener.student.getScore());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"插入错误，检查'学号'唯一性！！");
        }

    }

    public static void update() throws SQLException, ClassNotFoundException {


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        try {
            String sql = "update stu_info set id = ?,name= ?,sex = ?,score = ? where id= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,updateViewListener.Student.getId());
            stmt.setString(2,updateViewListener.Student.getName());
            stmt.setString(3,updateViewListener.Student.getSex());
            stmt.setDouble(4,updateViewListener.Student.getScore());
            stmt.setString(5, mainViewListener.str1);
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"插入错误，检查'学号'唯一性！！");
        }

    }

    public static void delete() throws SQLException, ClassNotFoundException {


        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, username, password);
        try {
            String sql = "update stu_info set deleted = 0 where id= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,selectSuccessListener.str);
            stmt.executeUpdate();
        } catch (SQLException e) {}
    }

}
