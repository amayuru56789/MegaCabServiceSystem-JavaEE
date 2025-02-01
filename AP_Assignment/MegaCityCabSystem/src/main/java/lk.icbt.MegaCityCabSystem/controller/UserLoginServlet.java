package lk.icbt.MegaCityCabSystem.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Login")
public class UserLoginServlet extends HttpServlet {

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //        super.doPost(req, resp);

            // Set response type to JSON
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            // Get user credentials from request
            String username = req.getParameter("username");
            String password = req.getParameter("password");

        // Create response JSON
        PrintWriter out = resp.getWriter();
        if ("admin".equals(username) && "password123".equals(password)) {
            out.print("{\"status\": \"success\", \"message\": \"Login successful\"}");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            out.print("{\"status\": \"error\", \"message\": \"Invalid credentials\"}");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        out.flush();
    }
}
