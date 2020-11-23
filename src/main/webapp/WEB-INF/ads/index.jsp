<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
<<<<<<< HEAD
    <h1>Find your new favorite game</h1>
</div>
    <c:forEach var="ad" items="${ads}" varStatus="loop">
        <div class="col-md-4">
            <div class="card" style="width: 18rem">
                <img class="card-img-top" src="${ad.image}" alt="${ad.title}" style=" height: 200px">
                <div class="card-body">
                    <h2 class="card-title">${ad.title}</h2>
                    <p class="card-text">${ad.description}</p>
                    <p class="card-text"><fmt:formatNumber value = "${ad.price}" type = "currency"/></p>
                    <a href="/ad/${loop.index + 1}" class="btn btn-primary">View Info</a>
                </div>
                <br>
            </div>
=======
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
        </div>
    </c:forEach>
</div>

    <jsp:include page="/WEB-INF/partials/scripts.jsp" />
</body>

</html>
