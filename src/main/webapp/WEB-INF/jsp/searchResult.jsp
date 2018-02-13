<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/css/swiper.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Pacifico|Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../../assets/css/style.css">
</head>
<body>

<section id="navbar">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="logo">
                <a href="${pageContext.request.contextPath}/FrontController?command=changePage&page=main" class="logo_name">CinemaScore</a>
                <div class="logo_image">
                    <div class="circles">
                        <div class="move-circle1"><img src="../../assets/img/move_circle1.png"></div>
                        <div class="move-circle2"><img src="../../assets/img/move_circle1.png"></div>
                    </div>
                    <div class="babina"><img src="../../assets/img/babina.png" alt=""></div>
                </div>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/FrontController?command=changePage&page=main">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/FrontController?command=changePage&page=top">Top</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/FrontController?command=changePage&page=search">Search</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control search mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <label class="search-icon"><a href="${pageContext.request.contextPath}/FrontController?command=changePage&page=search"><i class="fa fa-sliders" aria-hidden="true"></i></a></label>
                </form>
                <c:if test="${sessionScope.user == null}">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit" data-toggle="modal" data-target="#loginModal">Login</button>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <div>
                        <a href="${pageContext.request.contextPath}/FrontController?command=toUserPage&userPage=${sessionScope.user.userId}" class="btn btn-outline-success my-2 my-sm-0">
                                ${sessionScope.user.login}
                        </a>
                        <a href="${pageContext.request.contextPath}/FrontController?command=logOut" class="btn btn-outline-success my-2 my-sm-0 login_buttons">Log out</a>
                    </div>
                </c:if>
                <div class="lang"><a<c:if test="${sessionScope.locale eq 'ru' }"> class="active"</c:if> href="${pageContext.request.contextPath}/FrontController?command=changeLocale&locale=ru">RU</a> | <a <c:if test="${sessionScope.locale eq 'en' }"> class="active"</c:if>  href="${pageContext.request.contextPath}/FrontController?command=changeLocale&locale=en">EN</a></div>
            </div>
        </nav>
    </div>
</section>

<section>
    <div class="container search_result">
        <h3 class="title">Search Result</h3>
        <c:forEach var="item" items="${sessionScope.list}">
        <div class="row film_result">
            <%--<p class="rating_number">1</p>--%>
            <div class="result_pic" style="background-image: url(https://upload.wikimedia.org/wikipedia/ru/3/34/%D0%97%D0%B5%D0%BB%D1%91%D0%BD%D1%8B%D0%B9_%D1%81%D0%BB%D0%BE%D0%BD%D0%B8%D0%BA.jpg)"></div>
            <div class="result_info">
                <h3 class="film_name">Film Name: <a href="filmPage=${item.filmId}">${item.title}</a></h3>
                <h3 class="film_description">Film Year: ${item.year}</h3>
                <h3 class="film_description">Film Rating: ${item.rating}</h3>
            </div>
        </div>
        </c:forEach>

        <nav aria-label="Page navigation example" class="pagination">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>
</section>

<footer>
    <p>2018 © Cinema</p>
</footer>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Login</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="login" action="FrontController">
                    <div class="input-group mb-3">
                        <div class="input-group mb-3"><input type="hidden" name="command" value="sign_in"></div>
                        <div class="input-group mb-3"><input type="text" name="login" value=""  class="form-control" placeholder="Username" aria-label="Login" aria-describedby="basic-addon1" required></div>
                        <div class="input-group mb-3"><input type="password" name="password" value="" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1" required><br></div>
                    </div>
                </form>
                <a href="" data-dismiss="modal" data-toggle="modal" data-target="#regModal">New to CinemaScore? Create account.</a>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" data-toggle="modal" data-target="#forgotPassword">Forgot Passoword?</button>
                <button type="submit" form="login" class="btn btn-primary">Login</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="regModal" tabindex="-1" role="dialog" aria-labelledby="regModalTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Registration</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="FrontController">
                    <div class="input-group mb-3">
                        <input type="hidden" name="command" value="sign_up">
                        <div class="input-group mb-3"><input type="text" class="form-control" name="login" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1" required></div>
                        <div class="input-group mb-3"><input type="password" class="form-control" name="password" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1"required></div>
                        <div class="input-group mb-3"><input type="email" class="form-control" name="email" placeholder="Email" aria-label="Password" aria-describedby="basic-addon1"required></div>
                        <div class="modal-footer">
                            <input type="submit" class=" btn btn-primary" style="border-radius: 5px" value="Sign Up">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="forgotPassword" tabindex="-1" role="dialog" aria-labelledby="loginModalTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Forgot Password</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="FrontController" id="emailCheck">
                    <div class="input-group mb-3">
                        <input type="hidden" name="command" value="send_email">
                        <input type="email" name="emailCode" value="" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="basic-addon1">
                    </div>
                    <input type="submit" class="btn btn-outline-success my-2 my-sm-0 login_buttons" style="border-radius: 5px">
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/js/swiper.min.js"></script>
<script src="../../assets/js/main.js"></script>
</body>
</html>
