<%@page import="model.PatientRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="./CSS/main/mainlayout/bootstrap.min.css" />
 
 <script src="./js/jquery-3.2.1.min.js"></script>
 <script src="./js/registersubmit.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-9">
          <h1>Patient Management</h1>
          
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

  <div id="alertSuccess" class="alert alert-success">
        <%
            out.print(session.getAttribute("statusMsg"));
        %>
  </div>
  <div id="alertError" class="alert alert-danger"></div> 
          
<div id="divItemsGrid">
<%
PatientRepository patient=new PatientRepository();
out.print(patient.getAllPatients());
%>
</div>
</body>
</html>