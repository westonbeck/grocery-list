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
		body {font-family: Arial, Helvetica, sans-serif;}
			
		/* The Modal (background) */
		.modal {
		  display: none; /* Hidden by default */
		  position: fixed; /* Stay in place */
		  z-index: 1; /* Sit on top */
		  padding-top: 100px; /* Location of the box */
		  left: 0;
		  top: 0;
		  width: 100%; /* Full width */
		  height: 100%; /* Full height */
		  overflow: auto; /* Enable scroll if needed */
		  background-color: rgb(0,0,0); /* Fallback color */
		  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
		}
		
		/* Modal Content */
		.modal-content {
		  background-color: #fefefe;
		  margin: auto;
		  padding: 20px;
		  border: 1px solid #888;
		  width: 30%;
		}
		
		/* The Close Button */
		.close {
		  color: #aaaaaa;
		  float: right;
		  font-size: 28px;
		  font-weight: bold;
		}
		
		.close:hover,
		.close:focus {
		  color: #000;
		  text-decoration: none;
		  cursor: pointer;
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
		<button id="addNewItemButton">Add New Item</button><br><br>
		
		<div id="editItemModal" class="modal">
		  <!-- Modal content -->
		  <div class="modal-content">
		    <span class="close">&times;</span>
				<form id="editItemForm">
					<p><b>Edit Item</b></p>
					<label for = "name">Name:</label><br>
					<input type="text" id="editItemName" name="name" size="40"><br><br>
					<label for="description">Description:</label><br>
					<textarea name="description" id="editItemDescription" form="editItemForm" rows="8" cols="70"></textarea><br><br>
					<input type = "submit" id="editItemSubmit" value="Submit">
				</form>
		  </div>
		</div>
		
		<div id="addItemModal" class="modal">
		  <!-- Modal content -->
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
				<form id="addItemForm" action="/items" method="post" target="dummyframe" onsubmit="setTimeout(function(){window.location.reload();},10);">
					<p><b>Add New Item</b></p>
					<label for = "name">Name:</label><br>
					<input type="text" id="name" name="name" size="40"><br><br>
					<label for="description">Description:</label><br>
					<textarea name="description" form="addItemForm" rows="8" cols="70"></textarea><br><br>
					<input type = "submit" value="Add Item">
				</form>
		  </div>
		</div>
		
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
		<button id="addNewMealButton">Add New Meal</button><br><br>
	
		<div id="addMealModal" class="modal">
		  <!-- Modal content -->
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <iframe name="dummyframe" id="dummyframe" style="display: none;"></iframe>
				<form id="addMealForm" action="/meals" method="post" target="dummyframe" onsubmit="setTimeout(function(){window.location.reload();},10);">
					<p><b>Add New Meal</b></p>
					<label for = "name">Name:</label><br>
					<input type="text" id="name" name="name" size="40"><br><br>
					<label for="description">Description:</label><br>
					<textarea name="description" form="addMealForm" rows="8" cols="70"></textarea><br><br>
					<input type = "submit" value="Add Meal">
				</form>
		  </div>
		</div>
	
		<form action = "http://localhost:8080/main/list">
			<button type ="submit" id="generateList">Generate Shopping List</button>
		</form>
		
	</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js" type="text/javascript"></script>