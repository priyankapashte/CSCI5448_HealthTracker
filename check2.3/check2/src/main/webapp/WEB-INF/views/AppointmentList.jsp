<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment List</title>
</head>
<body>
<H1>Appointment List</H1>

<form method= "post" action="selectAppointment" >
<table>
<tr>
<td>Select an appointment:</td>
<td><form:radiobuttons path="${Doctors}" items="${Doctor}" name="SelectedDoctor"/></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Select"></td>
</tr>
</table>
</form>
</body>
</html>