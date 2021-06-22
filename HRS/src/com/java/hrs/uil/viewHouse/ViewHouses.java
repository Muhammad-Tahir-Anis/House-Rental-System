package com.java.hrs.uil.viewHouse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.java.hrs.bll.GetHouse;
import com.java.hrs.bll.GetHouses;
import com.java.hrs.bll.GetTenants;
import com.java.hrs.dbl.DbGetHouse;
import com.java.hrs.dbl.DbHouse;
import com.java.hrs.dbl.DbTenant;
import com.java.hrs.uil.addHouses.HouseView;
import com.java.hrs.uil.main.Body;
import com.java.hrs.uil.rentHouse.RentHouse;

import javax.swing.JButton;

public class ViewHouses extends JPanel {

	GetHouses getHouses = new GetHouses();
	DbHouse dbHouse = new DbHouse();
	Dimension dimension = new Dimension();
	Body bodyPanel = new Body();
	JPanel mainPanel;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ViewHouses() {
		dimension.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("View Houses");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.decode("#9DFDC7"));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		mainPanel.add(scrollPane);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setBackground(Color.decode("#367591"));
		table.setForeground(Color.decode("#9DFDC7"));
		table.setModel(getHouses.getDefaultTableModel());
		table.setRowHeight(100);
		table.setGridColor(Color.decode("#152744"));
		//table.getColumnModel().getColumn(0).setCellRenderer(table.getDefaultRenderer(ImageIcon.class));
		//ButtonColumn buttonColumn = new ButtonColumn(table, view, 4);
		scrollPane.setViewportView(table);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_2);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		mainPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDelete.setBackground(Color.decode("#152744"));
		btnDelete.setForeground(Color.decode("#9DFDC7"));
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow() != -1) {
					int row = table.getSelectedRow();
					int column = 0;
					String value = (String)table.getValueAt(row, column);
					int id = Integer.parseInt(value);
					System.out.println(id);
					btnDeleteAction(id);
					table.setModel(getHouses.getDefaultTableModel());
					table.revalidate();
				}
				else {
					JOptionPane.showMessageDialog(scrollPane, "Please Select Desired Row First");
				}
			}
		});
		panel.add(btnDelete);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEdit.setBackground(Color.decode("#152744"));
		btnEdit.setForeground(Color.decode("#9DFDC7"));
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow() != -1) {
					int row = table.getSelectedRow();
					int column = 0;
					String value = (String)table.getValueAt(row, column);
					int id = Integer.parseInt(value);
					System.out.println(id);
					btnEditAction(id);
				}
				else {
					JOptionPane.showMessageDialog(scrollPane, "Please Select Desired Row First");
				}
			}
		});
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel.add(horizontalStrut);
		panel.add(btnEdit);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_2);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_3);
	}

	public void	btnDeleteAction(int id){
			dbHouse.delete(id);
			dbHouse.getData();
		}
		
	public void	btnEditAction(int id){
		DbGetHouse dbGetHouse = new DbGetHouse(id);
		mainPanel.setVisible(false);
		EditHouse editHouse = new EditHouse(dbGetHouse.getHouse(),id);
		add(editHouse);
	}
}