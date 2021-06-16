package com.java.hrs.uil;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

import com.java.hrs.uil.addHouses.HouseView;
import com.java.hrs.uil.main.Footer;
import com.java.hrs.uil.main.Header;
import com.java.hrs.uil.rentHouse.SelectHouseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Body extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4211060916995254729L;
	Dimension MPdimension = new Dimension();
    Dimension Hdimension = new Dimension();
    Component verticalGlue = Box.createVerticalGlue();
    Header headerPanel = new Header();
    Footer footer = new Footer();
    
    private JButton btnAddHouses;
    private JButton btnRentHouse;
    private JButton btnViewHouse;
    private JButton btnViewTenant;
    public JPanel bodyPanel;
    
    protected void BtnAddHouseAction(ActionEvent event) {
    	//bodyPanel.setVisible(false);
    	HouseView houseView = new HouseView();
    	//add(houseView);
    	this.remove(bodyPanel);
    	this.add(houseView);
    	this.revalidate();
    	
    	//houseView.setVisible(true);
    }
    protected void BtnRentHouseAction(ActionEvent event) {
    	bodyPanel.setVisible(false);
    	SelectHouseView selectHouseView = new SelectHouseView();
    	add(selectHouseView);
    	selectHouseView.setVisible(true);
    }
    protected void BtnViewHouseAction(ActionEvent event) {
    	bodyPanel.setVisible(false);
    	HouseView houseView = new HouseView();
    	add(houseView);
    	houseView.setVisible(true);
    }
    protected void BtnViewTenantAction(ActionEvent event) {
    	bodyPanel.setVisible(false);
    	HouseView houseView = new HouseView();
    	add(houseView);
    	houseView.setVisible(true);
    }
	/**
	 * Create the panel.
	 */
	public Body() {
		setOpaque(false);

		setPreferredSize(new Dimension(1536, 864));
		setMaximumSize(new Dimension(1536, 864));
		
		bodyPanel = new JPanel();
		bodyPanel.setOpaque(false);
		bodyPanel.setPreferredSize(new Dimension(1536, 864));
		bodyPanel.setMaximumSize(new Dimension(1536, 864));

		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(bodyPanel);
		bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(50);
		bodyPanel.add(verticalStrut);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		bodyPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		panel.add(buttonPanel);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		buttonPanel.add(verticalGlue_1);
		
		btnAddHouses = new JButton("Add Houses");
		btnAddHouses.setPreferredSize(new Dimension(250, 50));
		btnAddHouses.setMaximumSize(new Dimension(250, 50));
		btnAddHouses.setMargin(new Insets(5, 10, 5, 10));
		btnAddHouses.setForeground(new Color(157, 253, 199));
		btnAddHouses.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnAddHouses.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(21, 39, 68), new Color(54,117,145), new Color(21,39,68), new Color(54,117,145)));
		btnAddHouses.setBackground(new Color(21, 39, 68));
		btnAddHouses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnAddHouseAction(e);
			}
		});
                
		buttonPanel.add(btnAddHouses);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		buttonPanel.add(verticalGlue_3);
		
		btnRentHouse = new JButton("Rent House");
		btnRentHouse.setPreferredSize(new Dimension(250, 50));
		btnRentHouse.setMaximumSize(new Dimension(250, 50));
		btnRentHouse.setMargin(new Insets(5, 10, 5, 10));
		btnRentHouse.setForeground(new Color(157, 253, 199));
		btnRentHouse.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnRentHouse.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(21, 39, 68), new Color(54,117,145), new Color(21,39,68), new Color(54,117,145)));
		btnRentHouse.setBackground(new Color(21, 39, 68));
		btnRentHouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnRentHouseAction(e);
			}
		});
		buttonPanel.add(btnRentHouse);
		
		Component verticalGlue_4 = Box.createVerticalGlue();
		buttonPanel.add(verticalGlue_4);
		
		btnViewHouse = new JButton("View House");
		btnViewHouse.setPreferredSize(new Dimension(250, 50));
		btnViewHouse.setMaximumSize(new Dimension(250, 50));
		btnViewHouse.setMargin(new Insets(5, 10, 5, 10));
		btnViewHouse.setForeground(new Color(157, 253, 199));
		btnViewHouse.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnViewHouse.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(21, 39, 68), new Color(54,117,145), new Color(21,39,68), new Color(54,117,145)));
		btnViewHouse.setBackground(new Color(21, 39, 68));
		btnViewHouse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnViewHouseAction(e);
			}
		});
		buttonPanel.add(btnViewHouse);
		
		Component verticalGlue_4_1 = Box.createVerticalGlue();
		buttonPanel.add(verticalGlue_4_1);
		
		btnViewTenant = new JButton("View Tenant");
		btnViewTenant.setPreferredSize(new Dimension(250, 50));
		btnViewTenant.setMaximumSize(new Dimension(250, 50));
		btnViewTenant.setMargin(new Insets(5, 10, 5, 10));
		btnViewTenant.setForeground(new Color(157, 253, 199));
		btnViewTenant.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnViewTenant.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED, new Color(21, 39, 68), new Color(54,117,145), new Color(21,39,68), new Color(54,117,145)));
		btnViewTenant.setBackground(new Color(21, 39, 68));
		btnViewTenant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BtnViewHouseAction(e);
			}
		});
		buttonPanel.add(btnViewTenant);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		Component verticalGlue_5 = Box.createVerticalGlue();
		bodyPanel.add(verticalGlue_5);
        
	}

}
