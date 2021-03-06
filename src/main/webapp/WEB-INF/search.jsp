<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Results" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Your search results:</h1>
    </div>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2 ><a class="card-title" href="/ad/${ad.id}">${ad.title}</a></h2>
            <img src="${ad.image}"  style="height: 300px">
            <p class="card-text">${ad.description}</p>
        </div>
    </c:forEach>

    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>
</html>
