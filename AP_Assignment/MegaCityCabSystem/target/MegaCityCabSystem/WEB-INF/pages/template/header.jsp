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
    <meta charset="UTF-8">
    <title>MegaCityCab System</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header class="bg-primary text-white p-3">
    <div class="container">
        <div class="d-flex justify-content-between align-items-center">
            <!-- Logo -->
            <div class="logo">
                <h1 class="m-0"><i class="fas fa-taxi"></i> MegaCityCab System</h1>
            </div>
            <!-- Navigation -->
            <nav>
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/index.jsp">
                            <i class="fas fa-home"></i> Home
                        </a>
                    </li>

                    <c:if test="${sessionScope.userRole eq 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/admin/dashboard.jsp">
                                <i class="fas fa-tachometer-alt"></i> Admin Dashboard
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/admin/manage-users.jsp">
                                <i class="fas fa-users-cog"></i> Manage Users
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/admin/manage-drivers.jsp">
                                <i class="fas fa-user-shield"></i> Manage Drivers
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/admin/manage-cabs.jsp">
                                <i class="fas fa-car"></i> Manage Cabs
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/admin/manage-bookings.jsp">
                                <i class="fas fa-list-alt"></i> All Bookings
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.userRole eq 'customer'}">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/customer/dashboard.jsp">
                                <i class="fas fa-tachometer-alt"></i> Dashboard
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/customer/book-cab.jsp">
                                <i class="fas fa-taxi"></i> Book a Cab
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/customer/my-bookings.jsp">
                                <i class="fas fa-list"></i> My Bookings
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/customer/profile.jsp">
                                <i class="fas fa-user"></i> My Profile
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${not empty sessionScope.username}">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/LogoutServlet">
                                <i class="fas fa-sign-out-alt"></i> Logout
                            </a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</header>
<div class="content">
    <!-- Your content goes here -->
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
