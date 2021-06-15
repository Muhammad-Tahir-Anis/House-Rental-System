package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.hrs.bll.House;

public class DbHouse {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement insertHouse;
	public String insert(House house) {
		try {
			insertHouse = connection.prepareStatement("INSERT INTO `house` (`SIZE`, `PRICE`, `ROOMS`, `BATHS`, `FLOORS`, `ADDRESS`, `IMAGE`) VALUES ('"+house.getSize()+"','"+house.getPrice()+"','"+house.getRooms()+"','"+house.getBaths()+"','"+house.getFloor()+"','"+house.getAddress()+"','"+house.getImagePath()+"')");
			insertHouse.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return "House Added";
	}
}
