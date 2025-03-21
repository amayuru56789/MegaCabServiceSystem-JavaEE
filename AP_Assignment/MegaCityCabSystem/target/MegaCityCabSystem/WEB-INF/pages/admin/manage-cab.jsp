<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/21/2025
  Time: 5:15 PM
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
    <title>Add New Cab</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Cab Management System</h2>

    <!-- Add/Edit Cab Form -->
    <div class="card mb-4">
        <div class="card-header">
            <h5 id="formTitle">Add New Cab</h5>
        </div>
        <div class="card-body">
            <form id="cabForm" enctype="multipart/form-data">
                <input type="hidden" id="actionType" name="actionType" value="add">
                <input type="hidden" id="editCabId" name="editCabId" value="">

                <!-- Cab ID -->
                <div class="mb-3">
                    <label for="cabId" class="form-label">Cab ID:</label>
                    <input type="text" class="form-control" id="cabId" name="cabId" required>
                </div>

                <!-- Model -->
                <div class="mb-3">
                    <label for="model" class="form-label">Model:</label>
                    <input type="text" class="form-control" id="model" name="model" required>
                </div>

                <!-- Mileage -->
                <div class="mb-3">
                    <label for="mileage" class="form-label">Mileage:</label>
                    <input type="text" class="form-control" id="mileage" name="mileage" required>
                </div>

                <!-- Status -->
                <div class="mb-3">
                    <label for="status" class="form-label">Status:</label>
                    <select class="form-select" id="status" name="status" required>
                        <option value="Available">Available</option>
                        <option value="Unavailable">Unavailable</option>
                    </select>
                </div>

                <!-- Price -->
                <div class="mb-3">
                    <label for="price" class="form-label">Price:</label>
                    <input type="number" class="form-control" id="price" name="price" step="0.01" required>
                </div>

                <!-- Capacity -->
                <div class="mb-3">
                    <label for="capacity" class="form-label">Capacity:</label>
                    <input type="number" class="form-control" id="capacity" name="capacity" required>
                </div>

                <!-- Image Upload -->
                <div class="mb-3">
                    <label for="image" class="form-label">Cab Image:</label>
                    <input type="file" class="form-control" id="image" name="image" accept="image/*">
                </div>

                <!-- Submit Button -->
                <button type="submit" class="btn btn-primary" id="submitButton">Add Cab</button>
                <button type="button" class="btn btn-secondary" id="cancelButton" style="display: none;">Cancel</button>
            </form>
        </div>
    </div>

    <!-- Cab List -->
    <div class="card">
        <div class="card-header">
            <h5>Cab List</h5>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>Cab ID</th>
                    <th>Model</th>
                    <th>Mileage</th>
                    <th>Status</th>
                    <th>Price</th>
                    <th>Capacity</th>
                    <th>Image</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody id="cabTableBody">
                <!-- Cab rows will be dynamically inserted here -->
                </tbody>
            </table>
        </div>
    </div>

    <!-- Response Message -->
    <div id="responseMessage" class="mt-4"></div>
</div>

<!-- Bootstrap JS and jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<!-- AJAX Form Submission -->
<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--$("#addCabForm").on("submit", function (event) {--%>
            <%--event.preventDefault(); // Prevent default form submission--%>

            <%--// Create FormData object--%>
            <%--const formData = new FormData(this);--%>

            <%--// Send AJAX request--%>
            <%--$.ajax({--%>
                <%--url: "${pageContext.request.contextPath}/cab", // Servlet URL--%>
                <%--type: "POST",--%>
                <%--data: formData,--%>
                <%--processData: false, // Prevent jQuery from processing the data--%>
                <%--contentType: false, // Prevent jQuery from setting content type--%>
                <%--success: function (response) {--%>
                    <%--// Parse the JSON response--%>
                    <%--const jsonResponse = JSON.parse(response);--%>

                    <%--// Display the response message--%>
                    <%--if (jsonResponse.status === 200) {--%>
                        <%--$("#responseMessage").html(`--%>
                            <%--<div class="alert alert-success" role="alert">--%>
                                <%--${jsonResponse.message}--%>
                            <%--</div>--%>
                        <%--`);--%>
                    <%--} else {--%>
                        <%--$("#responseMessage").html(`--%>
                            <%--<div class="alert alert-danger" role="alert">--%>
                                <%--${jsonResponse.message}--%>
                            <%--</div>--%>
                        <%--`);--%>
                    <%--}--%>
                <%--},--%>
                <%--error: function (xhr, status, error) {--%>
                    <%--$("#responseMessage").html(`--%>
                        <%--<div class="alert alert-danger" role="alert">--%>
                            <%--An error occurred: ${error}--%>
                        <%--</div>--%>
                    <%--`);--%>
                <%--}--%>
            <%--});--%>
        <%--});--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
