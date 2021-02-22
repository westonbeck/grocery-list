package com.personalapps.grocerylist.grocerylist.dao;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.personalapps.grocerylist.grocerylist.common.Meal;
import com.personalapps.grocerylist.grocerylist.rowmapper.ItemRowMapper;
import com.personalapps.grocerylist.grocerylist.rowmapper.MealRowMapper;

@Repository
public class MealItemDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public void saveMealItem(int mealId, int itemId) {
		String insertQuery = "insert into meal_item (meal_id, item_id) values (?,?);";
	    jdbc.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(insertQuery);
	          ps.setInt(1, mealId);
	          ps.setInt(2, itemId);
	          return ps;
	        });
	}
	
	public Meal findAllMealItemsById(int id){
		String mealQuery = "select * from meal where meal_id = ?";
		String itemQuery = "select * from item where exists (select * from meal_item where (meal_item.meal_id = ? and item.item_id = meal_item.item_id));";
		Meal meal = jdbc.queryForObject(mealQuery, new MealRowMapper(), id);
		meal.setItems(jdbc.query(itemQuery, new ItemRowMapper(), id));
		
		return meal;
	}
	
	public void deleteByIds(int mealId, int itemId) {
		String deleteQuery = "delete from meal_item where meal_id = ? and item_id = ?";
		jdbc.update(deleteQuery, mealId, itemId);
	}
	
	public void deleteAllMealItems(int mealId) {
		String deleteQuery = "delete from meal_item where meal_id = ?";
		jdbc.update(deleteQuery, mealId);
	}
	
}