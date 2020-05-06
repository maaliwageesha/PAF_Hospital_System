<%@page import="model.PatientRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 
<!-- Stylesheets -->
    
    <link rel="stylesheet" href="./CSS/main/mainlayout/font-awesome.min.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/flaticon.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/owl.carousel.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/style.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/animate.css" />
    <link rel="stylesheet" href="./CSS/main/mainlayout/bootstrap.min.css" />
    
   <script src="./Components/jquery-3.2.1.min.js"></script>
   <script src="./Components/registersubmit.js"></script>
<title>Update page</title>
</head>
<body>

<!-- Header section -->
 <header class="header-section">
    <jsp:include page="./layouts/header.jsp" />  
 </header>
    
<main>

 <div class="container">
<div >
<div class="col-10" >

          <h1>Edit Patient</h1>
          
<div id="alertSuccess" class="alert alert-success">
        <%
            out.print(session.getAttribute("statusMsg"));
        %>
</div>
<div id="alertError" class="alert alert-danger"></div> 
  
<form id="formPatient" name="formPatient">
First name:
    <input id="firstName" name="firstName" type="text"
    class="form-control form-control-sm">
<br> Last name:
    <input id="lastName" name="lastName" type="text"
    class="form-control form-control-sm">
<br>NIC:
    <input id="Nic" name="Nic" type="text"
    class="form-control form-control-sm">
<br> Email:
    <input id="email" name="email" type="email"
    class="form-control form-control-sm"><br>
<fieldset class="form-group">
 <div class="row">
   <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
<div class="col-sm-10">
<div class="form-check">
    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="Male" checked>
    <label class="form-check-label" for="gridRadios1">
        Male
    </label>
</div>
<div class="form-check">
    <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="Female">
    <label class="form-check-label" for="gridRadios2">
       Female
    </label>
</div>
</div>
</div>
</fieldset>
<br> Address:
     <input id="address" name="address" type="text"
     class="form-control form-control-sm">
<br> password:
     <input id="password" name="password" type="password"
     class="form-control form-control-sm">
<br> city:
     <input id="city" name="city" type="text"
     class="form-control form-control-sm">
<br> contact:
     <input id="contact" name="contact" type="number"
     class="form-control form-control-sm">
<br>
     <input id="btnSave" name="btnSave" type="button"value="Save" class="btn btn-primary">
    <input type="hidden" id="hidpatientIDSave" name="hidpatientIDSave" value="">
</form>
</div>
</div>
<br>
<div id="divItemsGrid">
<%
PatientRepository patient=new PatientRepository();
out.print(patient.getAllPatients());
%>
</div>
<br>
</div>
</main>

<jsp:include page="./layouts/footer.jsp" /> 
<!--====== Javascripts & Jquery ======-->
    <script defer src="./Components/jquery-3.2.1.min.js"></script>
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