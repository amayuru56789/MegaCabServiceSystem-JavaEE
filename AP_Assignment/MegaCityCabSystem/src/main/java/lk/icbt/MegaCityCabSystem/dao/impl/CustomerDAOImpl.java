package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import javax.servlet.Registration;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Customer");

        ResultSet rst = pstm.executeQuery();
        //System.out.println(rst.getObject(1));
        ArrayList<Customer> customers = new ArrayList<>();
        while(rst.next()){
            Customer customer = new Customer(
                    rst.getString(1),
                    rst.getString(2),

                    rst.getString(3),
                    rst.getString(6),
                    rst.getString(4),
                    rst.getString(5),

                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getDate(10),
                    null,
                    rst.getDate(11),
                    null
            );
            customers.add(customer);
        }

        return customers;
    }

    @Override
    public boolean saveCustomer(Customer entity) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        con.setAutoCommit(false); // Start transaction
        PreparedStatement pstm = con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?,?,?,?,?)");
        pstm.setObject(1, entity.getCustomerId());
        pstm.setObject(2, entity.getCustomerName());
        pstm.setObject(3, entity.getAddress());
        pstm.setObject(4, entity.getEmail());
        pstm.setObject(5, entity.getTelephoneNo());
        pstm.setObject(6, entity.getNic());
        pstm.setObject(7, entity.getRegistrationNo());
        pstm.setObject(8, entity.getRegistrationDate());
        pstm.setObject(9, entity.getUpdatedDate());
        pstm.setObject(10, entity.getRegistrationTime());
        pstm.setObject(11, entity.getUpdatedTime());

        // Insert into User table for login authentication
        String userQuery = "INSERT INTO User (userName, password) VALUES (?, ?)";
        PreparedStatement userPstm = con.prepareStatement(userQuery);
        userPstm.setObject(1, entity.getUserName()); // Customer ID as username
        userPstm.setObject(2, entity.getPassword()); // Set a default password
//        userPstm.setObject(3, "CUSTOMER"); // Assign customer role
        int i = userPstm.executeUpdate();

//        pstm.setObject(7, formatDateTime);
//        pstm.setObject(8, "");
        if (pstm.executeUpdate()>0 && i>0){
            con.commit(); // Commit transaction
            return true;
        }else{
            con.rollback(); // Rollback if any insert fails
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer entity) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
//        LocalDateTime time = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String lastDateTime = time.format(format);
        //String passwordEncrypt = en.encrypt(registration.getPassword());
        PreparedStatement pstm = con.prepareStatement("update Customer set customerName=?, address=?, email=?, telephoneNo=?, nicNo=?, updatedDate=?, updatedTime=? where customerId=?");
        pstm.setObject(1, entity.getCustomerName());
        pstm.setObject(2, entity.getAddress());
        pstm.setObject(3, entity.getEmail());
        pstm.setObject(4, entity.getTelephoneNo());
        pstm.setObject(5, entity.getNic());
//        pstm.setObject(6, entity.getRegistrationDate());
        pstm.setObject(6, entity.getUpdatedDate());
//        pstm.setObject(8, entity.getRegistrationTime());
        pstm.setObject(7, entity.getUpdatedTime());
        pstm.setObject(8, entity.getCustomerId());

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("delete from Customer where customerId=?");
        pstm.setObject(1, id);

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean ifCustomerExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer searchCustomer(String userID) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Customer where customerId=?");
        pstm.setObject(1, userID);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    "null",
                    "null",
                    rst.getString(7),
                    rst.getDate(8),
//                    rst.getTime(10),
                    null,
                    rst.getDate(9),
//                    rst.getTime(11)
                    null
            );
        }else{
            return null;
        }
    }

//    @Override
//    public Integer getCustomerCountForGenerateRegNo() throws SQLException {
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
//
//        String query = "SELECT COUNT(*) FROM Customer";
//        PreparedStatement pstm = con.prepareStatement(query);
//        ResultSet rs = pstm.executeQuery();
//
//        int count = 1;
//        if (rs.next()) {
//            count = rs.getInt(1) + 1;
//        }
//        return count;
//    }
public Integer getCustomerCountForGenerateRegNo() throws SQLException {
    Connection con = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    int count = 1;  // Default value if table is empty

    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");

        String query = "SELECT COUNT(*) FROM Customer";
        pstm = con.prepareStatement(query);
        rs = pstm.executeQuery();

        if (rs.next()) {
            count = rs.getInt(1) + 1;  // Increment the count for new registration number
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print error details for debugging
    } finally {
        // Close resources to prevent memory leaks
        if (rs != null) try { rs.close(); } catch (SQLException ignored) {}
        if (pstm != null) try { pstm.close(); } catch (SQLException ignored) {}
        if (con != null) try { con.close(); } catch (SQLException ignored) {}
    }

    return count;
}

}
