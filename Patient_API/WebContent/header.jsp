
<div class="container">
    <!-- Site Logo -->
    <a href="/" class="site-logo">
    <div style="height:0px">
      <img src="./images/main/mainlayout/logo_image.png" height="100" alt="">
        </div>
    </a>
    <!-- responsive -->
    <div class="nav-switch">
        <i class="fa fa-bars"></i>
    </div>
 
    <!-- Main Menu -->
    <ul class="main-menu">
        <li><a href="/">Home</a></li>
        <li><a href="/about">About</a></li>
        <li><a href="/search-product">Shop</a></li>
        <li><a href="/ServiceTest">Services</a></li>
        <li><a href="/gallery">Gallery</a></li>
        <li><a href="/contact2">Contact</a></li>
        <!-- <li><a href="elements.html"><i class="flaticon-020-decay"></i></a></li> -->
       
     <!--    <li class="dashboard-style"><a href="/login">Dashboard</a></li>
        <li class="logout-style"><a class="logout-style" href="" onclick="event.preventDefault();
            document.getElementById('logout-form').submit();">
             
            </a></li> -->

        <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
       
        </form>
  
        <li class="login-style"><a href="/PatientAPI/login.jsp">Sign In</a></li>
     
    </ul>
</div>