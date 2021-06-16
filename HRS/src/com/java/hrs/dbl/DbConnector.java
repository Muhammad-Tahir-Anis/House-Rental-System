package com.java.hrs.dbl;

import java.sql.*;

public class DbConnector {
	public Connection connection;
	public DbConnector() {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrs","root","password");
			if(!connection.isClosed()) {
				System.out.println("Sucessfully connected ...");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
