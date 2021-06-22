package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.hrs.bll.GetHouse;
import com.java.hrs.bll.House;

public class DbGetHouse {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement gethouse;
	ResultSet resultSet;
	GetHouse house;
	public DbGetHouse(int id) {
		// TODO Auto-generated constructor stub
		
		try {
			gethouse = connection.prepareStatement("SELECT * FROM `house` WHERE ID="+id+"");
			resultSet = gethouse.executeQuery();
			
			while(resultSet.next()) {
				house = new GetHouse(resultSet.getFloat(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getString(7), resultSet.getBytes(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public GetHouse getHouse() {
		return house;
	}
}
