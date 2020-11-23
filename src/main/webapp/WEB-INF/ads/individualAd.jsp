<%--
  Created by IntelliJ IDEA.
  User: shyguysky
  Date: 11/16/20
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
      <h1 class="card-title">${ad.title}</h1>
        <img src="${ad.image}" style="height: 300px" alt="${ad.title}">
        <div class="card-text">Description: ${ad.description}</div>
        <div class="card-text">Price: <fmt:formatNumber value = "${ad.price}" type = "currency"/></div>
        <div class="card-text">Posted By: ${user.username}</div>
    <a href="/ads" class="btn btn-primary">Back to Ads</a>
</div>
</body>
</html>
