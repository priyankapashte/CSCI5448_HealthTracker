<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
    <H3>Welcome ${firstName} </H3>
    <!-- shreya -->
    <form action="editDoctor" method="post">
    <input type="submit" name="edit" value="Edit Profile">
    </form>
    <form action="viewPatients" method="post">
    <input type="submit" name="viewpatients" value="view Patients">
    </form>
    <a href='logout'>Log out</a>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
