<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form method="post" action="registerDoctor">
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
                        <td>Availability - Days</td>
                        <td><form action="">
							  <input type="checkbox" name="day" value="Monday"> Monday<br>
							  <input type="checkbox" name="day" value="Tuesday"> Tuesday<br>
							  <input type="checkbox" name="day" value="Wednesday"> Wednesday<br>
							  <input type="checkbox" name="day" value="Thrusday"> Thrusday<br>
							  <input type="checkbox" name="day" value="Friday"> Friday<br>
							  <input type="checkbox" name="day" value="Saturday"> Saturday<br>
							  <input type="checkbox" name="day" value="Sunday"> Sunday<br>
							</form>
						</td>
                    </tr>
                    <tr>
                        <td>Availability - Start Time</td>
                        <td><form action="">
							  <select name='starttime'>
								  <option value="0">00:00</option>
								  <option value="1">01:00</option>
								  <option value="2">02:00</option>
								  <option value="3">03:00</option>
								  <option value="4">04:00</option>
								  <option value="5">05:00</option>
								  <option value="6">06:00</option>
								  <option value="7">07:00</option>
								  <option value="8">08:00</option>
								  <option value="9">09:00</option>
								  <option value="10">10:00</option>
								  <option value="11">11:00</option>
								  <option value="12">12:00</option>
								  <option value="13">13:00</option>
								  <option value="14">14:00</option>
								  <option value="15">15:00</option>
								  <option value="16">16:00</option>
								  <option value="17">17:00</option>
								  <option value="18">18:00</option>
								  <option value="19">19:00</option>
								  <option value="20">20:00</option>
								  <option value="21">21:00</option>
								  <option value="22">22:00</option>
								  <option value="23">23:00</option>
							  </select>
							</form>
						</td>
                    </tr>
                                        <tr>
                        <td>Availability - End Time</td>
                        <td><form action="">
							  <select name='endtime'>
								  <option value="0">00:00</option>
								  <option value="1">01:00</option>
								  <option value="2">02:00</option>
								  <option value="3">03:00</option>
								  <option value="4">04:00</option>
								  <option value="5">05:00</option>
								  <option value="6">06:00</option>
								  <option value="7">07:00</option>
								  <option value="8">08:00</option>
								  <option value="9">09:00</option>
								  <option value="10">10:00</option>
								  <option value="11">11:00</option>
								  <option value="12">12:00</option>
								  <option value="13">13:00</option>
								  <option value="14">14:00</option>
								  <option value="15">15:00</option>
								  <option value="16">16:00</option>
								  <option value="17">17:00</option>
								  <option value="18">18:00</option>
								  <option value="19">19:00</option>
								  <option value="20">20:00</option>
								  <option value="21">21:00</option>
								  <option value="22">22:00</option>
								  <option value="23">23:00</option>
							  </select>
							</form>
						</td>
                    </tr>
                    <tr>
                        <td>Specialization</td>
                        <td><input type="text" name="specialization" value="" /></td>
                    </tr>
                    <tr>
                        <td>Location</td>
                        <td><input type="text" name="location" value="" /></td>
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