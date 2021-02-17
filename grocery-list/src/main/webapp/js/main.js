//On load
var xhr = new XMLHttpRequest();
var allItems = this.getAllItems();
var itemCheckboxes =[];
var itemEditButtons = [];
var itemDeleteButtons = [];
var allMeals = this.getAllMeals();
var mealCheckboxes = [];
var mealEditButtons = [];
var mealDeleteButtons = [];
this.tableLoader(allItems, "mainItemTable");
this.tableLoader(allMeals, "mainMealTable");

document.getElementById('generateList').addEventListener("click", () =>{
	sendSelectedItems();
	sendSelectedMeals();
});

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

function tableLoader(data,tableId){
	var table = document.getElementById(tableId);
	for(var i = 0; i < data.length; i++){
		var newRow = table.insertRow(i+1)
		var name = newRow.insertCell(0);
		var description = newRow.insertCell(1);
		var addToList = newRow.insertCell(2);
		var action = newRow.insertCell(3);
		name.innerHTML = data[i].name;
		description.innerHTML = data[i].description;
		if(tableId == "mainItemTable"){
			itemCheckboxes.push('<input type="checkbox" id="itemCheckbox'+i+'">');
			itemEditButtons.push('<button type="button" id="itemEditButton'+i+'">Edit</button>');
			itemDeleteButtons.push('<button type="button" id="itemDeleteButton'+i+'">Delete</button>');
			addToList.innerHTML = itemCheckboxes[i];
			action.innerHTML = itemEditButtons[i] + ' ' + itemDeleteButtons[i];
		}
		else if(tableId == "mainMealTable"){
			mealCheckboxes.push('<input type="checkbox" id="mealCheckbox'+i+'">');
			mealEditButtons.push('<button type="button" id="mealEditButton'+i+'">Edit</button>');
			mealDeleteButtons.push('<button type="button" id="mealDeleteButton'+i+'">Delete</button>');
			addToList.innerHTML = mealCheckboxes[i];
			action.innerHTML = mealEditButtons[i] + ' ' + mealDeleteButtons[i];
		}
	}
}

function sendSelectedItems(){
	var checkboxPrefix = 'itemCheckbox';
	var endpointPrefix = 'http://localhost:8080/list/items?item_id='
	for(var n = 0; n < itemCheckboxes.length; n++){
		var checkbox = document.getElementById(checkboxPrefix+(n));
		var selectedItemId = allItems[n].id;
		var url = endpointPrefix+selectedItemId;
		if(checkbox.checked == true){
			xhr.open("POST", url, false);
			xhr.send(null);
		}
	}
}

function sendSelectedMeals(){
	var checkboxPrefix = 'mealCheckbox';
	var endpointPrefix = 'http://localhost:8080/list/?meal_id='
	for(var n = 0; n < mealCheckboxes.length; n++){
		var checkbox = document.getElementById(checkboxPrefix+(n));
		var selectedMealId = allMeals[n].id;
		var url = endpointPrefix+selectedMealId;
		if(checkbox.checked == true){
			xhr.open("POST", url, false);
			xhr.send(null);
		}
	}
}