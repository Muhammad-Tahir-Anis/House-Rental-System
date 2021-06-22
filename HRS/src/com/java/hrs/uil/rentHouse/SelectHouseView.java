package com.java.hrs.uil.rentHouse;

import javax.swing.JPanel;

import com.java.hrs.bll.GetHouse;
import com.java.hrs.bll.HouseMinimumInfo;
import com.java.hrs.bll.PriceRange;
import com.java.hrs.bll.SizeRange;
import com.java.hrs.dbl.DbGetHouse;
import com.java.hrs.uil.main.Body;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class SelectHouseView extends JPanel {

	Dimension dimension = new Dimension();
	Body bodyPanel = new Body();
	PriceRange priceRange = new PriceRange();
	SizeRange sizeRange = new SizeRange();
	HouseMinimumInfo houseMinimumInfo = new HouseMinimumInfo();
	DefaultComboBoxModel<String> priceRangeModel = new DefaultComboBoxModel<String>(priceRange.getPriceRange());
	DefaultComboBoxModel<String> sizeRangeModel = new DefaultComboBoxModel<String>(sizeRange.getSizeRage());
	
	
	private JTable tbHouseInfo;
	private JComboBox cbPriceRange;
	private JComboBox cbSizeRange; 
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	/**
	 * Create the panel.
	 */
	public SelectHouseView() {
		dimension.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut);
		
		JLabel lblNewLabel = new JLabel("Rent House");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.decode("#9DFDC7"));
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
		
		cbPriceRange = new JComboBox();
		cbPriceRange = new JComboBox<String>(priceRangeModel);
        cbPriceRange.setMaximumSize(new Dimension(200,40));
        cbPriceRange.setPreferredSize(new Dimension(200,40));
        cbPriceRange.setBackground(Color.decode("#61D2B4"));
        cbPriceRange.setForeground(Color.decode("#152744"));
        cbPriceRange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String item = String.valueOf(cbPriceRange.getSelectedItem());
				cbPriceFilter(item);
			}
		});
		sortBar.add(cbPriceRange);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		sortBar.add(horizontalGlue_1);
		
		cbSizeRange = new JComboBox();
		cbSizeRange = new JComboBox<String>(sizeRangeModel);
        cbSizeRange.setMaximumSize(new Dimension(200,40));
        cbSizeRange.setPreferredSize(new Dimension(200,40));
        cbSizeRange.setMaximumRowCount(4);
        cbSizeRange.setBackground(Color.decode("#61D2B4"));
        cbSizeRange.setForeground(Color.decode("#152744"));
        cbSizeRange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String item = String.valueOf(cbSizeRange.getSelectedItem());
				cbSizeFilter(item);
			}
		});
		sortBar.add(cbSizeRange);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		sortBar.add(horizontalGlue_2);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		
		//tbHouseInfo = new JTable();
		//tbHouseInfo.setBackground(Color.decode("#367591"));
		//tbHouseInfo.setForeground(Color.decode("#9DFDC7"));
		//tbHouseInfo.setModel(houseMinimumInfo.getDefaultTableModel());
		//tbHouseInfo.setRowHeight(100);
		//tbHouseInfo.getColumnModel().getColumn(0).setCellRenderer(tbHouseInfo.getDefaultRenderer(ImageIcon.class));
		//scrollPane.setViewportView(tbHouseInfo);
		//ButtonColumn buttonColumn = new ButtonColumn(tbHouseInfo, view, 4);
		mainPanel.add(scrollPane);
		//tbHouseInfo.setModel(new DefaultTableModel(houseMinimumInfo.getHouseMinimumInfos1(),10));
		//scrollPane.setViewportView(tbHouseInfo);
	}
	
	private void cbPriceFilter(String item) {
		tbHouseInfo = new JTable();
		tbHouseInfo.setBackground(Color.decode("#367591"));
		tbHouseInfo.setForeground(Color.decode("#9DFDC7"));
		tbHouseInfo.setModel(houseMinimumInfo.priceFilter(item));
		tbHouseInfo.setRowHeight(100);
		tbHouseInfo.getColumnModel().getColumn(0).setCellRenderer(tbHouseInfo.getDefaultRenderer(ImageIcon.class));
		ButtonColumn buttonColumn = new ButtonColumn(tbHouseInfo, view, 4);
		scrollPane.setViewportView(tbHouseInfo);
	}
	
	private void cbSizeFilter(String item) {
		tbHouseInfo = new JTable();
		tbHouseInfo.setBackground(Color.decode("#367591"));
		tbHouseInfo.setForeground(Color.decode("#9DFDC7"));
		tbHouseInfo.setModel(houseMinimumInfo.sizeFilter(item));
		tbHouseInfo.setRowHeight(100);
		tbHouseInfo.getColumnModel().getColumn(0).setCellRenderer(tbHouseInfo.getDefaultRenderer(ImageIcon.class));
		ButtonColumn buttonColumn = new ButtonColumn(tbHouseInfo, view, 4);
		scrollPane.setViewportView(tbHouseInfo);
	}
	
	Action view = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JTable table = (JTable)e.getSource();
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			String value = (String)tbHouseInfo.getValueAt(row, column);
			int id = Integer.parseInt(value);
			System.out.println(value);
			btnAction(id);
		}
	};
	
	private void btnAction(int id) {
		DbGetHouse getHouse = new DbGetHouse(id);
		mainPanel.setVisible(false);
		RentHouse rentHouse = new RentHouse(getHouse.getHouse());
		add(rentHouse);
	}

}
