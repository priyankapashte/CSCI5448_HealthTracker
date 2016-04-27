<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Patients</title>
</head>
<body>
<div style="${Display}">
<form method= "post" action="view" >	
<table>
	<tr><td><form:radiobuttons path="${patients}" items="${patientsList}" name="listedPatients" element="li"/><td></tr>
	<tr>
<td><input type="submit" name="ViewHealthParameters" value="View Health Parameters"></td></tr>
<tr><td><input type="submit" name="viewProfile" value="View Profile"></td>
</tr>
</table>
</form>
<a href='homepageDoctor'>Home Page</a>
</div>
</body>
</html>