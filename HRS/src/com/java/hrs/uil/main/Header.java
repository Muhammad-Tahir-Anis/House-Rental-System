package com.java.hrs.uil.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Header extends JPanel {

	Dimension Hdimension = new Dimension();
	BoxLayout boxLayoutX = new BoxLayout(this,BoxLayout.X_AXIS);
	String comboItem[] = {"Add Houses","Rent House","View House", "View Tenant"};
	public int modifier;
	public JComboBox<String> comboBox;
	public JButton btnHeaderHomeIcon;
	/**
	 * Create the panel.
	 */
	
	public Header() {
		
		Hdimension = Toolkit.getDefaultToolkit().getScreenSize();
	    Hdimension.setSize(Hdimension.width*2,100);
	    
        setLayout(boxLayoutX);
        setPreferredSize(Hdimension);
        setMaximumSize(Hdimension);
        setBackground(Color.decode("#367591"));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        btnHeaderHomeIcon = new JButton("");
        btnHeaderHomeIcon.setBackground(Color.getColor("red", 0));
        btnHeaderHomeIcon.setBorder(null);
        btnHeaderHomeIcon.setOpaque(false);
        btnHeaderHomeIcon.setIcon(new ImageIcon("C:\\Users\\muham\\Downloads\\Home Icon.png"));
        btnHeaderHomeIcon.setMaximumSize(new Dimension(50,50));
        btnHeaderHomeIcon.setPreferredSize(new Dimension(50,50));
        
        Component horizontalStrut = Box.createHorizontalStrut(50);
        add(horizontalStrut);
        
        add(btnHeaderHomeIcon);
        
        Component horizontalGlue_2 = Box.createHorizontalGlue();
        add(horizontalGlue_2);
        
        JLabel headerTitle = new JLabel("HOUSER");
        headerTitle.setForeground(Color.decode("#9DFDC7"));
        headerTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(headerTitle);
        
        Component horizontalGlue_3 = Box.createHorizontalGlue();
        add(horizontalGlue_3);
        
        comboBox = new JComboBox<String>(comboItem);
        comboBox.setMaximumSize(new Dimension(200,40));
        comboBox.setPreferredSize(new Dimension(200,40));
        comboBox.setMaximumRowCount(4);
        comboBox.setBackground(Color.decode("#61D2B4"));
        comboBox.setForeground(Color.decode("#152744"));
        
        
        add(comboBox);
	}
	
}
