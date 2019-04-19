package helpers;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Window {
	
	public Window(String name_) {
		createWindow(name_);
	}



	private static void createWindow(String excName) {
		//Create and set up the window.
		JFrame frame = new JFrame(excName); 
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		JLabel textLabel = new JLabel(excName,SwingConstants.CENTER); 
		textLabel.setPreferredSize(new Dimension(300, 100)); 
		frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
		//Display the window
		frame.setLocationRelativeTo(null); 
		frame.pack(); 
		frame.setVisible(true); 
	} 
}
