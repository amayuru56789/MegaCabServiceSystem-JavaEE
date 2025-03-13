package lk.icbt.MegaCityCabSystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin/*", "/driver/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String requestURI  = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();

        // Check if user is logged in
        boolean isLoggedIn = (session != null && session.getAttribute("userName") != null);
//        boolean isLoginPage = requestURI.contains("login.jsp") || requestURI.contains("/login");
        boolean isLoginPage = requestURI.endsWith("login.jsp") || requestURI.endsWith("/login");
        boolean isIndexPage = requestURI.equals(contextPath + "/") || requestURI.equals(contextPath + "/index.jsp");
//        boolean isResourceRequest = requestURI.contains("/assets/");
        boolean isResourceRequest = requestURI.matches(".*(css|js|png|jpg|jpeg|gif|woff|ttf|svg|ico)$");

        // For debugging
        System.out.println("Request URI: " + requestURI);
        System.out.println("Is logged in: " + isLoggedIn);
        System.out.println("Is login page: " + isLoginPage);
        System.out.println("Is index page: " + isIndexPage);

        if (isResourceRequest) {
            // Allow access to resources (CSS, JS, images)
            chain.doFilter(request, response);
            return;
        }

        // Allow access to public pages without login
        if (!isLoggedIn && (isLoginPage || isIndexPage)) {
            chain.doFilter(request, response);
            return;
        }

        // Check if user is logged in
        if (!isLoggedIn && !isLoginPage) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        if (isLoggedIn) {
            // User is logged in, check role-based access
            String userRole = (String) session.getAttribute("userRole");

            if (requestURI.contains("/admin/") && !"admin".equals(userRole)) {
                // Unauthorized access to admin area
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/unauthorized.jsp");
                return;
            }

            if (requestURI.contains("/driver/") && !"driver".equals(userRole)) {
                // Unauthorized access to driver area
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/unauthorized.jsp");
                return;
            }

            // User has appropriate access, continue the filter chain
            chain.doFilter(request, response);
        } else {
            // User is not logged in
            if (isLoginPage) {
                // Allow access to login page
                chain.doFilter(request, response);
            } else {
                // Redirect to login page
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
