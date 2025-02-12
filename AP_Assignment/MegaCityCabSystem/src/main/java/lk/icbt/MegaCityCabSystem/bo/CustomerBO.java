package lk.icbt.MegaCityCabSystem.bo;

import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {

    ArrayList<CustomerDTO> getAllCustomer();

    boolean registrationCustomer (CustomerDTO customerDTO);

    boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean ifCustomerExists(String id) throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer(String userID);

}
