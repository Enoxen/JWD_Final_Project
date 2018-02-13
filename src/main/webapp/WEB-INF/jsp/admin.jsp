<%--
  Created by IntelliJ IDEA.
  User: Y50-70
  Date: 12.02.2018
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/css/swiper.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Pacifico|Pontano+Sans" rel="stylesheet">
    <link rel="stylesheet" href="../../assets/css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
</head>
<body>

<section id="navbar">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="logo">
                <a href="../../index.jsp" class="logo_name">CinemaScore</a>
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
                        <a class="nav-link" href="#">Top</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Search</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Rating</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control search mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <label class="search-icon"><a href="search.jsp"><i class="fa fa-sliders" aria-hidden="true"></i></a></label>
                </form>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" data-toggle="modal" data-target="#loginModal">Login</button>
                <div class="lang"><a href="">RU</a> | <a class="active" href="">EN</a></div>
            </div>
        </nav>
    </div>
</section>

<section id="admin">
    <div class="container">
        <h3 class="title">Admin Information</h3>
        <div class="row admin">
            <div class="admininfo">
                <h3>Admin Name <span><button class="btn btn-outline-primary" data-dismiss="modal" data-toggle="modal" data-target="#changeName">Change</button></span></h3>
                <h3>Admin Email <span><button class="btn btn-outline-primary">Change</button></span></h3>
                <h3>Password <span><button class="btn btn-outline-primary">Change</button></span></h3>
            </div>
        </div>
        <button type="button" class="btn btn-outline-primary simple-collapse" data-toggle="collapse" data-target="#demo" aria-expanded="true" aria-controls="add">Management</button>
    </div>
</section>
<div id="demo" class="collapse">
    <section id="adminoptions">
        <form action="">
            <input type="hidden" name="command" value="film">
            <div class="container">
                <h3 class="title">Administration</h3>
                <div class="row">
                    <div class="container">
                        <h4>Ban/Unban User</h4>
                        <div class="form-group row">
                            <div class="col-5">
                                <input class="form-control" type="text" placeholder="Text user login" id="banInput">
                            </div>
                            <label for="example-text-input" class="col-1"><button class="btn btn-outline-primary">Ban</button></label>
                            <div class="col-5">
                                <input class="form-control" type="text" placeholder="Text user login" id="unbanInput">
                            </div>
                            <label for="example-text-input" class="col-1"><button class="btn btn-outline-primary">Unban</button></label>
                        </div>
                        <h4>Give/Take Admin Rights</h4>
                        <div class="form-group row">
                            <div class="col-5">
                                <input class="form-control" type="text" placeholder="Text user login" id="giveInput">
                            </div>
                            <label for="example-text-input" class="col-1"><button class="btn btn-outline-primary">Add</button></label>
                            <div class="col-5">
                                <input class="form-control" type="text" placeholder="Text user login" id="takeInput">
                            </div>
                            <label for="example-text-input" class="col-1"><button class="btn btn-outline-primary">Take</button></label>
                        </div>
                        <h4>Add Film</h4>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="example-text-input" class="col-form-label collapse">Film EN Title:</label>
                                <input class="form-control" type="text" placeholder="Text film EN title">
                            </div>
                            <div class="col-6">
                                <label for="example-text-input" class="col-form-label">Film RU Title:</label>
                                <input class="form-control" type="text" placeholder="Text film RU title">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="example-text-input" class="col-form-label">Film year:</label>
                                <input class="form-control" type="text" placeholder="Text film year">
                            </div>
                            <div class="col-6">
                                <label for="example-text-input" class="col-form-label">Film poster:</label>
                                <input class="form-control" type="file" placeholder="Text film RU title">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <label id="kek" for="example-text-input" class="col-form-label kek">Actors RU:</label>
                                <input class="form-control" type="text" placeholder="Text actors in Russian">
                            </div>
                            <div class="col-12">
                                <label for="example-text-input" class="col-form-label">Actors EN:</label>
                                <input class="form-control" type="text" placeholder="Text actors in English">
                            </div>
                            <div class="col-12">
                                <label for="example-text-input" class="col-form-label">Directors RU:</label>
                                <input class="form-control" type="text" placeholder="Text directors in Russian">
                            </div>
                            <div class="col-12">
                                <label for="example-text-input" class="col-form-label">Directors EN:</label>
                                <input class="form-control" type="text" placeholder="Text actors in English">
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-6">
                                <label for="example-text-input" class="col-form-label">Film RU description:</label>
                                <textarea class="form-control" type="text" placeholder="Text film RU description"></textarea>
                            </div>
                            <div class="col-6">
                                <label for="example-text-input" class="col-form-label">Film EN description:</label>
                                <textarea class="form-control" type="text" placeholder="Text film EN description"></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-12">
                                <label for="example-text-input" class="col-form-label">Film genres:</label>
                                <input class="form-control" type="text" placeholder="Text film genres" id="example-text-input">
                            </div>
                        </div>
                        <div class="form-group row col">
                            <button class="btn btn-outline-primary">Add</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </section>
</div>
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
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                    <input type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1"><br>
                </div>
                <a href="" data-dismiss="modal" data-toggle="modal" data-target="#regModal">Don't have an account? CLICK HERE!!!</a>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" data-toggle="modal" data-target="#forgotPassword">Forgot Passoword?</button>
                <button type="button" class="btn btn-primary">Login</button>
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
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                    <input type="password" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">REG ME!</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="forgotPassword" tabindex="-1" role="dialog" aria-labelledby="loginModalTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="forgotPasswordTitle">Forgot Password</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <input type="email" class="form-control" placeholder="Email" aria-label="Email" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#enterCode">Send me</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="enterCode" tabindex="-1" role="dialog" aria-labelledby="loginModalTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Enter Code</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Code" aria-label="Code" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Click</button>
            </div>
        </div>
    </div>
</div>
<form>
    <div class="modal fade" id="changeName" tabindex="-1" role="dialog" aria-labelledby="loginModalTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Change Name</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Code" aria-label="Code" aria-describedby="basic-addon1">
                    </div>
                </div>
                <div class="modal-footer" scroll>
                    <button type="button" class="btn btn-primary">Click</button>
                </div>
            </div>
        </div>
    </div>
</form>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.0.7/js/swiper.min.js"></script>
<script src="../../assets/js/main.js"></script>
</body>
</html>
