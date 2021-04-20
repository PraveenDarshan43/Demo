<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg =(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<form action="./logout"> method="get">
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
		</form></form>

</body>
</html>