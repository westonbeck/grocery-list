<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		#table-scroll {
		  height: 750px;
		  width: 600px;
		  overflow:auto;  
		  margin-top:20px;
		}
	</style>
		<meta charset="ISO-8859-1">
		<title>Grocery list</title>
	</head>
	
	<body>
		<h1>Items</h1>
		<div id="table-scroll">
			<table style="width:600px" id="mainItemTable">
					<tr>
						<th>Item Name</th>
						<th>Item Description</th>
						<th>Add To List</th>
						<th>Action</th>
					</tr>
			</table>
		</div><br>
		
		<iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
		<form id="addItemForm" action="/items" method="post" target="dummyframe" onsubmit="setTimeout(function(){window.location.reload();},10);">
			<p>Add New Item</p>
			<label for = "name">Name:</label><br>
			<input type="text" id="name" name="name"><br>
			<label for="description">Description:</label><br>
			<textarea name="description" form="addItemForm"></textarea><br>
			<input type = "submit" value="Add Item">
		</form><br><br>
		
		<h1>Meals</h1>
		<div id="table-scroll">
			<table style="width:600px" id="mainMealTable">
					<tr>
						<th>Meal Name</th>
						<th>Meal Description</th>
						<th>Add To List</th>
						<th>Action</th>
					</tr>
			</table>
		</div><br>
	
		<iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
		<form id="addMealForm" action="/meals" method="post" target="dummyframe" onsubmit="setTimeout(function(){window.location.reload();},10);">
			<p>Add New Meal</p>
			<label for = "name">Name:</label><br>
			<input type="text" id="name" name="name"><br>
			<label for="description">Description:</label><br>
			<textarea name="description" form="addMealForm"></textarea><br>
			<input type = "submit" value="Add Meal">
		</form><br><br>
	
		<form action = "http://localhost:8080/main/list">
			<button type ="submit" id="generateList">Generate Shopping List</button>
		</form>
		
	</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>