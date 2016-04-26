<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookAppointment</title>
</head>
<body>
<H1>Book Appointment</H1>

<H2>Search Doctor</H2>
<form method= "post" action="search" >
<table>

<tr>
<td><tr>Location: </tr><sf:select path="${Locations}" name= "LocationSelected">
         <sf:options items="${Location}" id="id"></sf:options>
    </sf:select></td>
</tr>

<tr>
<td><tr>Specialization: </tr><sf:select path="${Specializations}" name= "SpecializationSelected">
         <sf:options items="${Specialization}" id="id"></sf:options>
    </sf:select></td>
</tr>
<tr>
<td><tr>Sort By: </tr><select name= "SortPref">			
           <option value="firstName"> </option>
           <option value="location">Location</option>
		   <option value="specialization">Specialization</option>
    <select></td>
</tr>
<input type="text" name="date">
</table>
<input type="submit" name="Search" value="Search">
</form>
<form method= "post" action="addDoctor" >
<table>

<tr>
<td>Select a doctor:</td>
<td><form:radiobuttons path="${Doctors}" items="${Doctor}" name="SelectedDoctor"/></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Select"></td>
</tr>
<tr>
</table>
</form>
<a href='homepagePatient'>Home Page</a>
</body>
</html>