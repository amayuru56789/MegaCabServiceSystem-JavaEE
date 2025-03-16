<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/13/2025
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        .stat-card {
            background: #f8f9fa;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .stat-number {
            font-size: 2rem;
            font-weight: bold;
            color: #007bff;
        }
        .quick-link-card {
            background: #ffffff;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .quick-link-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .data-table {
            width: 100%;
            border-collapse: collapse;
        }
        .data-table th, .data-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #e0e0e0;
        }
        .data-table th {
            background: #f8f9fa;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row mt-4">
        <div class="col-12">
            <h2 class="text-center mb-4">Customer Dashboard</h2>
        </div>
    </div>

    <!-- Dashboard Stats -->
    <div class="row mb-4">
        <div class="col-md-3">
            <div class="stat-card">
                <h3>My Bookings</h3>
                <p class="stat-number">${bookingCount}</p>
            </div>
        </div>
        <div class="col-md-3">
            <div class="stat-card">
                <h3>Active Bookings</h3>
                <p class="stat-number">${activeBookingCount}</p>
            </div>
        </div>
        <div class="col-md-3">
            <div class="stat-card">
                <h3>Completed Trips</h3>
                <p class="stat-number">${completedBookingCount}</p>
            </div>
        </div>
        <div class="col-md-3">
            <div class="stat-card">
                <h3>Available Cabs</h3>
                <p class="stat-number">${availableCabCount}</p>
            </div>
        </div>
    </div>

    <!-- Quick Actions -->
    <div class="row mb-4">
        <div class="col-12">
            <h3>Quick Actions</h3>
            <div class="row">
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/customer/book-cab" class="quick-link-card">
                        <h4>Book a Cab</h4>
                        <p>Book a cab for your journey</p>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/customer/my-bookings.jsp" class="quick-link-card">
                        <h4>My Bookings</h4>
                        <p>View and manage your bookings</p>
                    </a>
                </div>
                <div class="col-md-4">
                    <a href="${pageContext.request.contextPath}/customer/cabs-view" class="quick-link-card">
                        <h4>Available Cabs</h4>
                        <p>View all available cabs</p>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <!-- Recent Bookings -->
    <div class="row mb-4">
        <div class="col-12">
            <h3>Recent Bookings</h3>
            <table class="data-table table table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%--<c:forEach items="${recentBookings}" var="booking">--%>
                    <%--<tr>--%>
                        <%--<td>${booking.id}</td>--%>
                        <%--<td>${booking.pickupLocation}</td>--%>
                        <%--<td>${booking.dropLocation}</td>--%>
                        <%--<td>${booking.bookingDate}</td>--%>
                        <%--<td>${booking.status}</td>--%>
                        <%--<td>--%>
                            <%--<a href="${pageContext.request.contextPath}/customer/ViewBookingServlet?id=${booking.id}" class="btn btn-primary btn-sm">View</a>--%>
                        <%--</td>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>

</div>
<!-- Bootstrap JS (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
