package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.hrs.bll.Owner;

public class DbOwner {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement insertOwner;
	public String insert(Owner owner) {
		try {
			insertOwner = connection.prepareStatement("INSERT INTO `owner`( `NAME`, `CONTACT`, `ADDRESS`, `CNIC`, `IMAGE`) VALUES ('"+owner.getName()+"','"+owner.getContact()+"','"+owner.getAddress()+"','"+owner.getCnic()+"','"+owner.getImagePath()+"')");
			insertOwner.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return "House Added";
	}
}
