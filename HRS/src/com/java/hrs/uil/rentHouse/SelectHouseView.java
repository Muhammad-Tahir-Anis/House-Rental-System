package com.java.hrs.uil.rentHouse;

import javax.swing.JPanel;

import com.java.hrs.bll.PriceRange;
import com.java.hrs.bll.SizeRange;
import com.java.hrs.uil.Body;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JTable;

public class SelectHouseView extends JPanel {

	Dimension dimension = new Dimension();
	Body bodyPanel = new Body();
	PriceRange priceRange = new PriceRange();
	SizeRange sizeRange = new SizeRange();
	DefaultComboBoxModel<String> priceRangeModel = new DefaultComboBoxModel<String>(priceRange.getPriceRange());
	DefaultComboBoxModel<String> sizeRangeModel = new DefaultComboBoxModel<String>(sizeRange.getSizeRage());
	
	private JTable table;
	/**
	 * Create the panel.
	 */
	public SelectHouseView() {
		dimension.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Rent House");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_1);
		
		JPanel sortBar = new JPanel();
		sortBar.setOpaque(false);
		mainPanel.add(sortBar);
		sortBar.setLayout(new BoxLayout(sortBar, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		sortBar.add(horizontalGlue);
		
		JComboBox cbPriceRange = new JComboBox();
		cbPriceRange = new JComboBox<String>(priceRangeModel);
        cbPriceRange.setMaximumSize(new Dimension(200,40));
        cbPriceRange.setPreferredSize(new Dimension(200,40));
        cbPriceRange.setBackground(Color.decode("#61D2B4"));
        cbPriceRange.setForeground(Color.decode("#152744"));
		sortBar.add(cbPriceRange);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		sortBar.add(horizontalGlue_1);
		
		JComboBox cbSizeRange = new JComboBox();
		cbSizeRange = new JComboBox<String>(sizeRangeModel);
        cbSizeRange.setMaximumSize(new Dimension(200,40));
        cbSizeRange.setPreferredSize(new Dimension(200,40));
        cbSizeRange.setMaximumRowCount(4);
        cbSizeRange.setBackground(Color.decode("#61D2B4"));
        cbSizeRange.setForeground(Color.decode("#152744"));
		sortBar.add(cbSizeRange);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		sortBar.add(horizontalGlue_2);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		mainPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
