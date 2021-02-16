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
		<title>My title</title>
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
		
		<button type="button" id="countChecked">Count checked boxes</button>
		
	</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js" type="text/javascript"></script>