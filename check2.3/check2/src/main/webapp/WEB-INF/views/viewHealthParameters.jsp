<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Health Parameters</title>
</head>
<body>
<form method="POST" action="viewPatients">
<label>Average Heart rate: </label>${healthParameters.avgHeartrate}<br>
<label>Sleep: </label>${healthParameters.sleep}<br>
<label>Calories burnt: </label>${healthParameters.calories}<br>
</form>
<a href='homepageDoctor'>Home Page</a>
</body>
</html>