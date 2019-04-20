import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Design {
	
	//creates the JFrame using MainFrame
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable()  {
			public void run() {
				JFrame frame = new MainFrame("Song Sadness Scale");
				frame.setSize(700,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
	}
	

}
