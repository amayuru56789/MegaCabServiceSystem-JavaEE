package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.dao.BookingDAO;
import lk.icbt.MegaCityCabSystem.dao.CustomerDAO;
import lk.icbt.MegaCityCabSystem.dao.impl.BookingDAOImpl;
import lk.icbt.MegaCityCabSystem.dto.CommonDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer/book-cab")
public class BookingPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the login.jsp page inside WEB-INF/auth
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/customer/booking-form.jsp");
//        dispatcher.forward(req, resp);
//
//        String path = req.getPathInfo();

        try {
            // Fetch customer data from the database
            BookingDAOImpl dao = new BookingDAOImpl();
            List<CommonDTO> customers = dao.getAllCustomerDes();
            List<CommonDTO> cabs = dao.getAllCabDes();


            // Set customer data as a request attribute
            req.setAttribute("customers", customers);
            req.setAttribute("cabs", cabs);

            // Forward to the JSP page
            req.getRequestDispatcher("/WEB-INF/pages/customer/booking-form.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while fetching customer data.");
        }
    }
}
