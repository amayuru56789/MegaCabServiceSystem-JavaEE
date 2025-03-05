package lk.icbt.MegaCityCabSystem.bo;

import lk.icbt.MegaCityCabSystem.dto.BookingDTO;
import lk.icbt.MegaCityCabSystem.dto.CabDTO;

import java.util.ArrayList;

public interface BookingBO {

    ArrayList<BookingDTO> getAllBooking();

    boolean addBooking (BookingDTO bookingDTO);

    boolean updateBooking(BookingDTO bookingDTO);

    boolean removeBooking(String id);

    boolean ifBookExists(String id);

    public BookingDTO searchBooking(String bookID);
}
