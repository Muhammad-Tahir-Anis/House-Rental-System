package com.java.hrs.bll;

import java.awt.Image;

import javax.swing.*;

public class ResizeImage {
	public ImageIcon resizeImage(JLabel label,String imagePath) {
		ImageIcon icon = new ImageIcon(imagePath);
		Image MyImage = icon.getImage();
		Image img = MyImage.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img);
		//label.setIcon(image);
		return image;
	}
}
