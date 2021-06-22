package com.java.hrs.bll;

public class Owner {
	String name,address,imagePath;
	long contact,cnic;
	
	public Owner(String name,String conatct,String cnic,String address,String imagePath) {
		this.name = name;
		this.contact = Long.parseLong(conatct);
		this.cnic = Long.parseLong(cnic);
		this.address = address;
		this.imagePath = imagePath;
	}
	
	public String getName() {
		return name;
	}
	public long getContact() {
		return contact;
	}
	public long getCnic() {
		return cnic;
	}
	public String getAddress() {
		return address;
	}
	public String getImagePath() {
		return imagePath;
	}
}
