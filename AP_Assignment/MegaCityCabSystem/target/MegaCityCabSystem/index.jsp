<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Cab Service</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .jumbotron {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.1);
        }
        .btn-primary {
            background-color: #007bff;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="jumbotron text-center">
        <h1 class="display-4">Welcome to MegaCity Cab System</h1>
        <p class="lead">Your reliable transportation solution</p>
        <hr class="my-4">
        <p>Please login to continue to our services</p>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/auth/login" role="button">Login</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
