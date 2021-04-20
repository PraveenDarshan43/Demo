<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Form</title>
</head>
<body>
<legend>ADD</legend>
	<form action="" method="post">


		<table>
			<tr>
				<td>Enter Id</td>
				<td>:</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td>:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td>:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter Date of Birth</td>
				<td>:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td><input type="submit" value="add"></td>
			</tr>

		</table>
	</form>

</body>
</html>