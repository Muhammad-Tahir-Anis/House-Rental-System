package com.java.hrs.uil.main;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Footer extends javax.swing.JPanel implements Runnable{
    Component horizontalGlue = Box.createHorizontalGlue();
    BoxLayout boxLayout = new BoxLayout(this,BoxLayout.X_AXIS);
    Dimension dimension = new Dimension();

    Font myFont1 = new Font(Font.SANS_SERIF, Font.BOLD, 24);

    Thread thread = new Thread(this);
    int hrs,min,sec;
    String time;
    Label labelDate=new Label("Date");

    public Footer(){
        if (labelDate == null) {
            assert false;
            labelDate.setText("DATA");
        }
        thread.start();
        labelDate.setFont(myFont1);
        labelDate.setForeground(Color.decode("#9DFDC7"));
        labelDate.setBackground(Color.decode("#152744"));
        labelDate.setMaximumSize(new Dimension(100,100));
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        dimension.setSize(dimension.width,labelDate.getHeight());
        setLayout(boxLayout);
        setOpaque(false);
        //setMaximumSize(dimension);
        setSize(dimension);
        setMaximumSize(dimension);
        add(horizontalGlue);
        add(labelDate);
    }

    @Override
    public void run() {
        while (true){
            Calendar calendar = Calendar.getInstance();
            hrs =calendar.get(Calendar.HOUR);
            min = calendar.get(Calendar.MINUTE);
            sec = calendar.get(Calendar.SECOND);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss aa");
            Date date = calendar.getTime();
            time = simpleDateFormat.format(date);
            labelDate.setText(time);
        }
    }
}
