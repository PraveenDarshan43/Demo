<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String msg=(String) request.getAttribute("errmsg"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%if(msg != null && !msg.isEmpty()) { %>
	<%=msg %>
	<% } %>
	<fieldset>
		<legend>Login</legend>
		<form action="./emplogin" method="post">


			<table>
				<tr>
					<td>Enter Id</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td>:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="login"></td>
				</tr>

			</table>
		</form>
	</fieldset>

</body>
</html>