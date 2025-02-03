package lk.icbt.MegaCityCabSystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") // This maps the servlet to /hello
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); // Set response content type
        PrintWriter out = response.getWriter(); // Get response writer
        out.println("<html><body>");
        out.println("<h2>Hello, Welcome to JavaEE Servlet avc!</h2>");
        out.println("</body></html>");
    }
}
