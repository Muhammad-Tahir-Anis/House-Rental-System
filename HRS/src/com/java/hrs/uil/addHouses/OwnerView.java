package com.java.hrs.uil.addHouses;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.java.hrs.bll.House;
import com.java.hrs.bll.Owner;
import com.java.hrs.bll.ResizeImage;
import com.java.hrs.dbl.DbHouse;
import com.java.hrs.dbl.DbOwner;
import com.java.hrs.uil.FormValidation;
import com.java.hrs.uil.main.Body;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class OwnerView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2019608160471686084L;
	Dimension dimension = new Dimension();
	Body bodyPanel = new Body();
	private JTextField tfName;
	private JTextField tfCnic;
	private JTextField tfAddress;
	public String filePath;
	private JTextField tfContact;
	private JPanel mainPanel;
	/**
	 * Create the panel.
	 */
	public OwnerView(House house) {
		//dimension = Toolkit.getDefaultToolkit().getScreenSize();
		dimension.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setOpaque(false);
		UIManager.getLookAndFeelDefaults().put( "TextField.caretForeground", Color.decode("#9DFDC7"));		
		
		mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		
		mainPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		mainPanel.setOpaque(false);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		mainPanel.add(verticalStrut);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		mainPanel.add(titlePanel);
		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		titlePanel.add(horizontalGlue_4);
		
		JLabel lblTitle = new JLabel("ADD HOUSES");
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblTitle.setForeground(Color.decode("#9DFDC7"));
		lblTitle.setAlignmentX(0.5f);
		titlePanel.add(lblTitle);
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		titlePanel.add(horizontalGlue_5);
		
		JLabel lblSubTitle = new JLabel("Owner Info");
		lblSubTitle.setOpaque(true);
		lblSubTitle.setBorder(new MatteBorder(1, 1, 1, 1, Color.decode("#152744")));
		lblSubTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblSubTitle.setForeground(Color.decode("#9DFDC7"));
		lblSubTitle.setBackground(Color.decode("#152744"));
		titlePanel.add(lblSubTitle);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		titlePanel.add(horizontalGlue_6);
		
		Component verticalGlue = Box.createVerticalGlue();
		mainPanel.add(verticalGlue);
		
		JPanel formPanel = new JPanel();
		formPanel.setOpaque(false);
		mainPanel.add(formPanel);
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		formPanel.add(horizontalGlue_1);
		
		JPanel panelImage = new JPanel();
		panelImage.setOpaque(false);
		formPanel.add(panelImage);
		panelImage.setLayout(new BoxLayout(panelImage, BoxLayout.Y_AXIS));
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(300, 300));
		lblImage.setOpaque(true);
		lblImage.setMinimumSize(new Dimension(300, 300));
		lblImage.setMaximumSize(new Dimension(300, 300));
		lblImage.setForeground(new Color(21, 39, 68));
		lblImage.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(21, 39, 68), new Color(157, 253, 199)), "Choose Image", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(21, 39, 68)));
		lblImage.setBackground(new Color(157, 253, 199));
		lblImage.setAlignmentX(0.5f);
		panelImage.add(lblImage);
		
		JButton btnChoose = new JButton("Choose Image");
		btnChoose.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnChoose.setMinimumSize(new Dimension(300,50));
		btnChoose.setMaximumSize(new Dimension(300,50));
		btnChoose.setBackground(Color.decode("#152744"));
		btnChoose.setForeground(Color.decode("#9DFDC7"));
		btnChoose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileChooser = new JFileChooser();				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("*.images", "jpg","png");
				fileChooser.addChoosableFileFilter(fileNameExtensionFilter);
				int result = fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					filePath = file.getAbsolutePath();
					ResizeImage resizeImage = new ResizeImage();
					lblImage.setIcon(resizeImage.resizeImage(lblImage, filePath));
				}
			}
		});
		panelImage.add(btnChoose);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		formPanel.add(horizontalGlue_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		formPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfName.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(21, 39, 68), new Color(157, 253, 199)), "Owner Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(157, 253, 199)));
		panel_1.add(tfName);
		tfName.setBackground(Color.decode("#152744"));
		tfName.setForeground(Color.decode("#9DFDC7"));
		//tfName.setCaretColor(Color.decode("#9DFDC7"));
		tfName.setColumns(20);
		tfName.setMinimumSize(new Dimension(1000,100));
		tfName.setMaximumSize(new Dimension(1000,100));
		
		Component verticalGlue_2 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_2);
		
		tfContact = new JTextField();
		tfContact.setMinimumSize(new Dimension(1000, 100));
		tfContact.setMaximumSize(new Dimension(1000, 100));
		tfContact.setForeground(new Color(157, 253, 199));
		tfContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		tfContact.setColumns(20);
		tfContact.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(21, 39, 68), new Color(157, 253, 199)), "Contact No.", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(157, 253, 199)));
		tfContact.setBackground(new Color(21, 39, 68));
		panel_1.add(tfContact);
		
		Component verticalGlue_3 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_3);
		
		tfCnic = new JTextField();
		tfCnic.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tfCnic.setBackground(Color.decode("#152744"));
		tfCnic.setForeground(Color.decode("#9DFDC7"));
		tfCnic.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(21, 39, 68), new Color(157, 253, 199)), "CNIC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(157, 253, 199)));
		tfCnic.setMinimumSize(new Dimension(1000, 100));
		tfCnic.setMaximumSize(new Dimension(1000, 100));
		tfCnic.setColumns(20);
		panel_1.add(tfCnic);
		
		Component verticalGlue_4 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_4);
		
		tfAddress = new JTextField();
		tfAddress.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tfAddress.setBackground(Color.decode("#152744"));
		tfAddress.setForeground(Color.decode("#9DFDC7"));
		tfAddress.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(21, 39, 68), new Color(157, 253, 199)), "Address", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(157, 253, 199)));
		tfAddress.setMinimumSize(new Dimension(1000, 100));
		tfAddress.setMaximumSize(new Dimension(1000, 100));
		tfAddress.setColumns(20);
		panel_1.add(tfAddress);
		
		Component verticalGlue_5 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_5);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnAdd.setBackground(Color.decode("#152744"));
		btnAdd.setForeground(Color.decode("#9DFDC7"));
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FormValidation formValidation = new FormValidation();
				if(formValidation.OwnerFormValidation(tfName, tfContact, tfCnic, tfAddress, filePath)) {
					Owner owner = new Owner(tfName.getText(),tfContact.getText(),tfCnic.getText(),tfAddress.getText(),filePath);
					DbHouse dbHouse = new DbHouse();
					dbHouse.insert(house);
					DbOwner dbOwner = new DbOwner();
					dbOwner.insert(owner);
					JOptionPane optionPane = new JOptionPane();
					optionPane.showMessageDialog(mainPanel, "House is Added");
					btnAddHouseView();
					}
				}
		});
		panel_1.add(btnAdd);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		formPanel.add(horizontalGlue);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		mainPanel.add(verticalGlue_1);

	}
	
	private void btnAddHouseView() {
		mainPanel.setVisible(false);
    	HouseView houseView = new HouseView();
    	add(houseView);
	}
}
