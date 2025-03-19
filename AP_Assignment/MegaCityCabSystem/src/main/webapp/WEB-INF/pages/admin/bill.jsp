<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/19/2025
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Generate Bill - Mega City Cab</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>
<body>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-5">
            <div class="card shadow mb-4">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Generate Bill</h4>
                </div>
                <div class="card-body">
                    <form id="billForm" action="${pageContext.request.contextPath}/payment" method="post">
                        <div class="mb-3">
                            <label for="bookingNumber" class="form-label">Booking Number</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="bookingNumber" name="bookingNumber" required>
                                <button type="button" id="searchBtn" class="btn btn-primary">
                                    <i class="fas fa-search"></i>
                                </button>
                            </div>
                        </div>

                        <div id="bookingDetails" style="display: none;">
                            <div class="mb-3">
                                <label for="customerName" class="form-label">Customer Name</label>
                                <input type="text" class="form-control" id="customerName" readonly>
                            </div>

                            <div class="mb-3">
                                <label for="distance" class="form-label">Distance (km)</label>
                                <input type="number" step="0.1" class="form-control" id="distance" name="distance" required>
                            </div>

                            <div class="mb-3">
                                <label for="ratePerKm" class="form-label">Rate per Kilometer (Rs.)</label>
                                <input type="number" step="0.01" class="form-control" id="ratePerKm" name="ratePerKm" required>
                            </div>

                            <div class="mb-3">
                                <label for="waitingTime" class="form-label">Waiting Time (minutes)</label>
                                <input type="number" class="form-control" id="waitingTime" name="waitingTime" value="0" required>
                            </div>

                            <div class="mb-3">
                                <label for="waitingCharge" class="form-label">Waiting Charge per Minute (Rs.)</label>
                                <input type="number" step="0.01" class="form-control" id="waitingCharge" name="waitingCharge" value="5.00" required>
                            </div>

                            <div class="mb-3">
                                <label for="additionalCharges" class="form-label">Additional Charges (Rs.)</label>
                                <input type="number" step="0.01" class="form-control" id="additionalCharges" name="additionalCharges" value="0.00">
                            </div>

                            <div class="mb-3">
                                <label for="discount" class="form-label">Discount (%)</label>
                                <input type="number" step="0.01" class="form-control" id="discount" name="discount" value="0.00">
                            </div>

                            <div class="d-grid gap-2">
                                <button type="button" id="calculateBtn" class="btn btn-success">
                                    <i class="fas fa-calculator me-2"></i> Calculate Bill
                                </button>
                                <button type="button" id="addPaymentBtn" class="btn btn-primary" style="display: none;">
                                    <i class="fas fa-money-bill me-2"></i> Add Payment
                                </button>
                                <button type="submit" class="btn btn-primary" id="printBtn" style="display: none;">
                                    <i class="fas fa-print me-2"></i> Print Bill
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="card shadow" id="billPreview" style="display: none;">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Bill Preview</h4>
                </div>
                <div class="card-body">
                    <div class="text-center mb-4">
                        <h3>Mega City Cab</h3>
                        <p>123 Colombo Road, Colombo</p>
                        <p>Tel: +94 112 345 6789</p>
                        <h4 class="mt-3">INVOICE</h4>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <p><strong>Booking Number:</strong> <span id="preview-bookingNumber"></span></p>
                            <p><strong>Customer:</strong> <span id="preview-customerName"></span></p>
                        </div>
                        <div class="col-md-6 text-md-end">
                            <p><strong>Date:</strong> <span id="preview-date"></span></p>
                            <p><strong>Invoice Number:</strong> <span id="preview-invoiceNumber"></span></p>
                        </div>
                    </div>

                    <table class="table table-bordered">
                        <thead class="table-light">
                        <tr>
                            <th>Description</th>
                            <th class="text-end">Amount (Rs.)</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Distance Charge (<span id="preview-distance"></span> km × Rs. <span id="preview-ratePerKm"></span>)</td>
                            <td class="text-end" id="preview-distanceCharge"></td>
                        </tr>
                        <tr>
                            <td>Waiting Charge (<span id="preview-waitingTime"></span> min × Rs. <span id="preview-waitingCharge"></span>)</td>
                            <td class="text-end" id="preview-waitingTimeCharge"></td>
                        </tr>
                        <tr>
                            <td>Additional Charges</td>
                            <td class="text-end" id="preview-additionalCharges"></td>
                        </tr>
                        <tr>
                            <td><strong>Subtotal</strong></td>
                            <td class="text-end" id="preview-subtotal"></td>
                        </tr>
                        <tr>
                            <td>Discount (<span id="preview-discountRate"></span>%)</td>
                            <td class="text-end" id="preview-discountAmount"></td>
                        </tr>
                        <tr>
                            <td><strong>Total</strong></td>
                            <td class="text-end fw-bold" id="preview-totalAmount"></td>
                        </tr>
                        </tbody>
                    </table>

                    <div class="mt-4 border-top pt-3">
                        <p class="text-center">Thank you for choosing Mega City Cab!</p>
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
<!-- Custom JavaScript -->
<script>
    $(document).ready(function () {
        // Show booking details when search button is clicked
        $("#searchBtn").click(function () {

            var bookingNumber = $("#bookingNumber").val();

            // Send AJAX request to fetch booking details
            $.ajax({
                url: "${pageContext.request.contextPath}/payment", // Servlet URL
                type: "GET",
                data: { bookingNumber: bookingNumber },
                success: function (response) {
                    if (response) {
                        console.log('dssdsd', response)
                        // Populate form fields with booking details
                        $("#customerName").val(response.customerName);
                        $("#distance").val(response.distance);
                        $("#ratePerKm").val(response.ratePerKm);
                        $("#waitingTime").val(response.waitingTime);
                        $("#waitingCharge").val(response.waitingCharge);
                        $("#additionalCharges").val(response.additionalCharges);
                        $("#discount").val(response.discount);

                        // Show the booking details section
                        $("#bookingDetails").show();
                    } else {
                        alert("No booking found for the provided booking number.");
                    }
                },
                error: function (xhr, status, error) {
                    alert("Failed to fetch booking details. Please try again.");
                    console.error(error);
                }
            });
        });

            // Simulate fetching booking details (replace with AJAX call to backend)
            // $("#customerName").val("John Doe"); // Example customer name
            // $("#bookingDetails").show();

        // Calculate bill when calculate button is clicked
        $("#calculateBtn").click(function () {
            // Get input values
            var distance = parseFloat($("#distance").val());
            var ratePerKm = parseFloat($("#ratePerKm").val());
            var waitingTime = parseFloat($("#waitingTime").val());
            var waitingCharge = parseFloat($("#waitingCharge").val());
            var additionalCharges = parseFloat($("#additionalCharges").val());
            var discount = parseFloat($("#discount").val());

            // Calculate the bill
            var distanceCharge = distance * ratePerKm;
            var waitingTimeCharge = waitingTime * waitingCharge;
            var subtotal = distanceCharge + waitingTimeCharge + additionalCharges;
            var discountAmount = (discount / 100) * subtotal;
            var totalAmount = subtotal - discountAmount;

            // Display the bill preview
            $("#preview-bookingNumber").text($("#bookingNumber").val());
            $("#preview-customerName").text($("#customerName").val());
            $("#preview-date").text(new Date().toLocaleDateString());
            $("#preview-invoiceNumber").text("INV-" + Math.floor(Math.random() * 1000000)); // Random invoice number
            $("#preview-distance").text(distance);
            $("#preview-ratePerKm").text(ratePerKm.toFixed(2));
            $("#preview-distanceCharge").text(distanceCharge.toFixed(2));
            $("#preview-waitingTime").text(waitingTime);
            $("#preview-waitingCharge").text(waitingCharge.toFixed(2));
            $("#preview-waitingTimeCharge").text(waitingTimeCharge.toFixed(2));
            $("#preview-additionalCharges").text(additionalCharges.toFixed(2));
            $("#preview-subtotal").text(subtotal.toFixed(2));
            $("#preview-discountRate").text(discount);
            $("#preview-discountAmount").text(discountAmount.toFixed(2));
            $("#preview-totalAmount").text(totalAmount.toFixed(2));

            // Show the bill preview and print button
            $("#billPreview").show();
            $("#addPaymentBtn").show();
            $("#printBtn").show();
        });

        // Add Payment button click event
        $("#addPaymentBtn").click(function () {
            // Get form data
            var bookingNumber = $("#bookingNumber").val();
            var distance = $("#distance").val();
            var ratePerKm = $("#ratePerKm").val();
            var waitingTime = $("#waitingTime").val();
            var waitingCharge = $("#waitingCharge").val();
            var additionalCharges = $("#additionalCharges").val();
            var discount = $("#discount").val();

            // Create JSON object
            var paymentData = {
                bookingNumber: bookingNumber,
                distance: distance,
                ratePerKm: ratePerKm,
                waitingTime: waitingTime,
                waitingCharge: waitingCharge,
                additionalCharges: additionalCharges,
                discount: discount
            };

            // Send AJAX request
            $.ajax({
                url: "${pageContext.request.contextPath}/payment", // Servlet URL
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(paymentData),
                success: function (response) {
                    alert("Payment added successfully!");
                    console.log(response);
                },
                error: function (xhr, status, error) {
                    alert("Failed to add payment. Please try again.");
                    console.error(error);
                }
            });
        });

        // Print the bill
        $("#printBtn").click(function () {
            window.print();
        });
    });
</script>
</body>
</html>
