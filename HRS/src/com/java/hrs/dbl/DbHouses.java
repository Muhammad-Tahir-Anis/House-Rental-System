package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DbHouses {

	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement houses;
	PreparedStatement rows;
	ResultSet resultSet;
	
	DefaultTableModel defaultTableModel;
	String[] tabelHeader={"Image","Size","Price","Address","View"};
	Object[][] tabelData;
	
	
	public DbHouses(int option,String min,String max) {
		// TODO Auto-generated constructor stub
		try {
			if(option == 1) {
				houses = connection.prepareStatement("Select Image, size, price, address, id from house where price between "+min+" and "+max+"");
			}
			else if(option == 2) {
				houses = connection.prepareStatement("Select Image, size, price, address, id from house where size between "+min+" and "+max+"");
			}
			
			rows = connection.prepareStatement("SELECT COUNT(*) FROM house");
			resultSet = rows.executeQuery();
			if(resultSet.next()) {
				tabelData = new Object[resultSet.getInt(1)][5];
			}
			resultSet = houses.executeQuery();
			int j =0;
			while(resultSet.next()) {
				for(int i = 0; i<5; i++) {
					tabelData[j][i] = resultSet.getString(i+1);
					System.out.println(tabelData[j][i]);
				}
				j++;
			}
			
			defaultTableModel = new DefaultTableModel(tabelData,tabelHeader);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
}
