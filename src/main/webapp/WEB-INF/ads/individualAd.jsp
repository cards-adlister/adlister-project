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
          <h1>${ad.title}</h1>
            <img src="${ad.image}" style="height: 300px; width: 300px" alt="${ad.title}">
            <div>Description: ${ad.description}</div>
            <div>
                <p> Price: <fmt:formatNumber value = "${ad.price}" type = "currency"/> </p>
                <p> Category(s):
                    <c:forEach var="c" items="${categories}">${c.getName()}  </c:forEach>
                </p>
            </div>
            <div>Posted By: ${user.username}</div>
        <a href="/ads" class="btn btn-primary">Back to Ads</a>
    </div>

    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>
</html>
