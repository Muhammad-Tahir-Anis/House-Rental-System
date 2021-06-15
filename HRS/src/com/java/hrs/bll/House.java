package com.java.hrs.bll;

public class House {
	String address,imagePath;
	int rooms,baths,floor, price;
	float size;

	public House(String size,String rooms,String baths,String floors,String price,String address,String imagePath) {
		this.size = Float.parseFloat(size);
		this.address = address;
		this.rooms = Integer.parseInt(rooms);
		this.baths = Integer.parseInt(baths);
		this.floor = Integer.parseInt(floors);
		this.price = Integer.parseInt(price);
		this.imagePath = imagePath;
	}
	
	public String getAddress() {
		return address;
	}
	public float getSize() {
		return size;
	}
	public int getRooms() {
		return rooms;
	}
	public int getBaths() {
		return baths;
	}
	public int getFloor() {
		return floor;
	}
	public int getPrice() {
		return price;
	}
	public String getImagePath() {
		return imagePath;
	}
}
