package lk.icbt.MegaCityCabSystem.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/register")
public class RegistrationPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the login.jsp page inside WEB-INF/auth
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/customer/registration.jsp");
        dispatcher.forward(req, resp);

        String path = req.getPathInfo();
    }
}
