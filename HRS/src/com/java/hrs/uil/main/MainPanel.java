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
import com.java.hrs.dbl.DbHouse;
import com.java.hrs.dbl.DbHouses;
import com.java.hrs.dbl.DbPriceRange;
import com.java.hrs.dbl.DbSizeRange;
import com.java.hrs.uil.addHouses.HouseView;
import com.java.hrs.uil.rentHouse.SelectHouseView;
import com.java.hrs.uil.rentHouse.TenantView;
import com.java.hrs.uil.viewHouse.ViewHouses;
import com.java.hrs.uil.viewTenant.ViewTenants;


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
    //JPanel view = houseView;
    private BufferedImage image;
    
    private void btnHomeAction(ActionEvent event) {
    	this.remove(1);
    	body.removeAll();
    	body.add(body.bodyPanel);
		this.add(body,1);
		this.revalidate();
	}
    
    private void comboBoxAction(int index) {
    	switch (index) {
		case 0: {
		    HouseView houseView = new HouseView();
			this.remove(1);
			this.add(houseView,1);
			this.revalidate();
			break;
		}
		case 1: {
		    SelectHouseView selectHouseView = new SelectHouseView();
			this.remove(1);
			this.add(selectHouseView,1);
			this.revalidate();
			break;
		}
		case 2: {
			ViewHouses viewHouses = new ViewHouses();
			this.remove(1);
			this.add(viewHouses,1);
			this.revalidate();
			break;
		}
		case 3: {
		    ViewTenants viewTenants = new ViewTenants();
			this.remove(1);
			this.add(viewTenants,1);
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
        
        // Adding header//
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
        //SizeRange sizeRange = new SizeRange();
        //DbHouses dbHouses = new DbHouses();
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);// see javadoc for more info on the parameters
    }
}