//On load
var xhr = new XMLHttpRequest();
var allItems = this.getAllItems();
var allMeals = this.getAllMeals();
this.tableLoader(allItems, "mainItemTable");
this.tableLoader(allMeals, "mainMealTable");

document.getElementById('generateList').addEventListener("click", sendSelectedItems);

//Functions
function getAllItems(){
	this.xhr.open("GET", 'http://localhost:8080/items',false);
	this.xhr.send(null);
	var items = JSON.parse(this.xhr.responseText);
	
	return items;
}

function getAllMeals(){
	this.xhr.open("GET", 'http://localhost:8080/meals',false);
	this.xhr.send(null);
	var meals = JSON.parse(this.xhr.responseText);
	
	return meals;
}

function tableLoader(data,selectId){
	var table = document.getElementById(selectId);
	for(var i = 0; i < data.length; i++){
		var newRow = table.insertRow(i+1)
		var itemName = newRow.insertCell(0);
		var itemDescription = newRow.insertCell(1);
		var addToList = newRow.insertCell(2);
		var action = newRow.insertCell(3);
		itemName.innerHTML = data[i].name;
		itemDescription.innerHTML = data[i].description;
		addToList.innerHTML = '<input type="checkbox" id="checkbox-'+selectId+i+'">';
		action.innerHTML = '<button type="button">Edit</button> <button type="button">Delete</button>';
	}
}

function sendSelectedItems(){
	var table = document.getElementById("mainItemTable");
	var checkboxPrefix = 'checkbox-mainItemTable';
	var endpointPrefix = 'http://localhost:8080/list/items?item_id='
	for(var n = 1; n < table.rows.length; n++){
		var checkbox = document.getElementById(checkboxPrefix+(n-1));
		var selectedItemId = allItems[n-1].id;
		var url = endpointPrefix+selectedItemId;
		if(checkbox.checked == true){
			xhr.open("POST", url, false);
			xhr.send(null);
		}
	}
}