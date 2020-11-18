<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}" varStatus="loop">
        <div class="col-md-6">
            <div class="card" style="width: 18rem">
                <img class="card-img-top" src="${ad.image}" alt="${ad.title}" style="width: 100px; height: 100px">
                <div class="card-body">
                    <h2 class="card-title">${ad.title}</h2>
                    <p class="card-text">${ad.description}</p>
                    <a href="/ad/${loop.index + 1}" class="btn btn-primary">View Info</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>
