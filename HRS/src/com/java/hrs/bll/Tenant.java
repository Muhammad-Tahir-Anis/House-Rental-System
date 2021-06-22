package com.java.hrs.bll;

public class Tenant {
	String name,imagePath;
	long contact,cnic;
	
	public Tenant(String name,String conatct,String cnic,String imagePath) {
		this.name = name;
		this.contact = Long.parseLong(conatct);
		this.cnic = Long.parseLong(cnic);
		this.imagePath = imagePath;
	}
	public String getName() {
		return name;
	}public long getContact() {
		return contact;
	}public long getCnic() {
		return cnic;
	}public String getImagePath() {
		return imagePath;
	}
}
