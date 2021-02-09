package com.personalapps.grocerylist.grocerylist.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.personalapps.grocerylist.grocerylist.common.Item;

public class ItemRowMapper implements RowMapper<Item>{

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		
		item.setId(rs.getInt("item_id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		
		return item;
	}

}
