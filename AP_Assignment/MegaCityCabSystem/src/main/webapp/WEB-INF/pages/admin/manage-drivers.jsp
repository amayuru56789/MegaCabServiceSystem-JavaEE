<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/13/2025
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Drivers - Mega City Cab</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.5);
        }
        .modal-content {
            background-color: #fff;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 50%;
            border-radius: 10px;
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container-fluid mt-4">
    <h2 class="mb-4">Manage Drivers</h2>

    <!-- Action Buttons -->
    <div class="mb-4">
        <button class="btn btn-primary" onclick="showAddDriverForm()">
            <i class="fas fa-plus me-2"></i> Add New Driver
        </button>
    </div>

    <!-- Add/Edit Driver Modal -->
    <div id="addDriverForm" class="modal">
        <div class="modal-content">
            <span class="close" onclick="hideAddDriverForm()">&times;</span>
            <h3 class="mb-4">Add New Driver</h3>
            <form id="addDriverFormData">
                <div class="mb-3">
                    <%--<label for="driverId" class="form-label">Driver Name:</label>--%>
                    <%--<input type="text" class="form-control" id="driverId" name="driverId" required>--%>
                        <input type="hidden" id="driverId" name="driverId"> <!-- Hidden field for driverID -->
                </div>
                <div class="mb-3">
                    <label for="driverName" class="form-label">Driver Name:</label>
                    <input type="text" class="form-control" id="driverName" name="driverName" required>
                </div>
                <div class="mb-3">
                    <label for="licenseNumber" class="form-label">License Number:</label>
                    <input type="text" class="form-control" id="licenseNumber" name="licenseNumber" required>
                </div>
                <div class="mb-3">
                    <label for="year" class="form-label">Experience:</label>
                    <select class="form-select" id="year" name="year" required>
                        <option value="1">1 Year</option>
                        <option value="2">2 Year</option>
                        <option value="3">3 Year</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone:</label>
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address:</label>
                    <textarea class="form-control" id="address" name="address" required></textarea>
                </div>
                <div class="mb-3">
                    <label for="status" class="form-label">Status:</label>
                    <select class="form-select" id="status" name="status" required>
                        <option value="available">Available</option>
                        <option value="busy">Busy</option>
                        <option value="inactive">Inactive</option>
                    </select>
                </div>
                <div class="mb-3">
                    <button type="submit" class="btn btn-success" id="submitButton">
                        <i class="fas fa-save me-2"></i> Add Driver
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- Drivers Table -->
    <table class="table table-bordered table-hover" id="driversTable">
        <thead class="table-light">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>License</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <!-- Rows will be populated dynamically -->

        <%--<c:forEach items="${drivers}" var="driver">--%>
            <%--<tr>--%>
                <%--<td>${driver.id}</td>--%>
                <%--<td>${driver.name}</td>--%>
                <%--<td>${driver.licenseNumber}</td>--%>
                <%--<td>${driver.phone}</td>--%>
                <%--<td>${driver.email}</td>--%>
                <%--<td>--%>
                            <%--<span class="badge bg-${driver.status == 'available' ? 'success' : driver.status == 'busy' ? 'warning' : 'danger'}">--%>
                                    <%--${driver.status}--%>
                            <%--</span>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<button class="btn btn-sm btn-warning me-2" onclick="showEditDriverForm(${driver.id})">--%>
                        <%--<i class="fas fa-edit me-1"></i> Edit--%>
                    <%--</button>--%>
                    <%--<button class="btn btn-sm btn-danger" onclick="confirmDeleteDriver(${driver.id})">--%>
                        <%--<i class="fas fa-trash me-1"></i> Delete--%>
                    <%--</button>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and Dependencies -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Custom JS -->
<script>

    $(document).ready(function () {
        // Fetch driver data using AJAX
        $.ajax({
            url: "${pageContext.request.contextPath}/driver", // URL to your servlet
            type: "GET",
            dataType: "json",
            success: function (data) {
                // Clear the table body
                $("#driversTable tbody").empty();

                // Populate the table with driver data
                data.forEach(function (driver) {
                    // Create a new row
                    var row = $("<tr>");

                    // Add columns to the row
                    row.append($("<td>").text(driver.driverID));
                    row.append($("<td>").text(driver.driverName));
                    row.append($("<td>").text(driver.license));
                    row.append($("<td>").text(driver.telephoneNo));
                    row.append($("<td>").text(driver.email));

                    // Add status badge
                    var statusBadge = $("<span>")
                        .addClass("badge")
                        .addClass(
                            driver.status === "available" ? "bg-success" :
                                driver.status === "busy" ? "bg-warning" : "bg-danger"
                        )
                        .text(driver.status);
                    row.append($("<td>").append(statusBadge));

                    // Add action buttons
                    var editButton = $("<button>")
                        .addClass("btn btn-sm btn-warning me-2")
                        .html('<i class="fas fa-edit me-1"></i> Edit')
                        .click(function () {
                            // showEditDriverForm(driver.driverID);
                            showEditDriverForm(driver);
                        });

                    var deleteButton = $("<button>")
                        .addClass("btn btn-sm btn-danger")
                        .html('<i class="fas fa-trash me-1"></i> Delete')
                        .click(function () {
                            confirmDeleteDriver(driver.driverID);
                        });

                    row.append($("<td>").append(editButton).append(deleteButton));

                    // Append the row to the table
                    $("#driversTable tbody").append(row);
                });
            },
            error: function (xhr, status, error) {
                console.error("Error fetching driver data:", error);
                alert("An error occurred while fetching driver data. Please try again.");
            }
        });
    });

    function showAddDriverForm() {
        // Reset the form and set the modal title
        $("#addDriverFormData")[0].reset();
        $("#modalTitle").text("Add New Driver");
        $("#submitButton").html('<i class="fas fa-save me-2"></i> Add Driver');
        document.getElementById("addDriverForm").style.display = "block";
    }

    function hideAddDriverForm() {
        document.getElementById("addDriverForm").style.display = "none";
    }

    function showEditDriverForm(driver) {
        // Implement edit functionality
        // alert("Edit Driver with ID: " + driverId);

        // Populate the form with the driver's data
        $("#driverId").val(driver.driverID);
        $("#driverName").val(driver.driverName);
        $("#licenseNumber").val(driver.license);
        $("#year").val(driver.experience);
        $("#phone").val(driver.telephoneNo);
        $("#email").val(driver.email);
        $("#address").val(driver.address);
        $("#status").val(driver.status);

        // Set the modal title and button text
        $("#modalTitle").text("Edit Driver");
        $("#submitButton").html('<i class="fas fa-save me-2"></i> Update Driver');

        // Show the modal
        document.getElementById("addDriverForm").style.display = "block";
    }

    function confirmDeleteDriver(driverId) {
        if (confirm("Are you sure you want to delete this driver?")) {
            // Implement delete functionality
            alert("Delete Driver with ID: " + driverId);
        }
    }

    // AJAX for adding/updating a driver
    $(document).ready(function () {
        $("#addDriverFormData").on("submit", function (event) {
            event.preventDefault(); // Prevent the default form submission

            // Serialize form data
            var formData = {
                driverId: $("#driverId").val(),
                driverName: $("#driverName").val(),
                license: $("#licenseNumber").val(),
                address: $("#address").val(),
                email: $("#email").val(),
                telephoneNo: $("#phone").val(),
                experience: $("#year").val(),
                status: $("#status").val()
            };

            // Send AJAX request
            $.ajax({
                url: "${pageContext.request.contextPath}/driver",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.status === 200) {
                        alert(response.message); // Show success message
                        hideAddDriverForm(); // Hide the modal
                        location.reload(); // Reload the page to reflect changes
                    } else {
                        alert(response.message); // Show error message
                    }
                },
                error: function (xhr, status, error) {
                    alert("An error occurred while adding the driver. Please try again.");
                }
            });
        });
    });
</script>
</body>
</html>
