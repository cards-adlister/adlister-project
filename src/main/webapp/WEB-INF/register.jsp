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
    <div class="container">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text" aria-required="true" required>
                <p class="text-danger">
                    <c:out value="${sessionScope.message}"/>
                    <c:remove var="message" scope="session"/>
                </p>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text" aria-required="true" required>
                <p class="text-danger">
                    <c:out value="${sessionScope.emessage}"/>
                    <c:remove var="emessage" scope="session"/>
                </p>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password" aria-required="true" required>
            </div>
            <p class="text-danger">
                <c:out value="${sessionScope.pwmessage}"/>
                <c:remove var="pwmessage" scope="session"/>
            </p>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password" aria-required="true" required>
            </div>

            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</body>
</html>
