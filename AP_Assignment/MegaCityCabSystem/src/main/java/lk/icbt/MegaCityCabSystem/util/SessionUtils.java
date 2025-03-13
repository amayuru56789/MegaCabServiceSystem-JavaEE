package lk.icbt.MegaCityCabSystem.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    // Set user session attributes after successful login
    public static void setUserSession(HttpServletRequest request, String userName, String userRole, int userId) {
        HttpSession session = request.getSession(true);
        session.setAttribute("userName", userName);
        session.setAttribute("userRole", userRole);
        session.setAttribute("userId", userId);
        session.setMaxInactiveInterval(30 * 60); // Session timeout: 30 minutes
    }

    // Get current logged in user's name
    public static String getUserName(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute("userName");
        }
        return null;
    }

    // Get current logged in user's role
    public static String getUserRole(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute("userRole");
        }
        return null;
    }

    // Get current logged in user's ID
    public static Integer getUserId(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (Integer) session.getAttribute("userId");
        }
        return null;
    }

    // Check if user is logged in
    public static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session != null && session.getAttribute("userName") != null);
    }

    // Check if user is an admin
    public static boolean isAdmin(HttpServletRequest request) {
        return "admin".equals(getUserRole(request));
    }

    // Check if user is a driver
    public static boolean isDriver(HttpServletRequest request) {
        return "driver".equals(getUserRole(request));
    }

    // Invalidate user session (logout)
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
