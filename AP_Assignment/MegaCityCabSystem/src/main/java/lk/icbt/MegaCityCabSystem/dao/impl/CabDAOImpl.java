package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.CabDAO;
import lk.icbt.MegaCityCabSystem.db.DbConfiguration;
import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CabDAOImpl implements CabDAO {

    @Override
    public ArrayList<Cab> getAllCab() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Cab");

        ResultSet rst = pstm.executeQuery();

        ArrayList<Cab> cabs = new ArrayList<>();
        while(rst.next()){
            Cab cab = new Cab(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    "empty",
                    rst.getBytes(8),
                    rst.getString(7)
            );
            cabs.add(cab);
        }

        return cabs;
    }

    @Override
//    public boolean saveCab(Cab entity) throws SQLException, ClassNotFoundException {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
//        con.setAutoCommit(false); // Start transaction
//        PreparedStatement pstm = con.prepareStatement("insert into Cab values(?,?,?,?,?,?,?)");
//        pstm.setObject(1, entity.getCabID());
//        pstm.setObject(2, entity.getModel());
//        pstm.setObject(3, entity.getMileage());
//        pstm.setObject(4, entity.getAvailableStatus());
//        pstm.setObject(5, entity.getPrice());
//        pstm.setObject(6, entity.getCapacity());
//        pstm.setObject(7, entity.getImgByte());
//
//        if (pstm.executeUpdate()>0){
//            return true;
//        }else{
//            return false;
//        }
//    }
    public boolean saveCab(Cab entity) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        String query = "INSERT INTO cab (cabId, model, milage, availablestatus, price, capacity, image, driverId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstm = con.prepareStatement(query);

            pstm.setString(1, entity.getCabID());
            pstm.setString(2, entity.getModel());
            pstm.setString(3, entity.getMileage());
            pstm.setString(4, entity.getAvailableStatus());
            pstm.setDouble(5, entity.getPrice());
            pstm.setString(6, entity.getCapacity());
            pstm.setBytes(7, entity.getImgByte()); // Set image as BLOB
            pstm.setString(8, entity.getDriverId());

            int rowsAffected = pstm.executeUpdate();
            return rowsAffected > 0 ? true : false;

    }

    @Override
    public boolean updateCab(Cab entity) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");

        PreparedStatement pstm = con.prepareStatement("update Cab set model=?, milage=?, availbleStatus=?, price=?, capacity=? where cabId=?");
        pstm.setObject(1, entity.getModel());
        pstm.setObject(2, entity.getMileage());
        pstm.setObject(3, entity.getAvailableStatus());
        pstm.setObject(4, entity.getPrice());
        pstm.setObject(5, entity.getCapacity());
        pstm.setObject(6, entity.getCabID());

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteCab(String id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("delete from Cab where cabId=?");
        pstm.setObject(1, id);

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean ifCabExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Cab searchCab(String cabID) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Cab where cabId=?");
        pstm.setObject(1, cabID);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Cab(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    "empty",
                    rst.getBytes(7),
                    rst.getString(8)
            );
        }else{
            return null;
        }
    }
}
