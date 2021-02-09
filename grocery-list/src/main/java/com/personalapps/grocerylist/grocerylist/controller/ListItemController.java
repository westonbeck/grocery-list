package com.personalapps.grocerylist.grocerylist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalapps.grocerylist.grocerylist.common.Item;
import com.personalapps.grocerylist.grocerylist.dao.ListItemDao;

@RestController
public class ListItemController {
	
	@Autowired
	ListItemDao listItemDao;
	
	@PostMapping(path = "/list/items")
	public void addListitem(@RequestParam(name="item_id") int itemid) {
		listItemDao.saveListItem(itemid);
	}
	
	@PostMapping(path = "/list")
	public void addMealItems(@RequestParam(name="meal_id") int mealId) {
		listItemDao.saveMealListItems(mealId);
	}
	
	@GetMapping(path = "/list")
	public List<Item> getListItems(){
		return listItemDao.findAllListItems();
	}
	
	@DeleteMapping(path = "/list")
	public void resetListItems() {
		listItemDao.deleteAll();
	}
}
