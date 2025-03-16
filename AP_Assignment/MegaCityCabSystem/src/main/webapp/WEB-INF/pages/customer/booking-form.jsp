<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/16/2025
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Booking</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Add New Booking</h4>
        </div>
        <div class="card-body">
            <!-- Success and Error Messages -->
            <div id="message" class="d-none"></div>

            <!-- Booking Form -->
            <form id="bookingForm">
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="customerSelect" class="form-label">Select Customer</label>
                        <select class="form-select" id="customerSelect" name="customerId" required>
                            <option value="">-- Select Customer --</option>
                            <c:forEach items="${customers}" var="customer">
                                <option value="${customer.customerId}">${customer.customerName} </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label for="bookingNumber" class="form-label">Booking Number</label>
                        <input type="text" class="form-control" id="bookingNumber" name="bookingNumber" >
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="pickupAddress" class="form-label">Pickup Address</label>
                        <textarea class="form-control" id="pickupAddress" name="pickupAddress" rows="3" required></textarea>
                    </div>
                    <div class="col-md-6">
                        <label for="destination" class="form-label">Destination</label>
                        <textarea class="form-control" id="destination" name="destination" rows="3" required></textarea>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="pickupTime" class="form-label">Pickup Date & Time</label>
                        <input type="datetime-local" class="form-control" id="pickupTime" name="pickupTime" required>
                    </div>
                    <div class="col-md-6">
                        <label for="estimatedDistance" class="form-label">Estimated Distance (km)</label>
                        <input type="number" step="0.1" class="form-control" id="estimatedDistance" name="estimatedDistance" required>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="carType" class="form-label">Car Type</label>
                        <select class="form-select" id="carType" name="carType" required>
                            <option value="">-- Select Car Type --</option>
                            <c:forEach items="${cabs}" var="cab">
                                <option value="${cab.cabId}">${cab.cabName} </option>
                            </c:forEach>
                            <%--<option value="ECONOMY">Economy</option>--%>
                            <%--<option value="STANDARD">Standard</option>--%>
                            <%--<option value="LUXURY">Luxury</option>--%>
                        </select>
                    </div>
                    <%--<div class="col-md-6">--%>
                        <%--<label for="driverSelect" class="form-label">Assign Driver</label>--%>
                        <%--<select class="form-select" id="driverSelect" name="driverId" required>--%>
                            <%--<option value="">-- Select Driver --</option>--%>
                            <%--&lt;%&ndash;<c:forEach items="${availableDrivers}" var="driver">&ndash;%&gt;--%>
                                <%--&lt;%&ndash;<option value="${driver.id}">${driver.name} (${driver.carModel})</option>&ndash;%&gt;--%>
                            <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                        <%--</select>--%>
                    <%--</div>--%>
                </div>

                <div class="mb-3">
                    <label for="specialInstructions" class="form-label">Special Instructions</label>
                    <textarea class="form-control" id="specialInstructions" name="specialInstructions" rows="3"></textarea>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="${pageContext.request.contextPath}/admin/bookings/list.jsp" class="btn btn-secondary">
                        <i class="fas fa-arrow-left me-2"></i> Back to Booking List
                    </a>
                    <button type="submit" class="btn btn-primary">
                        <i class="fas fa-save me-2"></i> Save Booking
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS and Dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
<!-- jQuery for AJAX -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- AJAX Script -->
<script>
    $(document).ready(function () {
        $("#bookingForm").on("submit", function (event) {
            event.preventDefault(); // Prevent form submission

            // Serialize form data
            // var formData = $(this).serialize();
            var formData = {
                bookingId: $("#bookingNumber").val(),
                customerId: $("#customerSelect").val(),
                cabId: $("#carType").val(),
                registrationNo: "ABC-1234", // Replace with actual value or add an input field
                pickupDateTime: $("#pickupTime").val(),
                pickupAddress: $("#pickupAddress").val(),
                destination: $("#destination").val(),
                distance: $("#estimatedDistance").val(),
                destinationDetails: $("#specialInstructions").val()
            };

            // Send AJAX request
            $.ajax({
                url: "${pageContext.request.contextPath}/booking", // Servlet URL
                type: "POST",
                contentType: "application/json",
                // data: formData,
                data: JSON.stringify(formData),
                success: function (response) {
                    // Handle success response
                    $("#message").removeClass("d-none alert-danger").addClass("alert alert-success").text("Booking added successfully!");
                    $("#bookingForm")[0].reset(); // Reset form
                },
                error: function (xhr, status, error) {
                    // Handle error response
                    $("#message").removeClass("d-none alert-success").addClass("alert alert-danger").text("Failed to add booking. Please try again.");
                }
            });
        });
    });
</script>
</body>
</html>
