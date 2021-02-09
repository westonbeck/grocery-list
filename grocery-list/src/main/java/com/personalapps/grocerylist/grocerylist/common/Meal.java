package com.personalapps.grocerylist.grocerylist.common;

import java.util.List;

public class Meal {
	private Integer id;
	private String name;
	private String description;
	private List<Item> items;
	
	public Meal() {
		
	}
	
	public Meal(Integer id, String name, String description) {
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

	public List<Item> getItems() {
		return items;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Meal [id=" + id + ", name=" + name + ", description=" + description + ", items=" + items + "]";
	}
}
