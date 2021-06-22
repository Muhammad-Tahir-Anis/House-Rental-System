package com.java.hrs.uil;

import javax.swing.*;

import com.java.hrs.bll.House;
import com.java.hrs.bll.Owner;
import com.java.hrs.bll.Tenant;
import com.java.hrs.dbl.DbHouse;
import com.java.hrs.dbl.DbOwner;


public class FormValidation {
	String message = " Enter Valid ";
	String specialCharater = "!#$%&'()*+,-./:;<=>?@[]^_'{|}";
	String regaxAlphabat = "[ A-Za-z]*";
	String regaxNumber = "[^0-9]";
	House house;
	Owner owner;
	Tenant tenant;
	DbHouse dbHouse = new DbHouse();
	DbOwner dbOwner = new DbOwner();
	public boolean HouseFormValidation(JTextField tfSize,JTextField tfRoom,JTextField tfBath,JTextField tfFloor,JTextField tfPrice,JTextField tfAddress,String imagePath) {
		boolean value;
		if(tfSize.getText().isEmpty() || tfSize.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfSize, "Enter Valid House Size");
			value = false;
		}
		else if(tfRoom.getText().isEmpty() || tfRoom.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfRoom, "Enter Valid Room");
			value = false;
		}
		else if(tfBath.getText().isEmpty() || tfBath.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfBath, "Enter Valid Bath");
			value = false;
		}
		else if(tfFloor.getText().isEmpty() || tfFloor.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfFloor, "Enter Valid Floor");
			value = false;
		}
		else if(tfPrice.getText().isEmpty() || tfPrice.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfPrice, "Enter Valid Price");
			value = false;
		}
		else if(tfAddress.getText().isEmpty()) {
			JOptionPane.showMessageDialog(tfAddress, "Enter Valid Address");
			value = false;
		}
		else {
			value = true;
		}
		return value;
	}
	
	public boolean OwnerFormValidation(JTextField tfName,JTextField tfContact,JTextField tfCnic,JTextField tfAddress,String imagePath) {
		boolean value;
		if(tfName.getText().isEmpty() || !tfName.getText().matches(regaxAlphabat)) {
			JOptionPane.showMessageDialog(tfName, "Enter Valid Owner Name");
			value = false;
		}
		else if(tfContact.getText().isEmpty() || tfContact.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfContact, "Enter Valid Contact No");
			value = false;
		}
		else if(tfCnic.getText().isEmpty() || tfCnic.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfCnic, "Enter Valid CNIC");
			value = false;
		}
		else if(tfAddress.getText().isEmpty()) {
			JOptionPane.showMessageDialog(tfAddress, "Enter Valid Address");
			value = false;
		}
		else {
			
			owner = new Owner(tfName.getText(),tfContact.getText(),tfCnic.getText(),tfAddress.getText(),imagePath);
			value = true;
		}
		return value;
	}
	public boolean TenantFormValidation(JTextField tfName,JTextField tfContact,JTextField tfCnic,String imagePath) {
		boolean value;
		if(tfName.getText().isEmpty() || !tfName.getText().matches(regaxAlphabat)) {
			JOptionPane.showMessageDialog(tfName, "Enter Valid Owner Name");
			value = false;
		}
		else if(tfContact.getText().isEmpty() || tfContact.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfContact, "Enter Valid Contact No");
			value = false;
		}
		else if(tfCnic.getText().isEmpty() || tfCnic.getText().matches(regaxNumber)) {
			JOptionPane.showMessageDialog(tfCnic, "Enter Valid CNIC");
			value = false;
		}
		else {
			tenant = new Tenant(tfName.getText(),tfContact.getText(),tfCnic.getText(),imagePath);
			value = true;
		}
		return value;
	}
}
