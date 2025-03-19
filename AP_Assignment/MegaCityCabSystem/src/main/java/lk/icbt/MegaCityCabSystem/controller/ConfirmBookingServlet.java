package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.dao.BookingDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/driver/confirmBooking")
public class ConfirmBookingServlet extends HttpServlet {

    private BookingDAO bookingDAO;

    @Override
    public void init() {
        // Initialize the DAO
        bookingDAO = new BookingDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Get the booking ID from the request
        String bookingId = req.getParameter("id");

        if (bookingId != null) {
            try {
                // Update the booking status to ASSIGNED
                boolean isUpdated = bookingDAO.updateBookingStatus(bookingId, "ASSIGNED");

                if (isUpdated) {
                    // Redirect to the driver dashboard with a success message
                    resp.sendRedirect(req.getContextPath() + "/driver/dashboard?message=BookingConfirmed");
                } else {
                    // Redirect with an error message
                    resp.sendRedirect(req.getContextPath() + "/driver/dashboard?error=UpdateFailed");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/driver/dashboard?error=DatabaseError");
            }
        } else {
            // Redirect with an error message if booking ID is missing
            resp.sendRedirect(req.getContextPath() + "/driver/dashboard?error=InvalidBookingId");
        }
    }
}
