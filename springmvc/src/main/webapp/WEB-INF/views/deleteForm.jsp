<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <jsp:include page="header.jsp"/>
	<%
	String msg =(String) request.getAttribute("msg");
	String errmsg =(String) request.getAttribute("errmsg");

	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Form</title>
</head>
<body>
<% if(msg!= null && !msg.isEmpty()){ %>
<h1 style="color:blue"><%=msg %></h1>
<%} %>
<% if(errmsg!= null && !errmsg.isEmpty()){ %>
<h1 style="color:blue"><%=errmsg %></h1>
<%} %>
<fieldset>
<legend>Delete</legend>
	<form action="./delete" method="get">
		<table>
			<tr>
				<td>Enter Id</td>
				<td>:</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="delete"></td>
			</tr>

		</table>
	</form>
</fieldset>
</body>
</html>