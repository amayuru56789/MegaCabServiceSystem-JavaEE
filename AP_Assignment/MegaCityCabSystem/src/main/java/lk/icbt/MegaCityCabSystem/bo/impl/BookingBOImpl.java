package lk.icbt.MegaCityCabSystem.bo.impl;

import lk.icbt.MegaCityCabSystem.bo.BookingBO;
import lk.icbt.MegaCityCabSystem.dao.BookingDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingDTO;
import lk.icbt.MegaCityCabSystem.dto.CustomerDTO;
import lk.icbt.MegaCityCabSystem.entity.Booking;
import lk.icbt.MegaCityCabSystem.entity.Customer;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import static lk.icbt.MegaCityCabSystem.bo.impl.CustomerBOImpl.getCurrentFormattedTime;

public class BookingBOImpl implements BookingBO {

    BookingDAO bookingDAO = new BookingDAOImpl();

    @Override
    public ArrayList<BookingDTO> getAllBooking() {

        try {

            return bookingDAO.getAllBooking().stream()
                    .map(booking -> new BookingDTO(
                            booking.getBookingId(),
                            booking.getCustomerId(),
                            booking.getCabId(),
                            booking.getRegistrationNo(),
                            booking.getBookingDate(),
                            booking.getBookingTime(),
                            booking.getLastUpdatedDate(),
                            booking.getLastUpdatedTime(),
                            booking.getDestination(),
                            booking.getDestinationDetails(),
                            booking.getActivityStatus()
                    ))
                    .collect(Collectors.toCollection(ArrayList::new));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addBooking(BookingDTO bookingDTO) {

        try {

            LocalTime time = getCurrentFormattedTime();
            Date date = new Date();  // Get current date
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = formatter.format(date);

            bookingDTO.setBookingDate(new Date());
            bookingDTO.setBookingTime(time.toString());
            bookingDTO.setLastUpdatedTime(time.toString());

            return bookingDAO.addBooking(new Booking(
                    bookingDTO.getBookingId(),
                    bookingDTO.getCustomerId(),
                    bookingDTO.getCabId(),
                    bookingDTO.getRegistrationNo(),
                    bookingDTO.getBookingDate(),
                    bookingDTO.getBookingTime(),
                    bookingDTO.getLastUpdatedDate(),
                    bookingDTO.getLastUpdatedTime(),
                    bookingDTO.getDestination(),
                    bookingDTO.getDestinationDetails(),
                    bookingDTO.getActivityStatus()

            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBooking(BookingDTO bookingDTO) {
        try {

            LocalTime time = getCurrentFormattedTime();
            bookingDTO.setLastUpdatedDate(new Date());
            bookingDTO.setLastUpdatedTime(time.toString());

            return bookingDAO.updateBooking(new Booking(
                    bookingDTO.getBookingId(),
                    bookingDTO.getCustomerId(),
                    bookingDTO.getCabId(),
                    bookingDTO.getRegistrationNo(),
                    bookingDTO.getBookingDate(),
                    bookingDTO.getBookingTime(),
                    bookingDTO.getLastUpdatedDate(),
                    bookingDTO.getLastUpdatedTime(),
                    bookingDTO.getDestination(),
                    bookingDTO.getDestinationDetails(),
                    bookingDTO.getActivityStatus()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeBooking(String id) {

        try {
            return bookingDAO.removeBooking(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean ifBookExists(String id) {
        return false;
    }

    @Override
    public BookingDTO searchBooking(String bookID) {
        try {

            Booking searchBooking = bookingDAO.searchBooking(bookID);

            if (searchBooking != null){

                return new BookingDTO(
                        searchBooking.getBookingId(),
                        searchBooking.getCustomerId(),
                        searchBooking.getCabId(),
                        searchBooking.getRegistrationNo(),
                        searchBooking.getBookingDate(),
                        searchBooking.getBookingTime(),
                        searchBooking.getLastUpdatedDate(),
                        searchBooking.getLastUpdatedTime(),
                        searchBooking.getDestination(),
                        searchBooking.getDestinationDetails(),
                        searchBooking.getActivityStatus()
                );

            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new BookingDTO();
    }
}
