
<!DOCTYPE html>
<html lang="en">

<head>
    <title></title>
    <meta charset="UTF-8">
    <meta name="description" content="IHHRI">
    <meta name="keywords" content="homeopathic clinic">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Favicon -->
    <link href="img/favicon.ico" rel="shortcut icon" />

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="./CSS/main/mainlayout/bootstrap.min.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/font-awesome.min.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/flaticon.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/owl.carousel.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/style.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/animate.css" />

	<link rel="stylesheet" href="./CSS/main/login/login.css">

  

</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header section -->
    <header class="header-section">
        
      <jsp:include page="header.jsp" />  
    </header>

    <main class="py-4">

        
      
 <div class="container">
        
        
        
        
        
        
        
        
        
        <div class="container">
    <div class="row">
        <div class="col-md-6">
            <img class="d-none d-md-block" src="./images/main/login/welcome_image.jpg" alt="">
        </div>
        <div class="col-md-6 col-12 justify-content-center align-self-center">

            <h3 class="header">Login</h3>
            <hr>
            <form class="form" action="" method="POST">
              
                <div class="form-group">
                    <input id="email" type="email" class="form-control"
                        name="email" value="" required autocomplete="email" autofocus>

                  
                    <span class="invalid-feedback" role="alert">
                        <strong>message</strong>
                    </span>
          
                </div>
                <div class="form-group">
                    <input id="password" type="password" class="form-control"
                        name="password" required autocomplete="current-password">

               
                    <span class="invalid-feedback" role="alert">
                        <strong>message</strong>
                    </span>
               
                </div>

                <div class="form-group row">
                    <div class="col-md-6 offset-md-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="remember" id="remember"
                                >

                            <label class="form-check-label" for="remember">
                              remember me
                            </label>
                        </div>
                    </div>
                </div>

                <input class="btn btn-primary form-control" type="submit" value="Login">

            </form>

            <!-- Remind Passowrd -->
            <div id="formFooter">
                <a class="underlineHover" href="">Forgot Password?</a>
                <p> Or </p>
                <a class="underlineHover" href="/PatientAPI/register.jsp">Haven't created an account yet?</a>
            </div>

        </div>
    </div>
</div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            
       
        </div>

    </main>
  
    <jsp:include page="footer.jsp" /> 


    <!--====== Javascripts & Jquery ======-->
    <script defer src="./js/jquery-3.2.1.min.js"></script>
    <script defer src="./js/bootstrap.min.js"></script>
    <script defer src="./js/owl.carousel.min.js"></script>
    <script defer src="./js/circle-progress.min.js"></script>
    <script defer src="./js/main.js"></script>

    <!--selector bootstrap javascript-->
   

    <!--bootstrap javascript-->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>

   

</body>

</html>