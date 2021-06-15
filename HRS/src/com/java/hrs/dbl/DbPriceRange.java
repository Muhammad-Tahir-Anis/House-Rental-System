package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbPriceRange {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement maxPrice;
	PreparedStatement minPrice;
	ResultSet resultSet;
	
	int min;
	int max;
	public DbPriceRange() {
		try {
			maxPrice = connection.prepareStatement("SELECT MAX(PRICE) FROM house");
			minPrice = connection.prepareStatement("SELECT MIN(PRICE) FROM house");
			
			resultSet = maxPrice.executeQuery();
			if(resultSet.next()) {
				max = resultSet.getInt(1);
			}
			resultSet = minPrice.executeQuery();
			if(resultSet.next()) {
				min = resultSet.getInt(1);
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getMax() {
		return max;
	}
	public int getMin() {
		return min;
	}
}
