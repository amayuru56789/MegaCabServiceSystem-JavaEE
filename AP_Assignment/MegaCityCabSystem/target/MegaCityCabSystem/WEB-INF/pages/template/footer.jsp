<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/14/2025
  Time: 2:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
<footer class="bg-dark text-white mt-5">
    <div class="container py-4">
        <div class="row">
            <!-- About Section -->
            <div class="col-md-4 mb-4">
                <h5>About MegaCityCab</h5>
                <p class="text-muted">
                    MegaCityCab is your reliable transportation solution, offering seamless cab booking services for both customers and administrators.
                </p>
            </div>

            <!-- Quick Links Section -->
            <div class="col-md-4 mb-4">
                <h5>Quick Links</h5>
                <ul class="list-unstyled">
                    <li><a href="${pageContext.request.contextPath}/index.jsp" class="text-white text-decoration-none"><i class="fas fa-home me-2"></i>Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/customer/register.jsp" class="text-white text-decoration-none"><i class="fas fa-user-plus me-2"></i>Register</a></li>
                    <li><a href="${pageContext.request.contextPath}/auth/login.jsp" class="text-white text-decoration-none"><i class="fas fa-sign-in-alt me-2"></i>Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/contact.jsp" class="text-white text-decoration-none"><i class="fas fa-envelope me-2"></i>Contact Us</a></li>
                </ul>
            </div>

            <!-- Author and Social Media Section -->
            <div class="col-md-4 mb-4">
                <h5>Connect with Us</h5>
                <p class="text-muted">
                    Follow us on social media for updates and promotions.
                </p>
                <div class="social-links">
                    <a href="https://facebook.com" class="text-white me-3" target="_blank"><i class="fab fa-facebook-f"></i></a>
                    <a href="https://twitter.com" class="text-white me-3" target="_blank"><i class="fab fa-twitter"></i></a>
                    <a href="https://instagram.com" class="text-white me-3" target="_blank"><i class="fab fa-instagram"></i></a>
                    <a href="https://linkedin.com" class="text-white me-3" target="_blank"><i class="fab fa-linkedin-in"></i></a>
                </div>
                <p class="text-muted mt-3">
                    <i class="fas fa-user me-2"></i>Author: Amayuru Indeewara
                </p>
            </div>
        </div>

        <!-- Copyright Section -->
        <div class="text-center pt-3 border-top">
            <p class="mb-0">&copy; 2025 MegaCityCab System. All rights reserved.</p>
        </div>
    </div>
</footer>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
