<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form method="post" action="registerPatient">
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
                        <td><input type="text" name="firstName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="userName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td><input type="text" name="age" value="" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><form action="">
							  <input type="radio" name="gender" value="male"> Male<br>
							  <input type="radio" name="gender" value="female"> Female<br>
							  <input type="radio" name="gender" value="other"> Other
							</form>
						</td>
                    </tr>
                     <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="telephone" value="" /></td>
                    </tr>
                    <tr>
                        <td>Height(cm)</td>
                        <td><input type="text" name="height" value="" /></td>
                    </tr>
                    <tr>
                        <td>Weight(lbs)</td>
                        <td><input type="text" name="weight" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name='submit' value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>