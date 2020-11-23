<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <%--// obtaining inputs for text area so they dont disappear when an incorrect input or field is submitted--%>
    <% String username = request.getParameter("username");
        if (username == null) username = "";
        String email = request.getParameter("email");
        if (email == null) email = "";
    %>
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" value="<%=username%>" aria-required="true" required>
                <p class="text-danger">
                    <c:out value="${sessionScope.message}"/>
                    <c:remove var="message" scope="session"/>
                </p>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" value="<%=email%>" aria-required="true" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" aria-required="true" required>
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password" aria-required="true" required>
            </div>

            <input type="submit" class="btn btn-primary btn-block">
        </form>
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

    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>
</html>
