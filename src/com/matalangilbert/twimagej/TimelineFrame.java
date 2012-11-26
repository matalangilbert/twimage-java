package com.matalangilbert.twimagej;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import twitter4j.*;


public class TimelineFrame extends JFrame implements ActionListener{
	private JButton _updateButton;
	private JLabel _latestStatus, _lblImage;
	
	public TimelineFrame() {
		super("Twimage-J");
		init();
	}
	
	public void init() {	
		setLookAndFeel();
		setSize(800, 600);
		
		GridLayout grid = new GridLayout(3,1);
		setLayout(grid);
		
		_updateButton = new JButton("Update");
		_updateButton.setActionCommand("update");
		_updateButton.addActionListener(this);
		
		_latestStatus = new JLabel((UpdateStatus.getNew().getText()),JLabel.CENTER);
		
		_lblImage = new JLabel(new ImageIcon(FlickrImage.getNew()));
		
		add(_updateButton);
		add(_latestStatus);
		add(_lblImage);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(
					"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
					);
		} catch (Exception ex) {
			// couldn't set new theme - default to old.
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if("update".equals(e.getActionCommand())){
			_latestStatus.setText(UpdateStatus.getNew().getText());
			_lblImage.setIcon(new ImageIcon(FlickrImage.getNew()));
		}
		
	}
	
	
	
	

}
