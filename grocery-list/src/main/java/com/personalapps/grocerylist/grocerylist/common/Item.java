package com.personalapps.grocerylist.grocerylist.common;

import java.util.List;

public class Item {
	private Integer id;
	private String name;
	private String description;
	private List<Meal> meals;

	
	public Item() {
		
	}
	
	public Item(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Meal> getMeals(){
		return this.meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
