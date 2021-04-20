<%@page import="com.te.springmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <jsp:include page="header.jsp"/>
	
	<%
	String msg =(String) request.getAttribute("msg");
	EmployeeBean bean= (EmployeeBean) request.getAttribute("data");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Form</title>
</head>
<body>
<% if(msg!= null && !msg.isEmpty()){ %>
<h1 style="color:blue"><%=msg %></h1>
<%} %>
<fieldset>
<legend>Search</legend>
	<form action="./search" method="get">
		<table>
			<tr>
				<td>Enter Id</td>
				<td>:</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td><input type="submit" value="search"></td>
			</tr>

		</table>
	</form>
</fieldset>
<%if (bean !=null) { %>
<h4>Name : <%=bean.getName() %></h4>
<h4>Id : <%=bean.getId() %></h4>
<h4>DOB : <%=bean.getDob() %></h4>
<%} %>

</body>
</html>