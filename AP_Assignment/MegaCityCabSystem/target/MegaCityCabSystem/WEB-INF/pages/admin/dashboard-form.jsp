<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/13/2025
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - Mega City Cab</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        .card {
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        .badge {
            font-size: 0.9rem;
            padding: 0.5em 0.75em;
        }
        .list-group-item {
            transition: background-color 0.2s;
        }
        .list-group-item:hover {
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>
<!-- Include Admin Navbar -->
<jsp:include page="../template/header.jsp" />

<div class="container-fluid mt-4">
    <h2 class="mb-4">Admin Dashboard</h2>

    <!-- Stats Cards -->
    <div class="row">
        <!-- Total Bookings -->
        <div class="col-md-3 mb-4">
            <div class="card bg-primary text-white h-100">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <h6 class="text-uppercase">Total Bookings</h6>
                            <h1 class="display-4">${totalBookings}</h1>
                        </div>
                        <i class="fas fa-taxi fa-3x"></i>
                    </div>
                </div>
                <div class="card-footer d-flex">
                    <a href="${pageContext.request.contextPath}/admin/bookings/list.jsp" class="text-white text-decoration-none">View Details <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>

        <!-- Registered Customers -->
        <div class="col-md-3 mb-4">
            <div class="card bg-success text-white h-100">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <h6 class="text-uppercase">Registered Customers</h6>
                            <h1 class="display-4">${totalCustomers}</h1>
                        </div>
                        <i class="fas fa-users fa-3x"></i>
                    </div>
                </div>
                <div class="card-footer d-flex">
                    <a href="${pageContext.request.contextPath}/admin/customers/list.jsp" class="text-white text-decoration-none">View Details <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>

        <!-- Available Cars -->
        <div class="col-md-3 mb-4">
            <div class="card bg-warning text-white h-100">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <h6 class="text-uppercase">Available Cars</h6>
                            <h1 class="display-4">${availableCars}</h1>
                        </div>
                        <i class="fas fa-car fa-3x"></i>
                    </div>
                </div>
                <div class="card-footer d-flex">
                    <a href="${pageContext.request.contextPath}/admin/cars/list.jsp" class="text-white text-decoration-none">View Details <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>

        <!-- Active Drivers -->
        <div class="col-md-3 mb-4">
            <div class="card bg-danger text-white h-100">
                <div class="card-body">
                    <div class="d-flex justify-content-between align-items-center">
                        <div>
                            <h6 class="text-uppercase">Active Drivers</h6>
                            <h1 class="display-4">${activeDrivers}</h1>
                        </div>
                        <i class="fas fa-id-card fa-3x"></i>
                    </div>
                </div>
                <div class="card-footer d-flex">
                    <a href="${pageContext.request.contextPath}/admin/drivers/list.jsp" class="text-white text-decoration-none">View Details <i class="fas fa-arrow-circle-right"></i></a>
                </div>
            </div>
        </div>
    </div>

    <!-- Recent Bookings and Quick Actions -->
    <div class="row">
        <!-- Recent Bookings -->
        <div class="col-md-8 mb-4">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0">Recent Bookings</h5>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead class="table-light">
                        <tr>
                            <th>Booking #</th>
                            <th>Customer</th>
                            <th>Destination</th>
                            <th>Date</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${recentBookings}" var="booking">
                            <tr>
                                <td>${booking.bookingNumber}</td>
                                <td>${booking.customerName}</td>
                                <td>${booking.destination}</td>
                                <td>${booking.bookingDate}</td>
                                <td>
                                            <span class="badge bg-${booking.status == 'COMPLETED' ? 'success' : booking.status == 'PENDING' ? 'warning' : 'primary'}">
                                                    ${booking.status}
                                            </span>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/bookings/view.jsp?id=${booking.id}" class="btn btn-sm btn-info">
                                        <i class="fas fa-eye"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="card-footer">
                    <a href="${pageContext.request.contextPath}/admin/bookings/list.jsp" class="btn btn-primary">View All Bookings</a>
                </div>
            </div>
        </div>

        <!-- Quick Actions -->
        <div class="col-md-4 mb-4">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h5 class="mb-0">Quick Actions</h5>
                </div>
                <div class="card-body">
                    <div class="list-group">
                        <a href="${pageContext.request.contextPath}/admin/bookings/add.jsp" class="list-group-item list-group-item-action">
                            <i class="fas fa-plus me-2"></i> Add New Booking
                        </a>
                        <a href="${pageContext.request.contextPath}/admin/cars/add.jsp" class="list-group-item list-group-item-action">
                            <i class="fas fa-car-side me-2"></i> Register New Car
                        </a>
                        <a href="${pageContext.request.contextPath}/admin/drivers-manage" class="list-group-item list-group-item-action">
                            <i class="fas fa-user-plus me-2"></i> Add New Driver
                        </a>
                        <a href="${pageContext.request.contextPath}/admin/bookings/bill.jsp" class="list-group-item list-group-item-action">
                            <i class="fas fa-file-invoice-dollar me-2"></i> Generate Bill
                        </a>
                        <a href="${pageContext.request.contextPath}/help.jsp" class="list-group-item list-group-item-action">
                            <i class="fas fa-question-circle me-2"></i> Help Documentation
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Include Footer -->
<jsp:include page="../template/footer.jsp" />

<!-- Bootstrap JS and Dependencies -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
