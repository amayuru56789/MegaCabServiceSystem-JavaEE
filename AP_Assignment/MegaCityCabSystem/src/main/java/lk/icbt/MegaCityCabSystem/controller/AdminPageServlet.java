package lk.icbt.MegaCityCabSystem.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin-form")
public class AdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to the login.jsp page inside WEB-INF/auth
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/admin/dashboard-form.jsp");
        dispatcher.forward(req, resp);

        String path = req.getPathInfo();
    }
}
