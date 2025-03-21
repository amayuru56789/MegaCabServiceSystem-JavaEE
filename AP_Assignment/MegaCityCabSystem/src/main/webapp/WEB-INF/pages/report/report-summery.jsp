<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/20/2025
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="reports container mt-4">
    <h2 class="mb-4">Reports</h2>

    <!-- Report Filters -->
    <div class="report-filters card mb-4">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/report/report-summery" method="get" class="row g-3">
                <!-- Report Type Dropdown -->
                <div class="col-md-3">
                    <label for="reportType" class="form-label">Report Type:</label>
                    <select id="reportType" name="reportType" class="form-select" required>
                        <option value="bookingSummary" ${param.reportType eq 'bookingSummary' ? 'selected' : ''}>Booking Summary</option>
                        <option value="revenue" ${param.reportType eq 'revenue' ? 'selected' : ''}>Revenue Report</option>
                        <option value="driverPerformance" ${param.reportType eq 'driverPerformance' ? 'selected' : ''}>Driver Performance</option>
                        <option value="customerActivity" ${param.reportType eq 'customerActivity' ? 'selected' : ''}>Customer Activity</option>
                    </select>
                </div>

                <!-- Date From -->
                <div class="col-md-3">
                    <label for="dateFrom" class="form-label">From:</label>
                    <input type="date" id="dateFrom" name="dateFrom" class="form-control" value="${param.dateFrom}" required>
                </div>

                <!-- Date To -->
                <div class="col-md-3">
                    <label for="dateTo" class="form-label">To:</label>
                    <input type="date" id="dateTo" name="dateTo" class="form-control" value="${param.dateTo}" required>
                </div>

                <!-- Buttons -->
                <div class="col-md-3 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary me-2">Generate Report</button>
                    <button type="button" class="btn btn-success" onclick="exportReport()">Export to PDF</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Report Container -->
    <c:if test="${not empty report}">
        <div class="report-container card">
            <div class="card-body">
                <h3 class="card-title">${reportTitle}</h3>

                <!-- Booking Summary Report -->
                <c:if test="${param.reportType eq 'bookingSummary'}">
                    <div class="report-summary mb-4">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="summary-item p-3 bg-light rounded">
                                    <span class="summary-label fw-bold">Total Bookings:</span>
                                    <span class="summary-value">${report.totalBookings}</span>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="summary-item p-3 bg-light rounded">
                                    <span class="summary-label fw-bold">Completed Bookings:</span>
                                    <span class="summary-value">${report.completedBookings}</span>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="summary-item p-3 bg-light rounded">
                                    <span class="summary-label fw-bold">Pending Bookings:</span>
                                    <span class="summary-value">${report.pendingBookings}</span>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="summary-item p-3 bg-light rounded">
                                    <span class="summary-label fw-bold">Cancelled Bookings:</span>
                                    <span class="summary-value">${report.cancelledBookings}</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Booking Details Table -->
                    <div class="table-responsive">
                        <table class="table table-bordered table-striped">
                            <thead class="table-dark">
                            <tr>
                                <th>Booking ID</th>
                                <th>Customer Name</th>
                                <th>Pickup Address</th>
                                <th>Destination</th>
                                <th>Booking Date</th>
                                <th>Status</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${report.bookingDetails}" var="booking">
                                <tr>
                                    <td>${booking.bookingId}</td>
                                    <td>${booking.customerName}</td>
                                    <td>${booking.pickupAddress}</td>
                                    <td>${booking.destination}</td>
                                    <td>${booking.bookingDate}</td>
                                    <td>
                                            <span class="badge ${booking.activityStatus eq 'Completed' ? 'bg-success' : booking.activityStatus eq 'Pending' ? 'bg-warning' : 'bg-danger'}">
                                                    ${booking.activityStatus}
                                            </span>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>

                <!-- Other Reports (Revenue, Driver Performance, Customer Activity) -->
                <c:if test="${param.reportType eq 'revenue'}">
                    <!-- Revenue Report Content -->
                </c:if>
                <c:if test="${param.reportType eq 'driverPerformance'}">
                    <!-- Driver Performance Report Content -->
                </c:if>
                <c:if test="${param.reportType eq 'customerActivity'}">
                    <!-- Customer Activity Report Content -->
                </c:if>
            </div>
        </div>
    </c:if>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- Export to Excel Function -->
<script>
    // function exportReport() {
    //     // Implement export to Excel functionality
    //     alert("Export to Excel functionality will be implemented here.");
    // }

    function exportReport() {
        // Get the form data
        var dateFrom = $("#dateFrom").val();
        var dateTo = $("#dateTo").val();
        var reportType = $("#reportType").val();

        // Validate the dates
        if (!dateFrom || !dateTo) {
            alert("Please select both 'From' and 'To' dates.");
            return;
        }

        // Send an AJAX POST request to the servlet
        $.ajax({
            url: "${pageContext.request.contextPath}/generate-report", // Servlet URL
            type: "POST",
            data: {
                dateFrom: dateFrom,
                dateTo: dateTo,
                reportType: reportType
            },
            xhrFields: {
                responseType: 'blob' // Important for handling binary data (PDF)
            },
            success: function (data, status, xhr) {

                // Create a Blob from the response
                var blob = new Blob([data], { type: "application/pdf" });

                // Create a link element to trigger the download
                var link = document.createElement("a");
                link.href = window.URL.createObjectURL(blob);
                link.download = "bookings_report.pdf"; // File name for download
                document.body.appendChild(link);
                link.click(); // Trigger the download
                document.body.removeChild(link); // Clean up
            },
            error: function (xhr, status, error) {
                alert("Error generating PDF: " + error);
            }
        });
    }
</script>
</body>
</html>
