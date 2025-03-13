package lk.icbt.MegaCityCabSystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/auth/login")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the login.jsp page inside WEB-INF/auth
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/auth/login.jsp");
        dispatcher.forward(req, resp);
    }
}
