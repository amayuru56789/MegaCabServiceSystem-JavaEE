package lk.icbt.MegaCityCabSystem.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer-form")
public class CustomerPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the login.jsp page inside WEB-INF/auth
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/customer/dashboard.jsp");
        dispatcher.forward(req, resp);

        String path = req.getPathInfo(); // Get the path after "/customer/"

//        switch (path) {
//            case "/dashboard":
//                req.getRequestDispatcher("/WEB-INF/pages/customer/dashboard.jsp").forward(req, resp);
//                break;
//            case "/available-cabs":
//                req.getRequestDispatcher("/WEB-INF/pages/customer/available-cabs.jsp").forward(req, resp);
//                break;
//            case "/book-cab":
//                req.getRequestDispatcher("/WEB-INF/pages/customer/book-cab.jsp").forward(req, resp);
//                break;
//            default:
//                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
//                break;
//        }

    }
}
