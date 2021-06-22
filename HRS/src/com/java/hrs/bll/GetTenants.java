package com.java.hrs.bll;

import javax.swing.table.DefaultTableModel;

import com.java.hrs.dbl.DbTenant;

public class GetTenants {

	DbTenant dbTenant = new DbTenant();
	DefaultTableModel defaultTableModel = new DefaultTableModel();
	
	public DefaultTableModel getDefaultTableModel() {
		dbTenant.getData();
		defaultTableModel = dbTenant.getDefaultTableModel();
		return defaultTableModel;
	}
}
