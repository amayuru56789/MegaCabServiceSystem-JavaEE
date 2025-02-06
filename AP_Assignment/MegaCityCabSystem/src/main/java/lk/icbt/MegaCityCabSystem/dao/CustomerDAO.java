package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {

    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    boolean saveCustomer(Customer entity) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(Customer entity) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    boolean ifCustomerExists(String id) throws SQLException, ClassNotFoundException;
    public CustomerDTO searchCustomer(String userID);
}
