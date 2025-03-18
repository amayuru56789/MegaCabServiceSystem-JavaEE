<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/18/2025
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Driver Dashboard - Mega City Cab</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
div class="container-fluid mt-4">
<div class="row">
    <div class="col-md-8 mx-auto">
        <div class="card shadow mb-4">
            <div class="card-header bg-primary text-white">
                <div class="d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">Driver Dashboard</h4>
                    <span class="badge bg-light text-dark">
                                <i class="fas fa-id-card me-1"></i> Driver ID: ${sessionScope.userId}
                            </span>
                </div>
            </div>
            <div class="card-body">
                <div class="row mb-4">
                    <div class="col-md-12">
                        <div class="alert alert-info">
                            <h5><i class="fas fa-info-circle me-2"></i> Welcome, ${sessionScope.userName}!</h5>
                            <p class="mb-0">Current Status:
                                <span class="badge ${driverStatus == 'available' ? 'bg-success' : 'bg-warning'}">
                                    ${driverStatus != null ? driverStatus : 'OFFLINE'}
                                </span>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-4">
                        <div class="card bg-primary text-white h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-route fa-3x mb-3"></i>
                                <h5>Today's Trips</h5>
                                <h2>${todayTrips != null ? todayTrips : '0'}</h2>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card bg-success text-white h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-clipboard-check fa-3x mb-3"></i>
                                <h5>Completed Trips</h5>
                                <h2>${completedTrips != null ? completedTrips : '0'}</h2>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card bg-warning text-dark h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-hourglass-half fa-3x mb-3"></i>
                                <h5>Pending Trips</h5>
                                <h2>${pendingTrips != null ? pendingTrips : '0'}</h2>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light">
                                <h5 class="mb-0">Current Assignment</h5>
                            </div>
                            <div class="card-body">
                                <c:choose>
                                    <c:when test="${currentBooking != null}">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <p><strong>Booking #:</strong> ${currentBooking.bookingNumber}</p>
                                                <p><strong>Customer:</strong> ${currentBooking.customerName}</p>
                                                <p><strong>Phone:</strong> ${currentBooking.customerPhone}</p>
                                                <p><strong>Pickup:</strong> ${currentBooking.pickupAddress}</p>
                                            </div>
                                            <div class="col-md-6">
                                                <p><strong>Status:</strong>
                                                    <span class="badge bg-${currentBooking.activityStatus == 'IN_PROGRESS' ? 'primary' : currentBooking.activityStatus == 'PICKED_UP' ? 'info' : 'warning'}">
                                                            ${currentBooking.activityStatus}
                                                    </span>
                                                </p>
                                                <p><strong>Destination:</strong> ${currentBooking.destination}</p>
                                                <p><strong>Pickup Time:</strong> ${currentBooking.pickupDateTime}</p>
                                                <p><strong>Est. Distance:</strong> ${currentBooking.estimatedDistance} km</p>
                                            </div>
                                        </div>
                                        <div class="d-flex justify-content-center mt-3">
                                            <c:choose>
                                                <c:when test="${currentBooking.activityStatus == 'ASSIGNED'}">
                                                    <a href="${pageContext.request.contextPath}/driver/bookings/updateStatus?id=${currentBooking.bookingNumber}&status=IN_PROGRESS" class="btn btn-primary me-2">
                                                        <i class="fas fa-car-side me-2"></i> Start Trip
                                                    </a>
                                                </c:when>
                                                <c:when test="${currentBooking.activityStatus == 'IN_PROGRESS'}">
                                                    <a href="${pageContext.request.contextPath}/driver/bookings/updateStatus?id=${currentBooking.bookingNumber}&status=PICKED_UP" class="btn btn-info me-2">
                                                        <i class="fas fa-user-check me-2"></i> Picked Up Customer
                                                    </a>
                                                </c:when>
                                                <c:when test="${currentBooking.activityStatus == 'PICKED_UP'}">
                                                    <a href="${pageContext.request.contextPath}/driver/bookings/updateStatus?id=${currentBooking.bookingNumber}&status=COMPLETED" class="btn btn-success me-2">
                                                        <i class="fas fa-flag-checkered me-2"></i> Complete Trip
                                                    </a>
                                                </c:when>
                                            </c:choose>

                                            <a href="${pageContext.request.contextPath}/driver/bookings/details.jsp?id=${currentBooking.bookingNumber}" class="btn btn-outline-primary">
                                                <i class="fas fa-info-circle me-2"></i> View Details
                                            </a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="text-center py-5">
                                            <i class="fas fa-car-side fa-4x text-muted mb-3"></i>
                                            <h5 class="text-muted">No Current Assignment</h5>
                                            <p>You don't have any active bookings at the moment.</p>
                                            <a href="${pageContext.request.contextPath}/driver/bookings/assigned.jsp" class="btn btn-primary mt-2">
                                                <i class="fas fa-list me-2"></i> View All Assignments
                                            </a>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header bg-light d-flex justify-content-between align-items-center">
                                <h5 class="mb-0">Upcoming Assignments</h5>
                                <a href="${pageContext.request.contextPath}/driver/bookings/assigned.jsp" class="btn btn-sm btn-primary">
                                    <i class="fas fa-list me-1"></i> View All
                                </a>
                            </div>
                            <div class="card-body">
                                <c:choose>
                                    <c:when test="${not empty upcomingBookings}">
                                        <div class="table-responsive">
                                            <table class="table table-hover">
                                                <thead>
                                                <tr>
                                                    <th>Booking #</th>
                                                    <th>Customer</th>
                                                    <th>Pickup Time</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${upcomingBookings}" var="booking" begin="0" end="4">
                                                    <tr>
                                                        <td>${booking.bookingNumber}</td>
                                                        <td>${booking.customerName}</td>
                                                        <td>${booking.pickupDateTime}</td>
                                                        <td>
                                                                        <span class="badge bg-${booking.activityStatus == 'ASSIGNED' ? 'warning' : 'primary'}">
                                                                                ${booking.activityStatus}
                                                                        </span>
                                                        </td>
                                                        <td>
                                                            <%--<a href="${pageContext.request.contextPath}/driver/bookings/details.jsp?id=${booking.id}" class="btn btn-sm btn-info">--%>
                                                                <%--<i class="fas fa-eye"></i>--%>
                                                            <%--</a>--%>
                                                        <td>
                                                            <!-- Confirmation Button -->
                                                            <c:if test="${booking.activityStatus == 'pending'}">
                                                                <a href="${pageContext.request.contextPath}/driver/confirmBooking?id=${booking.bookingNumber}"
                                                                   class="btn btn-sm btn-success">
                                                                    <i class="fas fa-check"></i> Confirm
                                                                </a>
                                                            </c:if>
                                                        </td>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="text-center py-4">
                                            <i class="fas fa-calendar-alt fa-3x text-muted mb-3"></i>
                                            <h6 class="text-muted">No Upcoming Assignments</h6>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- jQuery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Bootstrap JS CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
