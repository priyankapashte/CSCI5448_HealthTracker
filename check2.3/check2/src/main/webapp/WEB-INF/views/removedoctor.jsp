<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Doctor</title>
</head>
<body>
<form method= "post" action="DeselectDoctor" >
<table>

<tr>
<td>Advising Doctor:</td>
<td><div id="advdoctor" align='center'>${DocInfo}</div></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Deselect"></td>
</tr>
<tr>
</table>
</form>
</body>
</html>