package lk.icbt.MegaCityCabSystem.controller;

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

@WebServlet("/report/report-summery")
public class ReportPageServlet extends HttpServlet {

    BookingDAOImpl bookingDAO = new BookingDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            // Retrieve the date range parameters from the request
            String dateFrom = req.getParameter("dateFrom");
            String dateTo = req.getParameter("dateTo");

            // Convert the date strings to java.sql.Date
            java.sql.Date sqlDateFrom = null;
            java.sql.Date sqlDateTo = null;

            if (dateFrom != null && !dateFrom.isEmpty()) {
                sqlDateFrom = java.sql.Date.valueOf(dateFrom);
            }
            if (dateTo != null && !dateTo.isEmpty()) {
                sqlDateTo = java.sql.Date.valueOf(dateTo);
            }

            List<BookingCommonDTO> searchBookingList = bookingDAO.getAllSearchBookingList(sqlDateFrom, sqlDateTo);
            req.setAttribute("bookingDetails", searchBookingList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/report/report-summery.jsp");
            dispatcher.forward(req, resp);

            String path = req.getPathInfo();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions (e.g., log the error or show an error page)
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request.");
        }


    }
}
