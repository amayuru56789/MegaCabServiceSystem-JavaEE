package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.dao.BookingDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/driver/bookings/updateStatus")
public class UpdateBookingStatusServlet extends HttpServlet {

    private BookingDAO bookingDAO;

    @Override
    public void init() {
        // Initialize the DAO
        bookingDAO = new BookingDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String bookingId = req.getParameter("id");
        String newStatus = req.getParameter("status");

        if (bookingId != null && newStatus != null) {
        try {
            // Update the booking status
            boolean isUpdated = bookingDAO.updateBookingStatus(bookingId, newStatus);

            if (isUpdated) {
                // Redirect to the driver dashboard with a success message
                resp.sendRedirect(req.getContextPath() + "/driver/dashboard?message=StatusUpdated");
            } else {
                // Redirect with an error message
                resp.sendRedirect(req.getContextPath() + "/driver/dashboard?error=UpdateFailed");
            }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                resp.sendRedirect(req.getContextPath() + "/driver/dashboard?error=DatabaseError");
            }
        } else {
            // Redirect with an error message if parameters are missing
            resp.sendRedirect(req.getContextPath() + "/driver/dashboard?error=InvalidParameters");
        }
    }

}
