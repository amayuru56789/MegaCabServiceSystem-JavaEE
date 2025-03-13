package lk.icbt.MegaCityCabSystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin/*"})
public class AdminAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Check if user is an admin
        boolean isAdmin = (session != null && "admin".equals(session.getAttribute("userRole")));

        if (isAdmin) {
            // User is an admin, allow access
            chain.doFilter(request, response);
        } else {
            // Not an admin, redirect to unauthorized page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/unauthorized.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
