package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingCommonDTO;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/bookings/generateBill")
public class GenerateBillPageServlet extends HttpServlet {

    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("application/json");
//
//        String bookingNumber = req.getParameter("bookingNumber");
//
//        try {
//
//            BookingCommonDTO booking = bookingDAO.getBookingDetailsBaseBookId(bookingNumber);
//
//            if (booking != null) {
//                // Convert booking details to JSON
//                JsonObject jsonResponse = Json.createObjectBuilder()
//                        .add("customerName", booking.getCustomerName())
////                        .add("distance", booking.getDistance())
////                        .add("ratePerKm", booking.getRatePerKm())
////                        .add("waitingTime", booking.getWaitingTime())
////                        .add("waitingCharge", booking.getWaitingCharge())
////                        .add("additionalCharges", booking.getAdditionalCharges())
////                        .add("discount", booking.getDiscount())
//                        .build();
//
//                // Send JSON response
//                resp.getWriter().write(jsonResponse.toString());
//            } else {
//                // Send empty response if no booking is found
//                resp.getWriter().write("{}");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/admin/bill.jsp");
        dispatcher.forward(req, resp);

        String path = req.getPathInfo();
    }
}
