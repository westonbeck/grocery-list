package com.personalapps.grocerylist.grocerylist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalapps.grocerylist.grocerylist.common.Meal;
import com.personalapps.grocerylist.grocerylist.dao.MealDao;

@RestController
public class MealController {
	
	@Autowired
	MealDao mealDao;
	
	@GetMapping(path = "/meals")
	public List<Meal> getAllMeals(){
		List<Meal> meals = mealDao.retrieveAllMeals();
		
		return meals;
	}
	
	@GetMapping(path = "/meals/{id}")
	public Meal getMeal(@PathVariable int id){
		return mealDao.findById(id);
	}

	@PostMapping(path = "/meals")
	public void createMeal(@RequestParam(name="name") String name, @RequestParam(name="description") String description) {
		this.mealDao.saveMeal(name, description);
	}
	
	@PostMapping(path = "/meals/{id}")
	public void updateMeal(@PathVariable int id, @RequestParam(name="name") String name, @RequestParam(name="description") String description) {
		this.mealDao.updateById(id, name, description);
	}
	
	@DeleteMapping(path = "/meals/{id}")
	public void deleteMeal(@PathVariable int id) {
		this.mealDao.deleteById(id);
	}
	
}
