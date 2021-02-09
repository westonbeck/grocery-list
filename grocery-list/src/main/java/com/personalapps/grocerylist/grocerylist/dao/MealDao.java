package com.personalapps.grocerylist.grocerylist.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.personalapps.grocerylist.grocerylist.common.Meal;
import com.personalapps.grocerylist.grocerylist.rowmapper.MealRowMapper;

@Repository
public class MealDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public void saveMeal(String name, String description) {
		String insertQuery = "insert into meal (name, description) values (?,?);";
	    jdbc.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(insertQuery);
	          ps.setString(1, name);
	          ps.setString(2, description);
	          return ps;
	        });
	}
	
	public List<Meal> retrieveAllMeals(){
		String retrieveQuery = "select * from meal";
		List<Meal> meals = jdbc.query(retrieveQuery, new MealRowMapper());
		
		return meals;
	}
	
	public Meal findById(int id) {
		String findQuery = "select * from meal where meal_id = ?";
		Meal meal = jdbc.queryForObject(findQuery, new MealRowMapper(), id);
		
		return meal;
	}
	
	public void deleteById(int id) {
		String deleteQuery = "delete from meal where meal_id = ?";
		jdbc.update(deleteQuery, id);
	}
	
	public void updateById(int id, String name, String description) {
		String updateQuery = "update meal set name = ?, description = ? where meal_id = ?";
		jdbc.update(updateQuery, name, description, id);
	}
}