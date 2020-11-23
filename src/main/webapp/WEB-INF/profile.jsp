<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
=======
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <a href="/updateProfile/${user.id}" class="btn btn-primary">Edit Profile</a>
    </div>

<<<<<<< HEAD
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2 ><a class="card-title" href="/delete/${ad.id}">${ad.title}</a></h2>
            <img src="${ad.image}"  style="height: 300px">
            <p class="card-text">${ad.description}</p>
            <p class="card-text"><fmt:formatNumber value = "${ad.price}" type = "currency"/></p>
        </div>
    </c:forEach>

    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
=======
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
</body>
</html>
