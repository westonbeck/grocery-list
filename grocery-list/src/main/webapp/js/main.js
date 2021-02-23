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

// Load page
this.tableLoader(allItems, "mainItemTable");

this.tableLoader(allMeals, "mainMealTable");
	
document.getElementById('generateList').addEventListener("click", () =>{
	sendSelectedItems();
	sendSelectedMeals();
});

document.getElementById('addNewItemButton').addEventListener("click", () =>{
	modalHandler("addItemModal");
})

document.getElementById('addNewMealButton').addEventListener("click", () =>{
	modalHandler("addMealModal");
})

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
			addToList.innerHTML = '<input type="checkbox" class="itemCheckbox" id="itemCheckbox'+i+'">';
			action.innerHTML = '<button type="button" onclick="editItemModal(this.id.substr(14))" class="itemEditButton" id="itemEditButton'+data[i].id+
			'">Edit</button>  <button type="button" onclick="deleteItem(this.id.substr(16))" class="itemDeleteButton" id="itemDeleteButton'+data[i].id+
			'">Delete</button>';
		}
		else if(tableId == "mainMealTable"){
			addToList.innerHTML = '<input type="checkbox" class="mealCheckbox" id="mealCheckbox'+i.id+'">';
			action.innerHTML = '<button type="button" class="mealEditButton" id="mealEditButton'+data[i].id+
			'">Edit</button> <button type="button" onclick="deleteMeal(this.id.substr(16))" class="mealDeleteButton" id="mealDeleteButton'+data[i].id+'">Delete</button>';
		}
	}
}

function showId(elementId){
	alert(elementId.substr(16));
}

function editItemModal(itemId){
	xhr.open("GET", 'http://localhost:8080/items/'+itemId, false);
	xhr.send(null);
	var item = JSON.parse(xhr.responseText);
	var itemName = document.getElementById("editItemName");
	itemName.value = item.name;
	var itemDesc = document.getElementById("editItemDescription");
	itemDesc.value = item.description;
	var submit = document.getElementById("editItemSubmit");
	modalHandler("editItemModal");

	
	submit.addEventListener("click", () =>{
		xhr.open("POST", 'http://localhost:8080/items/'+itemId+'?name='+itemName.value+'&description='+itemDesc.value, false);
		xhr.send(null);
		location.reload();
	})
	
}

function deleteItem(itemId){
	xhr.open("DELETE", 'http://localhost:8080/items/'+itemId, false);
	xhr.send(null);
	location.reload();
}

function deleteMeal(mealId){
	xhr.open("DELETE", 'http://localhost:8080/meals/'+mealId+'/items', false);
	xhr.open("DELETE", 'http://localhost:8080/meals/'+mealId, false);
	xhr.send(null);
	location.reload();
}

function sendSelectedItems(){
	var checkboxPrefix = 'itemCheckbox';
	var endpointPrefix = 'http://localhost:8080/list/items?item_id='
	for(var n = 0; n < allItems.length; n++){
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
	for(var n = 0; n < allMeals.length; n++){
		var checkbox = document.getElementById(checkboxPrefix+(n));
		var selectedMealId = allMeals[n].id;
		var url = endpointPrefix+selectedMealId;
		if(checkbox.checked == true){
			xhr.open("POST", url, false);
			xhr.send(null);
		}
	}
}

function modalHandler(modalId){
	var modal = document.getElementById(modalId);
	
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];
	
	// When the user clicks the button, open the modal 
	modal.style.display = "block";
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
}
