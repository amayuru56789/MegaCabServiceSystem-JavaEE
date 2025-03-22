package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.bo.DriverBO;
import lk.icbt.MegaCityCabSystem.bo.impl.DriverBOImpl;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.BookingCommonDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/driver/dashboard")
public class DriverDashboardPageServlet extends HttpServlet {

    DriverBO driverBO = new DriverBOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookingDAOImpl bookingDAO = new BookingDAOImpl();

        String userId = (String) req.getSession().getAttribute("userId");
        String userName = (String) req.getSession().getAttribute("userName");

        String driverId = driverBO.driverFindByUserName(userName);

        System.out.println("user ID "+userId+" print driver id "+driverId);
        String driverStatus = driverBO.getDriverStatus("3");
        try {
            BookingCommonDTO commonDTO = bookingDAO.getBookingBaseStatus(userId);
            List<BookingCommonDTO> allBookingList = bookingDAO.getAllBookingList("pending");


            req.setAttribute("driverStatus", driverStatus);
            req.setAttribute("currentBooking", commonDTO);
            req.setAttribute("upcomingBookings", allBookingList);

            // Forward the request to the login.jsp page inside WEB-INF/auth
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/driver/dashboard.jsp");
            dispatcher.forward(req, resp);

            String path = req.getPathInfo();
//        try {
//
////            String driverStatus = driverBO.getDriverStatus("3");
////            req.setAttribute("driverStatus", driverStatus);
//
//            req.getRequestDispatcher("/WEB-INF/pages/driver/dashboard.jsp");
//        } catch (Exception e) {
//            e.printStackTrace();
//            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while fetching customer data.");
//        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
