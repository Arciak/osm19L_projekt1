package helpers;

import java.awt.*;
import javax.swing.*; 

/********************************************************************
 * tworzymy wyjatek ktory bedzie otwoerac okno z info o wyjatku		*
 * @author arciak													*	
 *																	*
 ********************************************************************/



public class Exceptions  extends Exception {
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
    public Exceptions(String message) {
    	super(message);
    	createWindow(message);
    }
}
