package com.java.hrs.uil;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class AddToRent extends JPanel {

	Dimension dimension = new Dimension();
	Body bodyPanel = new Body();
	/**
	 * Create the panel.
	 */
	public AddToRent() {
		dimension.setSize(bodyPanel.getWidth(),bodyPanel.getHeight());
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(50);
		add(verticalStrut);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
	}

}
