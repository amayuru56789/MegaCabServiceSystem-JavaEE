package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.UserDAO;
import lk.icbt.MegaCityCabSystem.entity.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public User getUser(String userName) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
            String query = "select * from User where userName=? ";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setObject(1, userName);
//            pstm.setObject(2, password);
            ResultSet rst = pstm.executeQuery();

            if (rst.next()){
                return new User(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            }else{
                return new User();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public String findRoleByUsername(String userName) {

        ResultSet rst = null;
        PreparedStatement pstm = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
            String query = "select * from User where userName=? ";
             pstm = con.prepareStatement(query);
            pstm.setObject(1, userName);
//            pstm.setObject(2, id);
            rst = pstm.executeQuery();

            if (rst.next()){
                return rst.getString("userrole"); // Return the role
            }else{
                return null; // Return null if no user is found
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // Close resources in the reverse order of their creation
            try {
                if (rst != null) rst.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Return null if an exception occurs
    }

    @Override
    public String findIdByUsername(String userName) {
        ResultSet rst = null;
        PreparedStatement pstm = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
            String query = "select * from User where userName=? ";
            pstm = con.prepareStatement(query);
            pstm.setObject(1, userName);
            rst = pstm.executeQuery();

            if (rst.next()){
                return rst.getString("userid"); // Return the role
            }else{
                return null; // Return null if no user is found
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // Close resources in the reverse order of their creation
            try {
                if (rst != null) rst.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null; // Return null if an exception occurs
    }
}
