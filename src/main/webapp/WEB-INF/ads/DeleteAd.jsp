<%--
  Created by IntelliJ IDEA.
  User: courtneyholley
  Date: 11/18/20
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <form action="/delete/${ad.id}" method="POST">
        <div class="container">
            <h1 class="card-title">${ad.title}</h1>
            <img src="${ad.image}" style="height: 300px">
            <div class="card-text">${ad.description}</div>
            <div class="card-text"><fmt:formatNumber value = "${ad.price}" type = "currency"/></div>
            <input type="submit" class="btn btn-info btn-primary" value="Delete">
            <a href="/update/${ad.id}"><button class="btn btn-info btn-primary" type="button">Update</button></a>
        </div>
    </form>
</div>

<jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>
</html>
