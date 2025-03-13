package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.DriverDAO;
import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DriverDAOImpl implements DriverDAO {
    @Override
//    public ArrayList<Driver> getAllDriver() throws SQLException, ClassNotFoundException {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
//        PreparedStatement pstm = con.prepareStatement("select * from Driver");
//
//        ResultSet rst = pstm.executeQuery();
//
//        ArrayList<Driver> drivers = new ArrayList<>();
//        while(rst.next()){
//            Driver driver = new Driver(
//                    rst.getString(1),
//                    rst.getString(2),
//                    rst.getString(3),
//                    rst.getString(4),
//                    rst.getString(5),
//                    rst.getString(6),
//                    rst.getString(7),
//                    rst.getString(8)
//            );
//            drivers.add(driver);
//        }
//
//        return drivers;
//    }
    public ArrayList<Driver> getAllDriver() throws SQLException, ClassNotFoundException {
        ArrayList<Driver> drivers = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");

            String query = "SELECT * FROM Driver";
            pstm = con.prepareStatement(query);
            rst = pstm.executeQuery();

            while (rst.next()) {
                Driver driver = new Driver(
                        rst.getString("driverID"),
                        rst.getString("driverName"),
                        rst.getString("mobileNo"),
                        rst.getString("license"),
                        rst.getString("experienceYears"),
                        rst.getString("email") != null ? rst.getString("email") : "--", // Handle null email
                        rst.getString("address") != null ? rst.getString("address") : "--", // Handle null address
                        rst.getString("status") != null ? rst.getString("address") : "--"
                );
                drivers.add(driver);
            }
        } finally {
            if (rst != null) rst.close();
            if (pstm != null) pstm.close();
            if (con != null) con.close();
        }

        return drivers;
    }

    @Override
//    public boolean saveDriver(Driver entity) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
//        con.setAutoCommit(false); // Start transaction
//        PreparedStatement pstm = con.prepareStatement("insert into Driver values(?,?,?,?,?,?,?,?)");
//        pstm.setObject(1, entity.getDriverID());
//        pstm.setObject(2, entity.getDriverName());
//        pstm.setObject(3, entity.getMobileNo());
//        pstm.setObject(4, entity.getLicense());
//        pstm.setObject(5, entity.getExperienceOfYear());
//        pstm.setObject(6, entity.getEmail());
//        pstm.setObject(7, entity.getAddress());
//        pstm.setObject(8, entity.getStatus());
//
//        if (pstm.executeUpdate()>0){
//            return true;
//        }else{
//            return false;
//        }
//    }
    public boolean saveDriver(Driver entity) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
            con.setAutoCommit(false); // Start transaction

            String query = "INSERT INTO Driver (driverID, driverName, mobileNo, license, experienceYears, email, address, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(query);
            pstm.setObject(1, entity.getDriverID());
            pstm.setObject(2, entity.getDriverName());
            pstm.setObject(3, entity.getMobileNo());
            pstm.setObject(4, entity.getLicense());
            pstm.setObject(5, entity.getExperienceOfYear());
            pstm.setObject(6, entity.getEmail());
            pstm.setObject(7, entity.getAddress());
            pstm.setObject(8, entity.getStatus());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                con.commit(); // Commit the transaction
                return true;
            } else {
                con.rollback(); // Rollback the transaction
                return false;
            }
        } catch (Exception e) {
            if (con != null) {
                con.rollback(); // Rollback the transaction in case of an exception
            }
            e.printStackTrace(); // Log the exception
            return false;
        } finally {
            // Close resources
            if (pstm != null) pstm.close();
            if (con != null) con.close();
        }
    }

    @Override
    public boolean updateDriver(Driver entity) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");

        PreparedStatement pstm = con.prepareStatement("update Driver set driverName=?, mobileNo=?, license=?, expereinceYear=?, where driverId=?");
        pstm.setObject(1, entity.getDriverName());
        pstm.setObject(2, entity.getMobileNo());
        pstm.setObject(3, entity.getLicense());
        pstm.setObject(4, entity.getExperienceOfYear());
        pstm.setObject(5, entity.getDriverID());

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteDriver(String id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("delete from Driver where driverId=?");
        pstm.setObject(1, id);

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean ifDriverExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Driver searchDriver(String driverID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Driver where driverId=?");
        pstm.setObject(1, driverID);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Driver(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
        }else{
            return null;
        }
    }

}
