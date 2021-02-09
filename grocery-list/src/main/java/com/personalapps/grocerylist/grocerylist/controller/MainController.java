package com.personalapps.grocerylist.grocerylist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personalapps.grocerylist.grocerylist.common.Item;
import com.personalapps.grocerylist.grocerylist.common.Meal;
import com.personalapps.grocerylist.grocerylist.dao.ItemDao;
import com.personalapps.grocerylist.grocerylist.dao.ListItemDao;
import com.personalapps.grocerylist.grocerylist.dao.MealDao;

@Controller
public class MainController {
	
	@Autowired
	ItemDao itemDao;
	
	@Autowired
	MealDao mealDao;
	
	@Autowired
	ListItemDao listItemDao;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showMainPage(HttpServletRequest request, HttpServletResponse response) {
		List<Item> items = itemDao.retrieveAllItems();
		request.setAttribute("items", items);
		
		List<Meal> meals = mealDao.retrieveAllMeals();
		request.setAttribute("meals", meals);
		
		return "main";
	}
	@RequestMapping(value = "/main/list", method = RequestMethod.GET)
	public String showList(HttpServletRequest request, HttpServletResponse response) {
		List<Item> items = listItemDao.findAllListItems();
		request.setAttribute("items", items);
		
		return "list";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response) {
		
		return "test";
	}
}
