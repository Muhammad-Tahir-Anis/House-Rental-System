package com.java.hrs.bll;

import javax.swing.table.DefaultTableModel;

import com.java.hrs.dbl.DbHouse;
import com.java.hrs.dbl.DbTenant;

public class GetHouses {

	DbHouse dbHouse = new DbHouse();
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	
	public DefaultTableModel getDefaultTableModel() {
		dbHouse.getData();
		defaultTableModel = dbHouse.getDefaultTableModel();
		return defaultTableModel;
	}
}
