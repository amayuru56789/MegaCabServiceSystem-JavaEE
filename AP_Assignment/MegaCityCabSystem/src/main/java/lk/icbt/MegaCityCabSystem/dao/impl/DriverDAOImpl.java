package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.DriverDAO;
import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DriverDAOImpl implements DriverDAO {
    @Override
    public ArrayList<Driver> getAllDriver() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Driver");

        ResultSet rst = pstm.executeQuery();

        ArrayList<Driver> drivers = new ArrayList<>();
        while(rst.next()){
            Driver driver = new Driver(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
            drivers.add(driver);
        }

        return drivers;
    }

    @Override
    public boolean saveDriver(Driver entity) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        con.setAutoCommit(false); // Start transaction
        PreparedStatement pstm = con.prepareStatement("insert into Driver values(?,?,?,?,?)");
        pstm.setObject(1, entity.getDriverID());
        pstm.setObject(2, entity.getDriverName());
        pstm.setObject(3, entity.getMobileNo());
        pstm.setObject(4, entity.getLicense());
        pstm.setObject(5, entity.getExperienceOfYear());

        if (pstm.executeUpdate()>0){
            return true;
        }else{
            return false;
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
                    rst.getString(5)
            );
        }else{
            return null;
        }
    }

}
