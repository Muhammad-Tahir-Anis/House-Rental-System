package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHouseList {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement house;
	ResultSet resultSet;
	
	String [][] houseList;
	public DbHouseList() {
		// TODO Auto-generated constructor stub
		try {
			house = connection.prepareStatement("SELECT `SIZE`, `PRICE`,`ADDRESS`, `IMAGE` FROM `house`");
			
			resultSet = house.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
