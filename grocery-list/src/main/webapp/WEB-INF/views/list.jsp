<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  table-layout: fixed;
  font-family: arial, sans-serif;
  width: 100%;
}
table.center {
  margin-left: auto; 
  margin-right: auto;
}
th, td {
  padding: 10px;
  border: 1px solid #dddddd;
  word-wrap:break-word
}
</style>
<meta charset="ISO-8859-1">
<title>Grocery list</title>
</head>
<body>
	<h1>Shopping List</h1>
	<table style="width:600px">
		<tr>
			<th>Item Name</th>
			<th>Item Description</th>
			<th>Check</th>
		</tr>
		<c:forEach items = "${items}" var = "item">
			<tr>
				<td>${item.name}</td>
				<td>${item.description}</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
	<br>
		
	<form action="http://localhost:8080/main">
		<button type ="submit" id="resetButton">Reset</button>
	</form>
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/list.js" type="text/javascript"></script>