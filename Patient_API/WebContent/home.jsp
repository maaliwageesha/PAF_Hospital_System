<%@page import="model.PatientRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="./CSS/main/mainlayout/bootstrap.min.css" />
 
 <script src="./js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>



<div id="divItemsGrid">
<%
PatientRepository patient=new PatientRepository();
out.print(patient.getAllPatients());
%>
</div>
</body>
</html>