<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Health Tracker</title>


<script>
  var toggle = function() {
  var mydiv = document.getElementById('newpost');
  if (mydiv.style.display === 'block' || mydiv.style.display === '')
    mydiv.style.display = 'none';
  else
    mydiv.style.display = 'block'
  }
</script>
</head>
<body>
    <div class="content">  
		<h1>Health Tracker</h1>	
		<div id='newpost' align='center' hidden='true'>Hello World</div>
		<div class="main vlcone">

			<div class="pay_form">
				<div id="success" align='center'>${message}</div>
				 <form:form action="login" method="post" modelAttribute="userForm">
					<form:input path="userName" />
					<form:input path="Password" />
					<input type="submit" value="Login">
				</form:form>
				<form action="registration" method="POST">
					
					<input type="submit"  value="Register">
				</form> 
			</div>
			<a href="#">Forgot Password</a>
			
		</div>
		<p class="footer">&copy; 2016 Posturite Health Tracker. All Rights Reserved </p>
	</div>
</body>
</html>
