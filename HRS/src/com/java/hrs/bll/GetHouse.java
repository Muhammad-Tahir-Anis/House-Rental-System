package com.java.hrs.bll;

import javax.swing.ImageIcon;

public class GetHouse {
	String size,price,rooms,baths,floor,address;
	ImageIcon image;
	public GetHouse(float size,int price,int rooms,int baths,int floor,String address,byte[] image) {
		// TODO Auto-generated constructor stub
		this.size = String.valueOf(size);
		this.price = String.valueOf(price);
		this.rooms = String.valueOf(rooms);
		this.baths = String.valueOf(baths);
		this.floor = String.valueOf(floor);
		this.address = address;
		this.image = new ImageIcon(image);
	}
	public String getSize() {
		return size;
	}public String getPrice() {
		return price;
	}public String getRooms() {
		return rooms;
	}public String getBaths() {
		return baths;
	}public String getFloor() {
		return floor;
	}public String getAddress() {
		return address;
	}public ImageIcon getImage() {
		return image;
	}
}
