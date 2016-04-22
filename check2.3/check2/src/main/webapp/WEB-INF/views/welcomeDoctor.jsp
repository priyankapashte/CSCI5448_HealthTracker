<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppointmentScheduler</title>
    </head>
    <body>
    <!-- Added button to edit profile:Shreya -->
    <H3>Welcome ${doctor.userName}! </H3>
    <form action="welcomeDoctor" method="post">
       <input type="submit" name="appoint" value="Appointment Scheduler">
       <input type="submit" name="edit" value="Edit Profile">
    </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
