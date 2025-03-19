package lk.icbt.MegaCityCabSystem.dao.impl;

import lk.icbt.MegaCityCabSystem.dao.BookingDAO;
import lk.icbt.MegaCityCabSystem.db.DbConfiguration;
import lk.icbt.MegaCityCabSystem.dto.BookingCommonDTO;
import lk.icbt.MegaCityCabSystem.dto.CommonDTO;
import lk.icbt.MegaCityCabSystem.entity.Booking;
import lk.icbt.MegaCityCabSystem.entity.Cab;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public ArrayList<Booking> getAllBooking() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Booking");
        ResultSet rst = pstm.executeQuery();
        ArrayList<Booking> bookings = new ArrayList<>();
        while(rst.next()){
            Booking booking = new Booking(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDate(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getDate(12),
                    rst.getString(13),
                    rst.getString(14)
            );
            bookings.add(booking);
        }

        return bookings;
    }

    @Override
    public boolean addBooking(Booking entity) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("insert into Booking values(?,?,?,?,?,?,?,?,?,?,?)");
        pstm.setObject(1, entity.getBookingId());
        pstm.setObject(2, entity.getCustomerId());
        pstm.setObject(3, entity.getCabId());
        pstm.setObject(4, entity.getRegistrationNo());
        pstm.setObject(5, entity.getBookingDate());
        pstm.setObject(6, entity.getDestination());
        pstm.setObject(7, entity.getDestinationDetails());
        pstm.setObject(8, entity.getActivityStatus());
        pstm.setObject(9, entity.getPickupDateTime());
        pstm.setObject(10, entity.getPickupAddress());
        pstm.setObject(11, entity.getDistance());

        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }


    }

    @Override
    public boolean updateBooking(Booking entity) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("update Booking set customerId=?, cabId=?, registrationNo=?, bookingDate=?, destination=?, destinationDetail=?, activityStatus=? where bookingId=?");
        pstm.setObject(1, entity.getCustomerId());
        pstm.setObject(2, entity.getCabId());
        pstm.setObject(3, entity.getRegistrationNo());
        pstm.setObject(4, entity.getBookingDate());
        pstm.setObject(5, entity.getDestination());
        pstm.setObject(6, entity.getDestinationDetails());
        pstm.setObject(7, entity.getActivityStatus());
        pstm.setObject(8, entity.getBookingId());

        if (pstm.executeUpdate()>0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBooking(String id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("delete from Booking where bookingId=?");
        pstm.setObject(1, id);

        if (pstm.executeUpdate() > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean ifBookingExists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Booking searchBooking(String bookID) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/epic", "root", "1234");
        PreparedStatement pstm = con.prepareStatement("select * from Booking where bookingId=?");
        pstm.setObject(1, bookID);
        ResultSet rst = pstm.executeQuery();

        if (rst.next()){
            return new Booking(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDate(5),
                    rst.getString(6),
                    rst.getDate(7),
                    rst.getString(8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getDate(12),
                    rst.getString(13),
                    rst.getString(14)
            );
        }
        return null;
    }

    @Override
    public boolean updateBookingStatus(String bookingId, String status) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "UPDATE Booking SET activityStatus = ? WHERE bookingId = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
             PreparedStatement pstm = con.prepareStatement(query)) {

            // Set parameters
            pstm.setString(1, status);
            pstm.setString(2, bookingId);

            // Execute the update
            int rowsUpdated = pstm.executeUpdate();

            // Return true if at least one row was updated
            return rowsUpdated > 0;
        }
    }


    public List<CommonDTO> getAllCustomerDes() throws ClassNotFoundException, SQLException {
        List<CommonDTO> customerList = new ArrayList<>();
        String query = "SELECT * FROM customer WHERE userId = ?"; // Query with parameter

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setString(1, "2");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
                    String customerId = rs.getString("customerId");
                    String customerName = rs.getString("customerName");
                    String regNo = rs.getString("registrationNo");

                    // Create a CommonDTO object and add it to the list
                    CommonDTO customer = new CommonDTO(customerId, customerName, "--", "--", "--", "--", regNo);
                    customerList.add(customer);
                }

//        try (Connection connection = DbConfiguration.getInstance().getConnection(); // Get singleton connection
//             PreparedStatement pstm = connection.prepareStatement(query)) {
//
//            pstm.setString(1, "2"); // Set the userId parameter
//            try (ResultSet rs = pstm.executeQuery()) {
//                while (rs.next()) {
//                    String customerId = rs.getString("customerId");
//                    String customerName = rs.getString("customerName");
//                    String regNo = rs.getString("registrationNo");
//
//                    // Create a CommonDTO object and add it to the list
//                    CommonDTO customer = new CommonDTO(customerId, customerName, "--", "--", "--", "--", regNo);
//                    customerList.add(customer);
//                }
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            // Log the exception (use a proper logging framework like SLF4J or Log4j)
//            System.err.println("Error fetching customer data: " + e.getMessage());
//            e.printStackTrace();
//        }

        return customerList;

    }

    public List<CommonDTO> getAllCabDes() throws ClassNotFoundException, SQLException {
        List<CommonDTO> cabList = new ArrayList<>();
        String query = "SELECT * FROM cab WHERE availableStatus = 'available' "; // Query with parameter

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        PreparedStatement pstm = con.prepareStatement(query);
//        pstm.setString(1, "2");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String cabId = rs.getString("cabId");
            String cabType = rs.getString("model");
//            String regNo = rs.getString("registrationNo");

            // Create a CommonDTO object and add it to the list
            CommonDTO cab = new CommonDTO("--", "--", cabId, cabType, "--", "--", "");
            cabList.add(cab);
        }

//        try (Connection connection = DbConfiguration.getInstance().getConnection(); // Get singleton connection
//             PreparedStatement pstm = connection.prepareStatement(query)) {
//
//            pstm.setString(1, "2"); // Set the userId parameter
//            try (ResultSet rs = pstm.executeQuery()) {
//                while (rs.next()) {
//                    String customerId = rs.getString("customerId");
//                    String customerName = rs.getString("customerName");
//                    String regNo = rs.getString("registrationNo");
//
//                    // Create a CommonDTO object and add it to the list
//                    CommonDTO customer = new CommonDTO(customerId, customerName, "--", "--", "--", "--", regNo);
//                    customerList.add(customer);
//                }
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            // Log the exception (use a proper logging framework like SLF4J or Log4j)
//            System.err.println("Error fetching customer data: " + e.getMessage());
//            e.printStackTrace();
//        }

        return cabList;

    }

    public BookingCommonDTO getBookingBaseStatus(String driverId) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");
        // Prepare the SQL query to fetch booking details along with customer name
//        String query = "SELECT b.*, c.customerName, c.telephoneNo " +
//                "FROM Booking b " +
//                "JOIN Customer c ON b.customerId = c.customerId " +
//                "WHERE b.activitystatus = ?";
//        String query = "SELECT b.*, c.customerName, c.telephoneNo " +
//                "FROM Booking b " +
//                "JOIN Customer c ON b.customerId = c.customerId " +
//                "WHERE b.driverId = ? AND b.activityStatus IN ('ASSIGNED', 'IN_PROGRESS', 'PICKED_UP') " +
//                "ORDER BY b.pickupDateTime DESC " +
//                "LIMIT 1";
        String query = "SELECT b.*, c.customerName, c.telephoneNo " +
                "FROM Booking b " +
                "JOIN Customer c ON b.customerId = c.customerId " +
                "JOIN Cab cab ON b.cabId = cab.cabId " + // Join the Cab table
                "WHERE cab.driverId = ? AND b.activityStatus IN ('ASSIGNED', 'IN_PROGRESS', 'PICKED_UP') " +
                "ORDER BY b.pickupDateTime DESC " +
                "LIMIT 1";

        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, driverId); // Set the booking ID parameter

            // Execute the query
            try (ResultSet rst = pstm.executeQuery()) {
                if (rst.next()) {
                    // Create and return a Booking object with the fetched data
                    return new BookingCommonDTO(
                            rst.getString("bookingId"),
                            rst.getString("customerId"),
                            rst.getString("customerName"), // Fetch customer name
                            rst.getString("telephoneNo"),
                            rst.getString("destination"),
                            rst.getString("destinationDetail"),
                            rst.getString("activityStatus"),
                            rst.getDate("pickupDateTime"),
                            rst.getString("pickupAddress"),
                            rst.getString("distance")
                    );
                }
            }
        }
        return null;
    }

    public List<BookingCommonDTO> getAllBookingList(String status) throws SQLException, ClassNotFoundException {

        List<BookingCommonDTO> bookings = new ArrayList<>();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cabservicedb", "root", "1234");

        String query = "SELECT b.*, c.customerName, c.telephoneNo " +
                "FROM Booking b " +
                "JOIN Customer c ON b.customerId = c.customerId " +
                "WHERE b.activitystatus = ?";

        try (PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, status); // Set the status parameter

            // Execute the query
            try (ResultSet rst = pstm.executeQuery()) {
                // Iterate through the ResultSet to fetch all matching records
                while (rst.next()) {
                    // Create a BookingCommonDTO object for each record
                    BookingCommonDTO booking = new BookingCommonDTO(
                            rst.getString("bookingId"),
                            rst.getString("customerId"),
                            rst.getString("customerName"), // Fetch customer name
                            rst.getString("telephoneNo"),
                            rst.getString("destination"),
                            rst.getString("destinationDetail"),
                            rst.getString("activityStatus"),
                            rst.getDate("pickupDateTime"),
                            rst.getString("pickupAddress"),
                            rst.getString("distance")
                    );
                    // Add the booking to the list
                    bookings.add(booking);
                }
            }
        }
        return bookings;

    }
}
