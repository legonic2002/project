<%-- 
    Document   : Login
    Created on : Sep 22, 2022, 10:19:21 PM
    Author     : Legon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script src="js/main.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>

<body >
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="https://9mobi.vn/cf/images/2015/04/nkk/hinh-avatar-dep-1.jpg" width="30" height="30" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </li>
            </ul>
            <a href="Login.jsp" class="btn btn-outline-success my-2 my-sm-0" style="margin-right: 10px;">Login</a>
            <a href="register.jsp" class="btn btn-outline-success my-2 my-sm-0" style="margin-right: 10px;">Register</a>
        </div>
    </nav>




   


    <div class="row" style="margin: 20px;">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <h1 style="text-align: center;">Login</h1>
            <form>
                <!-- Email input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="form2Example1">Email address</label>

                    <input type="email" id="form2Example1" class="form-control" />
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="form2Example2">Password</label>

                    <input type="password" id="form2Example2" class="form-control" />
                </div>

                <!-- 2 column grid layout for inline styling -->
                <div class="row mb-4">
                    

                    <div class="col">
                        <!-- Simple link -->
                        <a href="forgotpass.jsp">Forgot password?</a>
                    </div>
                </div>

                <!-- Submit button -->
                <button type="button" class="btn btn-primary btn-block mb-4">Sign in</button>

                <!-- Register buttons -->
                <div class="text-center">
                    <p>Not a member? <a href="register.jsp">Register</a></p>
                    <p>or sign up with:</p>
                    
                   <a class="d-block small mt-3" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:9999/WebApplication2/login-google&response_type=code&client_id=516136248040-tl720shd66lpslge5lheh0pd6b7sbc3m.apps.googleusercontent.com&approval_prompt=force">Sign in With Google</a>  

                    <button type="button" class="btn btn-link btn-floating mx-1">
                        <i class="fab fa-google"></i>
                    </button>

                    
                </div>
            </form>
        </div>
    </div>



    <footer>
        <div class="container-fluid">
            <div class="row" id="footer_top">
                <div>
                    <a href="">Giới thiệu</a>
                    <a href="">Hỏi & đáp</a>
                    <a href="">Chính sách bảo mật</a>
                </div>
                <div class="right">
                    Kết nối cùng chúng tôi
                    <i class="fa-brands fa-facebook"></i>
                    <i class="fa-brands fa-youtube"></i>
                    <i class="fa-brands fa-twitter"></i>
                </div>
            </div>
            <div class="row" id="footer_bot">
                <div class="col-md-6">
                    <h1>ĐỊA CHỈ VÀ THÔNG TIN LIÊN HỆ</h1>
                    <div class="row" style="padding: 10px;background-color: aliceblue;">
                        <div class="col-md-6">
                            <p>Đại học fpt, Thạch Thất, Hà Nội</p>
                            <p><b>MST:</b> 0123654987</p>
                        </div>
                        <div class="col-md-6">
                            <p><b>TEL:</b> (028)22222364</p>
                            <p> <b>HotLine:</b>1900 343 463 </p>
                            <p><b>Email:</b> chamsockhachhang@gmail.com</p>
                        </div>

                    </div>
                </div>

                <div class="col-md-6">
                    <h1>Liên hệ cần hỗ trợ hoặc nhận thông tin</h1>
                    <div>
                        <form>
                            <div class="row">
                                <div class="col-md-6">
                                    <input placeholder="Họ Tên(*)" class="form-control input-contact" name="name">
                                </div>
                                <div class="col-md-6 ">
                                    <input placeholder="Loại liên hệ(*)" class="form-control input-contact" name="name">
                                </div>
                                <div class="col-md-6 ">
                                    <input placeholder="Email(*)" class="form-control input-contact" name="name">

                                </div>
                                <div class="col-md-6 ">
                                    <input placeholder="Số điện thoại(*)" class="form-control input-contact"
                                        name="name">
                                </div>
                                <div class="col-md-12 ">
                                    <textarea class="form-control input-contact ">

                                        </textarea>
                                </div>
                                <a class="btn btn-primary" style="margin-left: 25px;">Gửi thông tin</a>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        </div>
        </div>

    </footer>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>
