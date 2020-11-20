<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: courtneyholley
  Date: 11/19/20
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update an existing Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>
<div class="container">
    <h1>Update This Ad</h1>
    <form action="/update/${ad.id}" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control"
                      type="text" required>${ad.description}</textarea>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <textarea id="price" name="price" class="form-control"
                      type="text" required>${ad.price}</textarea>
        </div>
        <div class="form-group">
            <label for="image">Image</label>
            <textarea id="image" name="image" class="form-control"
                      type="text">${ad.image}</textarea>
        </div>
        <div>
            <h4>Select Categories: </h4>
            <c:forEach var="category" items="${categories}">
                <input type="checkbox" name="category" id="category-${category.getId()}" value="${category.getId()}">
                <label for="category-${category.getId()}">${category.getName()}</label>
            </c:forEach>
        </div>
        <input name="ad_id" type="hidden" value=${ad.id}>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
