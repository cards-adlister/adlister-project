<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <%--// obtaining inputs for text area so they dont disappear when an incorrect input or field is submitted--%>
    <% String title = request.getParameter("title");
        if (title == null) title = "";
        String description = request.getParameter("description");
        if (description == null) description = "";
    //not currently working
        //Double price = request.getParameter("price");
        //if (price == null) price = 0.00;
        String image = request.getParameter("image");
        if (image == null) image = "";
    %>
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text" aria-required="true" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text" aria-required="true" required></textarea>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input id="price" name="price" class="form-control" type="text" aria-required="true" required>
            </div>
            <div class="form-group">
                <label for="image">Image</label>
                <textarea id="image" name="image" class="form-control" type="text" aria-required="true" required></textarea>
            </div>
            <div>
                <h4>Select Categories: </h4>
                <c:forEach var="category" items="${categories}">
                    <input type="checkbox" name="category" id="category-${category.getId()}" value="${category.getId()}">
                    <label for="category-${category.getId()}">${category.getName()}</label>
                </c:forEach>
            </div>
            <div>
                <h4>Select Categories: </h4>
                <c:forEach var="category" items="${categories}">
                    <input type="checkbox" name="category" id="category-${category.getId()}" value="${category.getId()}">
                    <label for="category-${category.getId()}">${category.getName()}</label>
                </c:forEach>
            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
    <%--// list through error messages and display the correct one--%>
    <c:if test="${requestScope.listOfErrors.size() > 0}">
        <div id="errors" class="alert alert-danger">
            <p>Unable to register user!</p>
            <ul>
                <c:forEach var="message" items="${requestScope.listOfErrors}">
                    <li><c:out value="${message}"></c:out></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    </div>
</body>
</html>
