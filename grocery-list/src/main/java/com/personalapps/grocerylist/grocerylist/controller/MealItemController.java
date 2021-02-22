package com.personalapps.grocerylist.grocerylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalapps.grocerylist.grocerylist.common.Meal;
import com.personalapps.grocerylist.grocerylist.dao.MealItemDao;

@RestController
public class MealItemController {
	
	@Autowired
	MealItemDao mealItemDao;
	
	@PostMapping(path = "/meals/{mealId}/items")
	public void addMealitem(@PathVariable int mealId, @RequestParam(name="item_id") int itemid) {
		mealItemDao.saveMealItem(mealId, itemid);
	}
	
	@GetMapping(path = "/meals/{mealId}/items")
	public Meal getMealItems(@PathVariable int mealId){
		return mealItemDao.findAllMealItemsById (mealId);
	}
	
	@DeleteMapping(path = "/meals/{mealId}/items/{itemId}")
	public void deleteMealItem(@PathVariable("mealId") int mealId, @PathVariable("itemId") int itemId) {
		mealItemDao.deleteByIds(mealId, itemId);
	}
	
	@DeleteMapping(path = "/meals/{mealId}/items/")
	public void deleteAllMealItems(@PathVariable("mealId") int mealId) {
		mealItemDao.deleteAllMealItems(mealId);
	}
	
}
