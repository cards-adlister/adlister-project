<%--
  Created by IntelliJ IDEA.
  User: courtneyholley
  Date: 11/18/20
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<h2>The Ad:</h2>
<form action="/delete/${ad.id}" method="POST">
    <div class="container">
        <h1>${ad.title}</h1>
        <div>${ad.description}</div>
        <input type="submit" class="btn btn-info" value="Delete">
    </div>
</form>
</body>
</html>
