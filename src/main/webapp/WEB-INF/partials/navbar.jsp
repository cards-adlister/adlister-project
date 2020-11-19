<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-collapse">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/ads">Adlister</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${sessionScope.user != null}">
                        <li><form role="search" action="/search" method="GET">
                            <input type="search" name="search"/>
                            <input type="submit" >
                        </form>
                        </li>
                        <li><a href="/ads/create">Create Ad</a></li>
                        <li><a href="/profile">${sessionScope.user.username}</a> </li>
                        <li><a href="/logout">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><form role="search" action="/search" method="GET">
                            <input type="search" name="search"/>
                            <input type="submit" >
                        </form>
                        </li>
                        <li><a href="/register">Register</a></li>
                        <li><a href="/login">Login</a></li>
                    </c:otherwise>



                </c:choose>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
