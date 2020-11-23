<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
<<<<<<< HEAD
        <div class="navbar-collapse">
            <!-- Brand and toggle get grouped for better mobile display -->


            <a class="navbar-brand" href="/ads">
                <img src="<c:url value="/img/BM_white.png"/>" height="65" class="d-inline-block align-top" alt="Beyond Monopoly Logo with game board">
            </a>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form action="/ads/search" class="form-inline" role="search" method="GET">
                        <input id="search" name="search" class="form-control" type="search" placeholder="Search Games"/>
                        <button class="btn btn=outline-success" type="submit"><i class="fas fa-search">Search</i></button>
                    </form>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <li><a href="/ads/create">Create Ad</a></li>
<%--                        <li><a href="/profile">${sessionScope.user.username}</a> </li>--%>
<!--                         <li><a href="/profile">My Profile</a> </li> -->
                        <li><a href="/profile">${sessionScope.user.username}'s Profile</a> </li>
                        <li><a href="/logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
<%--                        <li>--%>
<%--&lt;%&ndash;                        <form action="/ads/search" class="form-inline" role="search" method="GET">&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <input id="userSearch" name="search" class="form-control" type="search" placeholder="Search Games"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            <button class="btn btn=outline-success" type="submit"><i class="fas fa-search">Search</i></button>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        </form>&ndash;%&gt;--%>
<%--                        </li>--%>
                        <li><a href="/register">Register</a></li>
                        <li><a href="/login">Login</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
=======
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Login</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
>>>>>>> fc613a62857fe205549cf62f1a48c67d349cadc5
    </div><!-- /.container-fluid -->
</nav>
