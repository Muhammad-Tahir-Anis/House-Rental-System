package com.java.hrs.dbl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import com.java.hrs.bll.ResizeImage;
import com.java.hrs.bll.Tenant;

public class DbTenant {
	DbConnector dbConnector = new DbConnector();
	Connection connection = dbConnector.connection;
	Statement statement;
	PreparedStatement insertTenant;
	
	public String insert(Tenant tenant) {
		try {
			insertTenant = connection.prepareStatement("INSERT INTO `tenant`( `NAME`, `CONTACT`, `CNIC`, `IMAGE`) VALUES ('"+tenant.getName()+"','"+tenant.getContact()+"','"+tenant.getCnic()+"','"+tenant.getImagePath()+"')");
			insertTenant.execute();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return "Tenant Added";
	}
	
	
	PreparedStatement getTenant;
	PreparedStatement rows;
	ResultSet resultSet;
	DefaultTableModel defaultTableModel;
	String[] tabelHeader={"Name","CNIC","Contact No."};
	Object[][] tabelData;

	public void getData() {
		try {
			getTenant = connection.prepareStatement("SELECT `NAME`, `CONTACT`, `CNIC` FROM `tenant`");
			
			rows = connection.prepareStatement("SELECT COUNT(*) FROM tenant");
			resultSet = rows.executeQuery();
			if(resultSet.next()) {
				tabelData = new Object[resultSet.getInt(1)][3];
			}
			
			resultSet = getTenant.executeQuery();
			
			int j =0;
			while(resultSet.next()) {
				for(int i = 0; i<3; i++) {
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
