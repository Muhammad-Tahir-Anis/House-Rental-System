package com.java.hrs.uil.viewTenant;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.java.hrs.bll.GetTenants;
import com.java.hrs.dbl.DbTenant;
import com.java.hrs.uil.main.Body;
import com.java.hrs.uil.rentHouse.ButtonColumn;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewTenants extends JPanel {

	/**
	 * Create the panel.
	 */
	GetTenants getTenant = new GetTenants();
	DbTenant dbTenant = new DbTenant();
	Dimension dimension = new Dimension();
	Body bodyPanel = new Body();
	JPanel mainPanel;
	private JTable table;
	
	public ViewTenants() {
		dimension.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("View Tenants");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.decode("#9DFDC7"));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_1);
		
		JScrollPane scrollPane = new JScrollPane();
		mainPanel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.decode("#367591"));
		table.setForeground(Color.decode("#9DFDC7"));
		table.setModel(getTenant.getDefaultTableModel());
		table.setRowHeight(100);
		//table.getColumnModel().getColumn(0).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
		//ButtonColumn buttonColumn = new ButtonColumn(table, view, 4);
		scrollPane.setViewportView(table);

	}

}
