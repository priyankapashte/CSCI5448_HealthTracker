<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
</head>
<body> 
 <form method="post" action="editDoctorProfile">
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
                        <td><input type="text" name="firstName" value="${doctor.firstName}" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="${doctor.lastName}" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="${doctor.email}" /></td>
                    </tr>
                    <tr>
                        <td>Age</td>
                        <td><input type="text" name="age" value="${doctor.age}" /></td>
                    </tr>
                     <tr>
                        <td>Telephone</td>
                        <td><input type="text" name="telephone" value="${doctor.telephone}" /></td>
                    </tr>
                    <tr>
                        <td>Availability - Days</td>
                        <td><form action="" required>
							  <input type="checkbox" name="day" value="Monday"> Monday<br>
							  <input type="checkbox" name="day" value="Tuesday"> Tuesday<br>
							  <input type="checkbox" name="day" value="Wednesday"> Wednesday<br>
							  <input type="checkbox" name="day" value="Thursday"> Thursday<br>
							  <input type="checkbox" name="day" value="Friday"> Friday<br>
							  <input type="checkbox" name="day" value="Saturday"> Saturday<br>
							  <input type="checkbox" name="day" value="Sunday"> Sunday<br>
							</form>
						</td>
                    </tr>
                    <tr>
                        <td>Availability - Start Time</td>
                        <td>	  <select name='starttime' required>
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
						</td>
                    </tr>
                                        <tr>
                        <td>Availability - End Time</td>
                        <td>
							  <select name='endtime' required>
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
						</td>
                    </tr>
                    <tr>
                        <td>Specialization</td>
                        <td><input type="text" name="specialization" value="${doctor.specialization}" /></td>
                    </tr>
                    <tr>
                        <td>Location</td>
                        <td><input type="text" name="location" value="${doctor.location}" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name='Save' value="Submit" /></td>
                        <td><input type="submit" value="Cancel" onclick="welcomeDoctor"/></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
        <a href='homepageDoctor'>Home Page</a>
</body>
</html>