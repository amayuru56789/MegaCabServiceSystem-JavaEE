package lk.icbt.MegaCityCabSystem.dao;

import lk.icbt.MegaCityCabSystem.entity.Booking;
import lk.icbt.MegaCityCabSystem.entity.Cab;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookingDAO {

    ArrayList<Booking> getAllBooking() throws SQLException, ClassNotFoundException;

    boolean addBooking(Booking entity) throws SQLException, ClassNotFoundException;

    boolean updateBooking(Booking entity) throws SQLException, ClassNotFoundException;

    boolean removeBooking(String id) throws SQLException, ClassNotFoundException;

    boolean ifBookingExists(String id) throws SQLException, ClassNotFoundException;

    public Booking searchBooking(String bookID) throws SQLException, ClassNotFoundException;

    public boolean updateBookingStatus(String bookingId, String status) throws ClassNotFoundException, SQLException;
}
