<%-- 
    Document   : Dashboard
    Created on : Sep 22, 2022, 10:42:09 PM
    Author     : Legon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <script src="js/main.js" type="text/javascript"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
        integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.9.1/chart.min.js" integrity="sha512-ElRFoEQdI5Ht6kZvyzXhYG9NqjtkmlkfYk0wr6wHxU9JEHakS7UJZNeml5ALk+8IKlU6jDgMabC3vkumRokgJA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>

<body>
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
            <img src="https://9mobi.vn/cf/images/2015/04/nkk/hinh-avatar-dep-1.jpg" width="40" height="40"
                style="border-radius: 60px;">
            <li class="nav-item dropdown btn btn-outline-success ">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    Menu
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">DashBoard</a>
                    <a class="dropdown-item" href="#">User Profile</a>
                    <a class="dropdown-item" href="#">Change Password</a>

                    <div class="dropdown-divider"></div>

                    <a class="dropdown-item" href="#">Logout</a>
                </div>
            </li>
        </div>
    </nav>
    <div class="row">
        <div class="col-md-3 siderbar">
            <h4 style="text-align: center;">Content Management</h4>
            <a href="">Manage Subject</a>
            <a href="">Manage Setting</a>
            <a href="">Manage Lessons</a>
            <h4 style="text-align: center;">Content Management</h4>
            <a href="">Manage Classes</a>
            <a href="">Class Setting</a>
            <a href="">Class Lessons</a>
            <a href="">Manage Team</a>
            <a href="">Web contact</a>
        </div>
        <div class="col-md-9 maincontent">
            <div class="row">
                <form>
                    <div style="display: flex; justify-content: flex-start;" class="form_dashboard">
                        <div>
                            <label> Selected Date</label>
                            <input type="date" class="form-control">
                        </div>
                        <div>

                            <label>State</label>
                            <select class="form-control">
                                <option>HP</option>
                                <option>MP</option>
                                <option>SP</option>
                            </select>
                        </div>
                        <div>

                            <label>District</label>
                            <select class="form-control">
                                <option>Hanoi</option>
                                <option>SaiGon</option>
                                <option>Vinh</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div>
                        <h3>123</h3>
                        <p class="badge badge-primary">Confirmed</p>
                        <div style="width:95%;">
                            <canvas id="myChart1"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <h3>18</h3>
                        <p class="badge badge-primary">Decreased</p>
                    </div>
                    <div style="width:95%;">
                        <canvas id="myChart2"></canvas>
                    </div>
                </div>
                <div class="col-md-6">

                    <div>
                        <h3>1000</h3>
                        <p class="badge badge-primary">Recovered</p>
                    </div>
                    <div style="width:95%;">
                        <canvas id="myChart3"></canvas>
                    </div>
                </div>
                <div class="col-md-6">
                    <div>
                        <h3>2532</h3>
                        <p class="badge badge-primary">Tested </p>
                    </div>
                    <div style="width:95%;">
                        <canvas id="myChart4"></canvas>
                    </div>
                </div>
            </div>

        </div>
    </div>
    
    <script>
        const labels = [
            'January',
            'February',
            'March',
            'April',
            'May',
            'June',
        ];

        const data = {
            labels: labels,
            datasets: [{
                label: 'My First dataset',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: [0, 10, 5, 2, 20, 30, 45],
            }]
        };

        const config = {
            type: 'line',
            data: data,
            options: {}
        };
    </script>
    <script>
        const myChart1 = new Chart(
            document.getElementById('myChart1'),
            config
        );
    </script>
    <script>
        const myChart2 = new Chart(
            document.getElementById('myChart2'),
            config
        );
    </script>
    <script>
        const myChart3 = new Chart(
            document.getElementById('myChart3'),
            config
        );
    </script>
    <script>
        const myChart4 = new Chart(
            document.getElementById('myChart4'),
            config
        );
    </script>

    <footer style="background-color: lightgray; padding: 20px;">
        <H3 style="text-align: center;">@Copy right Group 3</H3>
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
