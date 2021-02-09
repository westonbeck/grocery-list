package com.personalapps.grocerylist.grocerylist.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.personalapps.grocerylist.grocerylist.common.Meal;

public class MealRowMapper implements RowMapper<Meal>{

	@Override
	public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Meal meal = new Meal();
		
		meal.setId(rs.getInt("meal_id"));
		meal.setName(rs.getString("name"));
		meal.setDescription(rs.getString("description"));
		
		return meal;
	}

}
