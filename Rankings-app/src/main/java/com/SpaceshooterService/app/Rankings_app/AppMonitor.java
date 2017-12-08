package com.SpaceshooterService.app.Rankings_app;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class AppMonitor extends JFrame {
	
	JPanel mainPanel;
	JTextArea mainText;
	
	public AppMonitor() {
		this.setBounds(300, 300, 600, 500);
		this.setVisible(true);
		this.setTitle("REST-Monitor");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) { System.exit(0); }
		});
		createPanel();
	}	
	
	private void createPanel() {					
		mainPanel = new JPanel();		
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(mainPanel);
		mainPanel.setLayout(null);
		this.setResizable(false);		
		
		//Scrollbare TextArea für Info-Output							
		mainText = new JTextArea("Start");		
		JScrollPane mainScrPane = new JScrollPane(mainText);
		mainScrPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainScrPane.setBounds(100, 50, 400 , 250);
		mainScrPane.setVisible(true);
		mainScrPane.setBackground(Color.RED);		
		mainPanel.add(mainScrPane);
		
		this.setContentPane(mainPanel);		
	}
	
	public void writeText(String text) {
		mainText.append("\n" + text);	
	}
}
