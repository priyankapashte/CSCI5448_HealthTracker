<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppointmentScheduler</title>
    </head>
    <body>
    <H3>Welcome ${firstName} </H3>
    <form action="welcomePatient" method="post">
       <input type="submit" name="appoint" value="Appointment Scheduler">
    </form>
    <form action="SetDoctor" method="post">
       <input type="submit" name="setdoc" value="Select/Deselect Advising Doctor">
    </form>
    <a href='logout'>Log out</a>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
