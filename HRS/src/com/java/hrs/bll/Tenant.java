package com.java.hrs.bll;

public class Tenant {
	String name,status;
	long contactNumber,cnic;
	int age;
	public Tenant(String name,String status,String contactNumber,String cinic,String age) {
		this.name = name;
		this.status = status;
		this.contactNumber = Long.parseLong(contactNumber);
		this.cnic = Long.parseLong(cinic);
		this.age = Integer.parseInt(age);
	}
}
