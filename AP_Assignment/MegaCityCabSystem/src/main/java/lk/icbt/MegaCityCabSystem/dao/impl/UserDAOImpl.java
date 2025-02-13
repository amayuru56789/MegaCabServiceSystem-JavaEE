package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.UserDAO;

import java.sql.*;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean checkEqualityUser(String userName, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
            String query = "select * from User where userName=? && password=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setObject(1, userName);
            pstm.setObject(2, password);
            ResultSet rst = pstm.executeQuery();

            if (rst.next()){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
