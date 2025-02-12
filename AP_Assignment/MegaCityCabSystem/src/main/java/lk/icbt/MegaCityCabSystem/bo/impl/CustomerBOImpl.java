package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.CustomerBO;
import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.CustomerDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {

        ArrayList<Customer> all = null;
        try {
            all = customerDAO.getAllCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : all) {
            customerDTOS.add(
                    new CustomerDTO(
                            customer.getCustomerId(),
                            customer.getCustomerName(),
                            customer.getAddress(),
                            customer.getNic(),
                            customer.getEmail(),
                            customer.getTelephoneNo(),
                            customer.getUserName(),
                            customer.getPassword(),
                            customer.getRegistrationNo(),
                            customer.getRegistrationDate(),
                            customer.getRegistrationTime(),
                            customer.getUpdatedDate(),
                            customer.getUpdatedTime()
                    )
            );
        }
        return customerDTOS;
    }

    @Override
    public boolean registrationCustomer(CustomerDTO customerDTO) {

        try {

            String registrationNo = this.generateHybridRegistrationNo();
            LocalTime time = getCurrentFormattedTime();
            Date date = new Date();  // Get current date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = formatter.format(date);

            customerDTO.setRegistrationNo(registrationNo);
            customerDTO.setRegistrationDate(new Date());
            customerDTO.setRegistrationTime(time);
            customerDTO.setUpdatedTime(time);

            return customerDAO.saveCustomer(new Customer(
                    customerDTO.getCustomerId(),
                    customerDTO.getCustomerName(),
                    customerDTO.getAddress(),
                    customerDTO.getNic(),
                    customerDTO.getEmail(),
                    customerDTO.getTelephoneNo(),
                    customerDTO.getUserName(),
                    customerDTO.getPassword(),
                    customerDTO.getRegistrationNo(),
                    customerDTO.getRegistrationDate(),
                    customerDTO.getRegistrationTime(),
                    new Date(),
                    customerDTO.getUpdatedTime()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO)  {
        try {

            LocalTime time = getCurrentFormattedTime();
            customerDTO.setUpdatedDate(new Date());
            customerDTO.setUpdatedTime(time);

            return customerDAO.updateCustomer(new Customer(
                    customerDTO.getCustomerId(),
                    customerDTO.getCustomerName(),
                    customerDTO.getAddress(),
                    customerDTO.getNic(),
                    customerDTO.getEmail(),
                    customerDTO.getTelephoneNo(),
                    customerDTO.getUserName(),
                    customerDTO.getPassword(),
                    customerDTO.getRegistrationNo(),
                    customerDTO.getRegistrationDate(),
                    customerDTO.getRegistrationTime(),
                    customerDTO.getUpdatedDate(),
                    customerDTO.getUpdatedTime()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {

        try {
            return customerDAO.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean ifCustomerExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String userID) {

        try {

            Customer searchCustomer = customerDAO.searchCustomer(userID);
            if (searchCustomer != null){

                return new CustomerDTO(
                        searchCustomer.getCustomerId(),
                        searchCustomer.getCustomerName(),
                        searchCustomer.getAddress(),
                        searchCustomer.getNic(),
                        searchCustomer.getEmail(),
                        searchCustomer.getTelephoneNo(),
                        searchCustomer.getUserName(),
                        searchCustomer.getPassword(),
                        searchCustomer.getRegistrationNo(),
                        searchCustomer.getRegistrationDate(),
                        searchCustomer.getRegistrationTime(),
                        searchCustomer.getUpdatedDate(),
                        searchCustomer.getUpdatedTime()
                );

            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       return new CustomerDTO();
    }

    public String generateHybridRegistrationNo() throws SQLException {

        Integer count = customerDAO.getCustomerCountForGenerateRegNo();

        String randomSuffix = UUID.randomUUID().toString().substring(0, 3).toUpperCase();
        return "R" + String.format("%03d", count) + randomSuffix; // Example: "R005A2F"
    }

    public static LocalTime getCurrentFormattedTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Format as HH:mm:ss
        String formattedTime = now.format(formatter);
        return LocalTime.parse(formattedTime, formatter); // Convert back to LocalTime
    }
}
