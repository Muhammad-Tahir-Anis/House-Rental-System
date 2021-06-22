package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

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
	
	PreparedStatement getHouse;
	PreparedStatement rows;
	ResultSet resultSet;
	DefaultTableModel defaultTableModel;
	String[] tabelHeader={"ID","Size","Price","Rooms","Baths","Floors","Address"};
	Object[][] tabelData;

	public void getData() {
		try {
			getHouse = connection.prepareStatement("SELECT ID, `SIZE`, `PRICE`, `ROOMS`, `BATHS`, `FLOORS`, `ADDRESS` FROM `house` ");
			
			rows = connection.prepareStatement("SELECT COUNT(*) FROM house");
			resultSet = rows.executeQuery();
			if(resultSet.next()) {
				tabelData = new Object[resultSet.getInt(1)][7];
			}
			
			resultSet = getHouse.executeQuery();
			
			int j =0;
			while(resultSet.next()) {
				for(int i = 0; i<7; i++) {
					tabelData[j][i] = resultSet.getString(i+1);
					System.out.println(tabelData[j][i]);
				}
				j++;
			}

			defaultTableModel = new DefaultTableModel(tabelData,tabelHeader);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	
	PreparedStatement deleteHouse;
	public void delete(int id) {
		try {
			System.out.println("db "+id);
			deleteHouse = connection.prepareStatement("DELETE FROM house WHERE ID = "+id+"");
			deleteHouse.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	PreparedStatement updateHouse;
	public void update(int id,House house) {
		try {
			updateHouse = connection.prepareStatement("UPDATE `house` SET `SIZE`='"+house.getSize()+"',`PRICE`='"+house.getPrice()+"',`ROOMS`='"+house.getRooms()+"',`BATHS`='"+house.getBaths()+"',`FLOORS`='"+house.getFloor()+"',`ADDRESS`='"+house.getAddress()+"',`IMAGE`='"+house.getImagePath()+"' WHERE ID = "+id+"");
			updateHouse.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}