package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.CustomerBO;
import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.CustomerDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean registrationCustomer(CustomerDTO customerDTO) {
        try {
            return customerDAO.saveCustomer(new Customer(
                    customerDTO.getCustomerId(),
                    customerDTO.getCustomerName(),
                    customerDTO.getAddress(),
                    customerDTO.getNic(),
                    customerDTO.getEmail(),
                    customerDTO.getTelephoneNo(),
                    customerDTO.getRegistrationNo(),
                    customerDTO.getRegistrationDate()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
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
