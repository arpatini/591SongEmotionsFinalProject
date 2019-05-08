import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Design {
	
	//creates the JFrame 
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable()  {
			public void run() {
				JFrame frame = new MainFrame("Song Sadness Scale");
				frame.setSize(1000,800);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.setFocusable(true);
				frame.requestFocusInWindow();
				
			}
		});
		
	}
	

}
