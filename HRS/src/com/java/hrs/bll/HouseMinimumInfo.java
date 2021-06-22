package com.java.hrs.bll;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import com.java.hrs.dbl.DbHouses;

public class HouseMinimumInfo {
	DbHouses dbHouses;
	DefaultTableModel defaultTableModel = new DefaultTableModel(new String[]{"Image","Size","Price","Address"},0);
	
	float size;
	int price;
	String address;
	byte[] image;
	public HouseMinimumInfo() {
		// TODO Auto-generated constructor stub
		
	}
	public void setSize(float size) {
		this.size = size;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}
	
	public float getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}
	public String getAddress() {
		return address;
	}
	public ImageIcon getImage() {
		ImageIcon icon = new ImageIcon(image);
		Image image = icon.getImage();
		ImageIcon img = new ImageIcon(image.getScaledInstance(50, 50, image.SCALE_SMOOTH));
		return icon;
	}
	//public DefaultTableModel getDefaultTableModel() {
		//defaultTableModel = dbHouseList.getModel();
		//return defaultTableModel;
	//}
	
	public DefaultTableModel priceFilter(String item) {
		String[] strings = item.split("-");
		dbHouses = new DbHouses(1,strings[0], strings[1]);
		defaultTableModel = dbHouses.getDefaultTableModel();
		return defaultTableModel;
	}
	
	public DefaultTableModel sizeFilter(String item) {
		String[] strings = item.split("-");
		dbHouses = new DbHouses(2,strings[0], strings[1]);
		defaultTableModel = dbHouses.getDefaultTableModel();
		return defaultTableModel;
	}
	
	
	public DefaultTableModel getDefaultTableModel() {
		return dbHouses.getDefaultTableModel();
	}
}
