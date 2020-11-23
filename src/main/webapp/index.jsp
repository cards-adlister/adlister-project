<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
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
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
