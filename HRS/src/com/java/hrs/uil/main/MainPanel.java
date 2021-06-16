package com.java.hrs.uil.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.java.hrs.bll.PriceRange;
import com.java.hrs.bll.SizeRange;
import com.java.hrs.dbl.DbHouseList;
import com.java.hrs.dbl.DbPriceRange;
import com.java.hrs.dbl.DbSizeRange;
import com.java.hrs.uil.Body;
import com.java.hrs.uil.addHouses.HouseView;


public class MainPanel extends javax.swing.JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5911258962064640273L;
	Dimension MPdimension = new Dimension();
    Dimension Hdimension = new Dimension();
    Component verticalGlue = Box.createVerticalGlue();
    Header headerPanel = new Header();
    Footer footer = new Footer();
    Body body = new Body();
    HouseView houseView = new HouseView();
    JPanel view = houseView;
    private BufferedImage image;
    
    private void btnHomeAction(ActionEvent event) {
    	this.remove(1);
		this.add(body,1);
		body.removeAll();
		body.add(body.bodyPanel);
		this.revalidate();
	}
    
    private void comboBoxAction(int index) {
    	switch (index) {
		case 0: {
			this.remove(1);
			this.add(houseView,1);
			this.revalidate();
			break;
		}
		case 1: {
			this.remove(1);
			this.add(body,1);
			this.revalidate();
			break;
		}
		case 2: {
			this.remove(1);
			this.add(houseView,1);
			this.revalidate();
			break;
		}
		case 3: {
			this.remove(1);
			this.add(houseView,1);
			this.revalidate();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + index);
		}
    }

    public MainPanel(){
        try {
            image = ImageIO.read(new File("D:\\Eclipse Workspace\\HRS\\src\\recources\\bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        BoxLayout boxLayoutY = new BoxLayout(this,BoxLayout.Y_AXIS);
        //BoxLayout boxLayoutX = new BoxLayout(this,BoxLayout.X_AXIS);
        MPdimension = Toolkit.getDefaultToolkit().getScreenSize();
        Hdimension = Toolkit.getDefaultToolkit().getScreenSize();
        Hdimension.setSize(Hdimension.width*2,100);
        setLayout(boxLayoutY);
        setOpaque(false);
        setPreferredSize(MPdimension);
        
        
        add(headerPanel);
        
        headerPanel.btnHeaderHomeIcon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHomeAction(e);
			}
		});
        headerPanel.comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comboBoxAction(headerPanel.comboBox.getSelectedIndex());
			}
		});
        add(body);
        add(footer);
        DbHouseList dbHouseList = new DbHouseList();
        SizeRange sizeRange = new SizeRange();
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);// see javadoc for more info on the parameters
    }
}