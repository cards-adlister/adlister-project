<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Beyond Monopoly!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <%--logo--%>
    <div class="container">

        <img src="<c:url value="/img/BMLogo-hero.png"/>" height="35%" class="indexImage" alt="Beyond Monopoly Logo with game board">
    </div>
    <%--carousel--%>
<%--    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">--%>
<%--        <div class="carousel-inner">--%>
<%--            <div class="carousel-item active">--%>
<%--                <img src="img/BMLogo.png" class="d-block w-100" alt="...">--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--                <img src="img/BMLogo.png"class="d-block w-100" alt="...">--%>
<%--            </div>--%>
<%--            <div class="carousel-item">--%>
<%--                <img src="img/BMLogo.png" class="d-block w-100" alt="...">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">--%>
<%--            <span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
<%--            <span class="sr-only">Previous</span>--%>
<%--        </a>--%>
<%--        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">--%>
<%--            <span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
<%--            <span class="sr-only">Next</span>--%>
<%--        </a>--%>
<%--    </div>--%>
<jsp:include page="WEB-INF/partials/scripts.jsp" />

</body>
</html>
