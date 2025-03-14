package lk.icbt.MegaCityCabSystem.controller;

import lk.icbt.MegaCityCabSystem.UserBO;
import lk.icbt.MegaCityCabSystem.impl.UserBOImpl;
import lk.icbt.MegaCityCabSystem.util.SessionUtils;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {

    UserBO userBO = new UserBOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log("user login print msg");

        // Check if it's a JSON request or form submission
        String contentType = req.getContentType();

        if (contentType != null && contentType.contains("application/json")) {
            // Handle JSON request (for API/AJAX calls)
            handleJsonRequest(req, resp, userBO);
        } else {
            // Handle form submission (for JSP form)
            handleFormSubmission(req, resp, userBO);
        }


    }

    private void handleJsonRequest(HttpServletRequest req, HttpServletResponse resp, UserBO userBO)
            throws IOException {

        resp.setContentType("application/json");
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject obj = reader.readObject();
        PrintWriter writer = resp.getWriter();

        String userName = obj.getString("userName");
        String password = obj.getString("password");

        boolean equal = userBO.equalityUser(userName, password);

        if (equal){
            // Get user role and ID (you'll need to modify UserBO to get these)
            String userRole = getUserRole(userName); // Implement this method
            int userId = getUserId(userName); // Implement this method

            // Set user session
            SessionUtils.setUserSession(req, userName, userRole, userId);

            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 200);
            response.add("message", "Welcome " +userName+ "! You have successfully logged in.");
            response.add("userRole", userRole);
            response.add("redirectUrl", getRedirectUrl(userRole, req.getContextPath()));
            writer.print(response.build());
        }else{
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 400);
            response.add("message", "Invalid credentials! Please check your username and password.");
            response.add("data", JsonValue.NULL);
            writer.print(response.build());
        }
    }

    private void handleFormSubmission(HttpServletRequest req, HttpServletResponse resp, UserBO userBO)
            throws IOException, ServletException {

        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role"); // From the form select dropdown

        // You'll need to extend your UserBO to validate both username/password and role
        boolean isValid = userBO.equalityUser(userName, password);
        // Also check if the user has the claimed role
        boolean hasRole = validateUserRole(userName, role); // Implement this method

        if (isValid && hasRole) {
            // Get user ID (you'll need to modify UserBO to get this)
            int userId = getUserId(userName); // Implement this method

            // Set user session
            SessionUtils.setUserSession(req, userName, role, userId);

            // Redirect based on role
            resp.sendRedirect(getRedirectUrl(role, req.getContextPath()));
        } else {
            req.setAttribute("error", "Invalid credentials or unauthorized role access!");
            req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
        }
    }

    private String getUserRole(String userName) {
        // Implement this to get user role from your database
        // For example: return userDAO.findRoleByUsername(userName);

        // Sample implementation for demo purposes
//        if (userName.startsWith("admin")) {
//            return "admin";
//        } else if (userName.startsWith("driver")) {
//            return "driver";
//        } else {
//            return "customer";
//        }
        String roleByUsername = userBO.findRoleByUsername(userName);
        return roleByUsername;
    }

    private int getUserId(String userName) {
        // Implement this to get user ID from your database
        // For example: return userDAO.findIdByUsername(userName);

//        // Sample implementation for demo purposes
//        return 1; // Dummy ID

        return userBO.findIdByUsername(userName);
    }

    private boolean validateUserRole(String userName, String claimedRole) {
        // Implement this to validate if the user has the claimed role
        String actualRole = getUserRole(userName);
        return actualRole.equals(claimedRole);
    }

    private String getRedirectUrl(String userRole, String contextPath) {
        switch (userRole) {
            case "admin":
                return contextPath + "/admin-form";
            case "driver":
                return contextPath + "/driver/dashboard.jsp";
            case "customer":
                return contextPath + "/customer-form";
            default:
                return contextPath + "/index.jsp";
        }
    }
}
