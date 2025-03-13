<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/12/2025
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mega City Cab - Login</title>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bg-light">
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Mega City Cab</h3>
                    <p>Login to access the system</p>
                </div>
                <div class="card-body">
                    <%--<% if (request.getAttribute("error") != null) { %>--%>
                    <%--<div class="alert alert-danger">--%>
                        <%--<%= request.getAttribute("error") %>--%>
                    <%--</div>--%>
                    <%--<% } %>--%>
                        <!-- Error/Success Message Container -->
                        <div id="message" class="alert" style="display: none;"></div>
                    <form id="loginForm">
                        <div class="mb-3">
                            <label for="username" class="form-label">Username</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="mb-3">
                            <label for="role" class="form-label">Login As</label>
                            <select class="form-select" id="role" name="role" required>
                                <option value="admin">Admin</option>
                                <option value="driver">Driver</option>
                            </select>
                        </div>
                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form>
                    <div class="text-center mt-3">
                        <a href="${pageContext.request.contextPath}/customer/register.jsp">Register as a Customer</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        // Handle form submission via AJAX
        $('#loginForm').on('submit', function (event) {
            event.preventDefault(); // Prevent the default form submission

            // Get form data
            var formData = {
                userName: $('#username').val(),
                password: $('#password').val(),
                role: $('#role').val()
            };

            // Send AJAX request
            $.ajax({
                url: '${pageContext.request.contextPath}/login',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(formData),
                success: function (response) {
                    if (response.status === 200) {
                        // Login successful
                        $('#message').removeClass('alert-danger').addClass('alert-success').text(response.message).show();
                        // Redirect to the appropriate dashboard
                        window.location.href = response.redirectUrl;
                    } else {
                        // Login failed
                        $('#message').removeClass('alert-success').addClass('alert-danger').text(response.message).show();
                    }
                },
                error: function (xhr, status, error) {
                    // Handle server errors
                    $('#message').removeClass('alert-success').addClass('alert-danger').text('An error occurred. Please try again.').show();
                }
            });
        });
    });
</script>
<%--<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></scra--%>
</body>
</html>
