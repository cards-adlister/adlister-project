<%--
  Created by IntelliJ IDEA.
  User: shyguysky
  Date: 11/16/20
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
      <h1>${ad.title}</h1>
        <div>${ad.description}</div>
        <div>${user.username}</div>
</div>
</body>
</html>
