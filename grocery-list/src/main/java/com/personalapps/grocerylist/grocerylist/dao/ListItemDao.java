package com.personalapps.grocerylist.grocerylist.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.personalapps.grocerylist.grocerylist.common.Item;
import com.personalapps.grocerylist.grocerylist.rowmapper.ItemRowMapper;

@Repository
public class ListItemDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public void saveListItem(int itemId) {
		String insertQuery = "insert into list_item (item_id) values (?);";
	    jdbc.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(insertQuery);
	          ps.setInt(1, itemId);
	          return ps;
	        });
	}
	
	public void saveMealListItems(int mealId) {
		String itemQuery = "select * from item where exists (select * from meal_item where (item.item_id = meal_item.item_id and meal_item.meal_id = ?));";
		List<Item> items = jdbc.query(itemQuery, new ItemRowMapper(), mealId);
		
		for(Item i : items) {
			String insertQuery = "insert into list_item (item_id) values (?);";
			jdbc.update(connection -> {
		        PreparedStatement ps = connection
		          .prepareStatement(insertQuery);
		          ps.setInt(1, i.getId());
		          return ps;
		        });
		}
	}
	
	public List<Item> findAllListItems(){
		String itemQuery = "select * from item where exists (select * from list_item where (list_item.item_id = item.item_id));";
		List<Item> items = jdbc.query(itemQuery, new ItemRowMapper());
		
		return items;
	}
	
	public void deleteAll() {
		String deleteQuery = "delete from list_item;";
		jdbc.update(deleteQuery);
	}
	
}