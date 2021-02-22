package com.personalapps.grocerylist.grocerylist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalapps.grocerylist.grocerylist.common.Item;
import com.personalapps.grocerylist.grocerylist.dao.ItemDao;

@RestController
public class ItemController {
	
	@Autowired
	ItemDao itemDao;
	
	@GetMapping(path = "/items")
	public List<Item> getAllItems(){
		List<Item> items = itemDao.retrieveAllItems();
		
		return items;
	}
	
	@GetMapping(path = "/items/{id}")
	public Item getItem(@PathVariable int id){
		return itemDao.findById(id);
	}

	@PostMapping(path = "/items")
	public void createItem(@RequestParam(name="name") String name, @RequestParam(name="description") String description) {
		this.itemDao.saveItem(name, description);
	}
	
	@PostMapping(path = "/items/{id}")
	public void updateItem(@PathVariable int id, @RequestParam(name="name") String name, @RequestParam(name="description") String description) {
		this.itemDao.updateById(id, name, description);
	}
	
	@DeleteMapping(path = "items/{id}")
	public void deleteItem(@PathVariable int id) {
		this.itemDao.deleteById(id);
	}
}
