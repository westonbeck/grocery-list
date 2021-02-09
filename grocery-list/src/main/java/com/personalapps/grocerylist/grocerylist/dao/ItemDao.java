package com.personalapps.grocerylist.grocerylist.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.personalapps.grocerylist.grocerylist.common.Item;
import com.personalapps.grocerylist.grocerylist.rowmapper.ItemRowMapper;

@Repository
public class ItemDao {
	
	@Autowired
	JdbcTemplate jdbc;
	
	public void saveItem(String name, String description) {
		String insertQuery = "insert into item (name, description) values (?,?);";
	    jdbc.update(connection -> {
	        PreparedStatement ps = connection
	          .prepareStatement(insertQuery);
	          ps.setString(1, name);
	          ps.setString(2, description);
	          return ps;
	        });
	}
	
	public List<Item> retrieveAllItems(){
		String retrieveQuery = "select * from item";
		List<Item> items = jdbc.query(retrieveQuery, new ItemRowMapper());
		
		return items;
	}
	
	public Item findById(int id) {
		String findQuery = "select * from item where item_id = ?";
		Item item = jdbc.queryForObject(findQuery, new ItemRowMapper(), id);
		
		return item;
	}
	
	public void deleteById(int id) {
		String deleteQuery = "delete from item where item_id = ?";
		jdbc.update(deleteQuery, id);
	}
	
	public void updateById(int id, String name, String description) {
		String updateQuery = "update item set name = ?, description = ? where item_id = ?";
		jdbc.update(updateQuery, name, description, id);
	}
}
