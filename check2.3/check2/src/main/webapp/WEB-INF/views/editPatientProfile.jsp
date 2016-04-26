<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
<H1>Edit Profile</H1>


<form method="post" action="editPatientProfile">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="${patient.firstName}" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="${patient.lastName}" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="${patient.email}" /></td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td><input type="text" name="age" value="${patient.age}" /></td>
                    </tr>
                     <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="telephone" value="${patient.telephone}" /></td>
                    </tr>
                    <tr>
                        <td>Height(cm)</td>
                        <td><input type="text" name="height" value="${patient.height}" /></td>
                    </tr>
                    <tr>
                        <td>Weight(lbs)</td>
                        <td><input type="text" name="weight" value="${patient.weight}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name='submit' value="Save" /></td>
                        <td><input type="submit" value="Cancel" onclick="welcomePatient.jsp"/></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
        <a href='homepagePatient'>Home Page</a>
</body>
</html>