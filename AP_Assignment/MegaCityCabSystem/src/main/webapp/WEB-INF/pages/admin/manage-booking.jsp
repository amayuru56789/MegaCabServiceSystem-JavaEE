<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/21/2025
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Bookings</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="container-fluid mt-4">
    <h2 class="mb-4">Manage Bookings</h2>

    <!-- Booking Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
            <tr>
                <th>Booking ID</th>
                <th>Customer ID</th>
                <th>Cab ID</th>
                <th>Registration No</th>
                <th>Booking Date</th>
                <th>Booking Time</th>
                <th>Last Updated Date</th>
                <th>Last Updated Time</th>
                <th>Destination</th>
                <th>Destination Details</th>
                <th>Status</th>
                <th>Pickup Date & Time</th>
                <th>Pickup Address</th>
                <th>Distance (km)</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody id="bookingTableBody">
            <!-- Table rows will be populated dynamically using JavaScript -->
            </tbody>
        </table>
    </div>
</div>

<!-- Edit Booking Modal -->
<div class="modal fade" id="editBookingModal" tabindex="-1" aria-labelledby="editBookingModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editBookingModalLabel">Edit Booking</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editBookingForm" action="${pageContext.request.contextPath}/updateBooking" method="post">
                    <input type="hidden" id="editBookingId" name="bookingId">

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="editCustomerId" class="form-label">Customer ID</label>
                            <input type="text" class="form-control" id="editCustomerId" name="customerId" required>
                        </div>
                        <div class="col-md-6">
                            <label for="editCabId" class="form-label">Cab ID</label>
                            <input type="text" class="form-control" id="editCabId" name="cabId" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="editRegistrationNo" class="form-label">Registration No</label>
                            <input type="text" class="form-control" id="editRegistrationNo" name="registrationNo" required>
                        </div>
                        <div class="col-md-6">
                            <label for="editBookingDate" class="form-label">Booking Date</label>
                            <input type="date" class="form-control" id="editBookingDate" name="bookingDate" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="editBookingTime" class="form-label">Booking Time</label>
                            <input type="time" class="form-control" id="editBookingTime" name="bookingTime" required>
                        </div>
                        <div class="col-md-6">
                            <label for="editDestination" class="form-label">Destination</label>
                            <input type="text" class="form-control" id="editDestination" name="destination" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="editDestinationDetails" class="form-label">Destination Details</label>
                            <input type="text" class="form-control" id="editDestinationDetails" name="destinationDetails" required>
                        </div>
                        <div class="col-md-6">
                            <label for="editActivityStatus" class="form-label">Status</label>
                            <select class="form-select" id="editActivityStatus" name="activityStatus" required>
                                <option value="Pending">Pending</option>
                                <option value="Completed">Completed</option>
                                <option value="Cancelled">Cancelled</option>
                            </select>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="editPickupDateTime" class="form-label">Pickup Date & Time</label>
                            <input type="datetime-local" class="form-control" id="editPickupDateTime" name="pickupDateTime" required>
                        </div>
                        <div class="col-md-6">
                            <label for="editPickupAddress" class="form-label">Pickup Address</label>
                            <input type="text" class="form-control" id="editPickupAddress" name="pickupAddress" required>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="editDistance" class="form-label">Distance (km)</label>
                            <input type="number" step="0.1" class="form-control" id="editDistance" name="distance" required>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save Changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- JavaScript to Load Booking Data and Handle Modal -->
<script>
    $(document).ready(function () {
        // Fetch booking data when the page loads
        loadBookingData();

        // Function to load booking data
        function loadBookingData() {
            $.ajax({
                url: "${pageContext.request.contextPath}/booking", // Backend endpoint to fetch all bookings
                type: "GET",
                success: function (response) {
                    // Clear the table body
                    $("#bookingTableBody").empty();

                    // Populate the table with booking data
                    response.forEach(function (booking) {
                        var row = $("<tr>");
                        row.append($("<td>").text(booking.bookingId));
                        row.append($("<td>").text(booking.customerId));
                        row.append($("<td>").text(booking.cabId));
                        row.append($("<td>").text(booking.registrationNo));
                        row.append($("<td>").text(booking.bookingDate));
                        row.append($("<td>").text(booking.bookingTime));
                        row.append($("<td>").text(booking.lastUpdatedDate));
                        row.append($("<td>").text(booking.lastUpdatedTime));
                        row.append($("<td>").text(booking.destination));
                        row.append($("<td>").text(booking.destinationDetails));
                        row.append($("<td>").text(booking.status));
                        row.append($("<td>").text(booking.pickupDateTime));
                        row.append($("<td>").text(booking.pickupAddress));
                        row.append($("<td>").text(booking.distance));

                        // Add edit button
                        var editButton = $("<button>")
                            .addClass("btn btn-primary btn-sm")
                            .html('<i class="fas fa-edit"></i> Edit')
                            .click(function () {
                                openEditModal(booking.bookingId);
                            });

                        var deleteButton = $("<button>")
                            .addClass("btn btn-sm btn-danger")
                            .html('<i class="fas fa-trash me-1"></i> Delete')
                            .click(function () {
                                confirmDeleteDriver(driver.driverID);
                            });

                        row.append($("<td>").append(editButton).append(deleteButton));

                        // row.append($("<td>").append(editButton));

                        $("#bookingTableBody").append(row);
                    });
                },
                error: function (xhr, status, error) {
                    alert("Failed to fetch booking data. Please try again.");
                    console.error(error);
                }
            });
        }

        // Function to open the edit modal
        function openEditModal(bookingId) {
            // Fetch booking details using AJAX
            $.ajax({
                url: "${pageContext.request.contextPath}/booking",
                type: "GET",
                data: { bookingId: bookingId },
                success: function (response) {
                    // Populate form fields with booking details
                    $("#editBookingId").val(response.bookingId);
                    $("#editCustomerId").val(response.customerId);
                    $("#editCabId").val(response.cabId);
                    $("#editRegistrationNo").val(response.registrationNo);
                    $("#editBookingDate").val(response.bookingDate);
                    $("#editBookingTime").val(response.bookingTime);
                    $("#editDestination").val(response.destination);
                    $("#editDestinationDetails").val(response.destinationDetails);
                    $("#editActivityStatus").val(response.activityStatus);
                    $("#editPickupDateTime").val(response.pickupDateTime);
                    $("#editPickupAddress").val(response.pickupAddress);
                    $("#editDistance").val(response.distance);

                    // Open the modal
                    new bootstrap.Modal(document.getElementById('editBookingModal')).show();
                },
                error: function (xhr, status, error) {
                    alert("Failed to fetch booking details. Please try again.");
                    console.error(error);
                }
            });
        }
    });
</script>
</body>
</html>
