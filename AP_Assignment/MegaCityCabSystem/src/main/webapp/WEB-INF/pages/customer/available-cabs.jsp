<%--
  Created by IntelliJ IDEA.
  User: amayuru_i
  Date: 3/13/2025
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Cabs</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        .filter-form {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
        }
        .form-group.inline {
            display: inline-block;
            margin-right: 15px;
        }
        .cab-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
        }
        .cab-card {
            background: #ffffff;
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .cab-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }
        .cab-image img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        .cab-details {
            padding: 20px;
        }
        .cab-details h3 {
            margin-top: 0;
        }
        .cab-actions {
            padding: 20px;
            text-align: center;
            background: #f8f9fa;
        }
        .cab-actions .btn {
            width: 100%;
        }
        .rating {
            color: #ffc107;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row mt-4">
        <div class="col-12">
            <h2 class="text-center mb-4">Available Cabs</h2>
        </div>
    </div>

    <!-- Filter Form -->
    <div class="row mb-4">
        <div class="col-12">
            <div class="filter-form">
                <form action="${pageContext.request.contextPath}/customer/AvailableCabsServlet" method="get" class="d-flex flex-wrap gap-3">
                    <div class="form-group inline">
                        <label for="cabType" class="form-label">Cab Type:</label>
                        <select id="cabType" name="cabType" class="form-select">
                            <option value="">All Types</option>
                            <%--<c:forEach items="${cabTypes}" var="cabType">--%>
                                <%--<option value="${cabType.id}" ${param.cabType eq cabType.id ? 'selected' : ''}>${cabType.name}</option>--%>
                            <%--</c:forEach>--%>
                        </select>
                    </div>

                    <div class="form-group inline">
                        <label for="sortBy" class="form-label">Sort By:</label>
                        <select id="sortBy" name="sortBy" class="form-select">
                            <option value="price" ${param.sortBy eq 'price' ? 'selected' : ''}>Price (Low to High)</option>
                            <option value="rating" ${param.sortBy eq 'rating' ? 'selected' : ''}>Rating (High to Low)</option>
                        </select>
                    </div>

                    <div class="form-group inline">
                        <button type="submit" class="btn btn-primary">Apply Filters</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Cab Grid -->
    <div class="row">
        <div class="col-12">
            <div class="cab-grid">
                <%--<c:forEach items="${availableCabs}" var="cab">--%>
                    <%--<div class="cab-card">--%>
                        <%--<div class="cab-image">--%>
                            <%--<!-- In a real application, you would have actual cab images -->--%>
                            <%--<img src="${pageContext.request.contextPath}/images/cab-${cab.type}.jpg" alt="${cab.model}">--%>
                        <%--</div>--%>
                        <%--<div class="cab-details">--%>
                            <%--<h3>${cab.model}</h3>--%>
                            <%--<p><strong>Type:</strong> ${cab.typeName}</p>--%>
                            <%--<p><strong>Capacity:</strong> ${cab.capacity} passengers</p>--%>
                            <%--<p><strong>Rating:</strong>--%>
                                <%--<span class="rating">--%>
                                        <%--<c:forEach begin="1" end="5" var="i">--%>
                                            <%--<c:choose>--%>
                                                <%--<c:when test="${i <= cab.rating}">★</c:when>--%>
                                                <%--<c:otherwise>☆</c:otherwise>--%>
                                            <%--</c:choose>--%>
                                        <%--</c:forEach>--%>
                                    <%--</span>--%>
                                <%--(${cab.rating}/5)--%>
                            <%--</p>--%>
                            <%--<p><strong>Base Fare:</strong> $${cab.baseFare}</p>--%>
                            <%--<p><strong>Per KM Rate:</strong> $${cab.perKmRate}</p>--%>
                        <%--</div>--%>
                        <%--<div class="cab-actions">--%>
                            <%--<a href="${pageContext.request.contextPath}/customer/book-cab.jsp?cabId=${cab.id}" class="btn btn-success">Book Now</a>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</c:forEach>--%>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
