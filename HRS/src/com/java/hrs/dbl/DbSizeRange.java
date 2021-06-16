package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSizeRange {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement maxSize;
	PreparedStatement minSize;
	ResultSet resultSet;
	
	int min;
	int max;
	public DbSizeRange() {
		// TODO Auto-generated constructor stub
		try {
			maxSize = connection.prepareStatement("SELECT MAX(SIZE) FROM house");
			minSize = connection.prepareStatement("SELECT MIN(SIZE) FROM house");
			
			resultSet = maxSize.executeQuery();
			if(resultSet.next()) {
				max = resultSet.getInt(1);
			}
			resultSet = minSize.executeQuery();
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
