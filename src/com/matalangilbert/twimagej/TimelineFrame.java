package com.matalangilbert.twimagej;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TimelineFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton _updateButton;
	private JLabel _latestStatus, _lblImage;
	private FlickrImage _image;
	private Tweet _tweet;
	private JPanel panel;
	private JPanel panel_2;
	
	public TimelineFrame() {
		super("Twimage!");
		setSize(new Dimension(1000, 600));
		init();
	}
	
	public void init() {	
		_image = new FlickrImage();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		_lblImage = new JLabel();
		_lblImage.setHorizontalAlignment(SwingConstants.CENTER);

		_lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(_lblImage);
		
		_latestStatus = new JLabel();
		_latestStatus.setHorizontalAlignment(SwingConstants.CENTER);
		_latestStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(_latestStatus, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		_updateButton = new JButton("Update");
		_updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				update();
			}
		});
		panel_2.add(_updateButton);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		update();
		setVisible(true);
	}
	
	@Override
	public Insets getInsets() {
		return (new Insets(40, 10, 20, 10));
	}

	private void update() {
		_lblImage.setIcon(new ImageIcon(_image.getNextMediumImage()));
		_latestStatus.setText(_tweet.getNextStatusText());
	}

}
