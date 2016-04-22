<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppointmentScheduler</title>
    </head>
    <body>
    <!--Added buttons to handle edit profile request: Shreya -->
    <H2>Welcome ${patient.userName}! </H2>
    <H3>Following are your details details:</H3>
    <label> Age: ${patient.age}</label><br>
    <label> Height: ${patient.height}</label><br>
    <label> First Name: ${patient.firstName}</label><br>
    <label> Last Name: ${patient.lastName}</label><br>
    <form action="welcomePatient" method="post">
       <input type="submit" name="appoint" value="Appointment Scheduler">
       <input type="submit" name="edit" value="Edit Profile">
    </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
