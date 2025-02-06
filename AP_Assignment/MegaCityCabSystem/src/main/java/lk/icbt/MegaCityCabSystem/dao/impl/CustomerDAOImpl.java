package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveCustomer(Customer entity) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("insert into Customer values(?,?,?,?,?,?)");
        pstm.setObject(1, entity.getCustomerId());
        pstm.setObject(2, entity.getCustomerName());
        pstm.setObject(3, entity.getAddress());
        pstm.setObject(4, entity.getEmail());
        pstm.setObject(5, entity.getTelephoneNo());
        pstm.setObject(6, entity.getNic());
//        pstm.setObject(7, formatDateTime);
//        pstm.setObject(8, "");
        if (pstm.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifCustomerExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String userID) {
        return null;
    }
}
