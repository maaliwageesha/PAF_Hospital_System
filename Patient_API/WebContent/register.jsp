<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <link href="./CSS/registerCSS/style.css" rel="stylesheet" type="text/css" >

     <!-- Java script files for jquery and js controllers -->
		  <script src="./Components/jquery-3.2.1.min.js"></script>
		  <script src="./Components/registersubmit.js"></script>
</head>
<body>
   
  

    <!-- Header section -->
 <header class="header-section">
     <jsp:include page="./layouts/header.jsp" />  
</header>
<main class="py-4">
    <div class="container">
    <div id="alertSuccess" class="alert alert-success"></div>
    <div id="alertError" class="alert alert-danger"></div>
       
<div class="main">
<div class="container1">
<div class="booking-content">
<div class="booking-image">
       <a ><img class="booking-img img1" src="./images/registerIMG/form-img.jpg" alt="Booking Image"></a>
</div>
<div class="booking-form">
                     
         <form id="register-form" name="register-form" class="forma"  >
         <h2 style="margin-top: -20%;">Register Yourself for Health Care System</h2>
                   
    <div class="form-group form-input">
         <input  type="text" id="firstName" class ="inputa"
          name="firstName" value="" required  autocomplete="firstName" autofocus/>
         <label for="firstName" class="form-label">Your First Name</label>
   </div>
   <div class="form-group form-input">
         <input  type="text" id="lastName" class ="inputa"
         name="lastName" value="" required autocomplete="lastName" autofocus/>
         <label for="lastName" class="form-label">Your Last Name</label>
   </div>
   <div class="form-radio">
        <label class="label-radio"> Select Your Gender</label>
   <div class="radio-item-list">
   <span class="radio-item">
         <input type="radio" class ="inputa" name="Gender" value="male" id="male" />
         <label for="male">Male</label>
  </span>
  <span class="radio-item active">
         <input type="radio" class ="inputa" name="Gender" value="female" id="female" checked="checked" />
         <label for="female">Female</label>
  </span>
  </div>
  </div>
  <div class="form-group form-input">
       <input class ="inputa" type="text" required name="Nic" id="Nic" value=""  />
       <label for="Nic" class="form-label">NIC</label>
 </div>
 <div class="form-group form-input">
       <input type="text" class ="inputa" required name="Address" id="Address" value=""  />
       <label for="Address1" class="form-label">Address</label>
 </div>
 <div class="form-group form-input">
      <input type="text" class ="inputa" required name="City" id="City" value=""  />
      <label for="City" class="form-label">City</label>
 </div>
 <div class="form-group form-input">
      <input type="number" class ="inputa" required name="phone-number" id="phone-number" value=""  />
      <label for="phone-number" class="form-label">Phone Number [eg:- 77xxxxxxx</label>
 </div>
 <div class="form-group form-input">
      <input type="email"  id="email" required class ="inputa"
      name="email" value=""  autocomplete="email"/>
      <label for="email" class="form-label">Email</label>
 </div>
 <div class="form-group form-input">
      <input type="password"  name="password" id="password" required  class ="inputa" name="password"
      autocomplete="new-password" />
      <label for="Password" class="form-label" >Password</label>
 </div>
 <div class="form-group form-input">
      <input id="password-confirm" required type="password" class ="inputa"
      name="password_confirmation"  autocomplete="new-password" />
      <label for="password_confirmation" class="form-label" >Password Confirm</label>
 </div>
 <div class="form-submit">
      <input type="button" value="Register Now" class="submit" id="submit" name="submit" />
      <a href="#" class="vertify-booking">Already a member? click to login</a>
</div>
</form>
</div>
</div>
</div>
</div>
</div>
</main>
<jsp:include page="./layouts/footer.jsp" /> 

<!--====== Javascripts & Jquery ======-->
   
    <script defer src="./js/bootstrap.min.js"></script>
    <script defer src="./js/owl.carousel.min.js"></script>
    <script defer src="./js/circle-progress.min.js"></script>
    <script defer src="./js/main.js"></script>
</body>
</html>