import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


// creates a layout for JFrame and adds two text boxes and a search button

//then sends song name and artist name to Andrew 

public class MainFrame extends JFrame {
	
	public static JButton button;
	public static JTextArea sadResults;
	public JTextField songTextBox;
	public JTextField artistTextBox;

	public MainFrame(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		//creates song search toolbar
		songTextBox = new JTextField(20);
		JLabel songSearch = new JLabel("Song Name", JLabel.CENTER);
		
		//creates artist search toolbar
		artistTextBox = new JTextField(20);
		JLabel artistSearch = new JLabel("Artist Name", JLabel.CENTER);
		
		button = new JButton("How sad is this song?");
		
		JTextArea sadFaces1 = new JTextArea(
				":( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( ");
		sadFaces1.setEditable(false);
		JTextArea sadFaces2 = new JTextArea(
				":( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( :( ");
		sadFaces2.setEditable(false);
		
		sadResults = new JTextArea(20,50);
		sadResults.setLineWrap(true);
		sadResults.setEditable(false);
		
		
		
		/**
		 * creates list of options as the user types song name so that they can scroll if 
		 * they've typed enough
		 * 
		 *  need to put words from what they click on in each text box
		 */
		songTextBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		
		/**
		 * creates list of options as the user types artist name so that they can scroll if 
		 * they've typed enough 
		 * 
		 * need to put words from what they click on in each text box
		 */
		artistTextBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		
		
		/**
		 * if song is not an option, tells user it hasn't heard of this song
		 * 
		 * calls Andrew's classes to pass lyrics from this song to Yang
		 * 
		 * tells user how sad the song is
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String songName = songTextBox.getText();
				String artistName = artistTextBox.getText();
				
				//input these to method that gets lyrics and pass those to Yang and 
				//get sadness text back
				
				if (songName.equals("") && artistName.contentEquals("")) {
					sadResults.append("Please type an actual song.");
				} else {
					//temporary resutls until Yang writes method to return this
					sadResults.append(songName + " by " + artistName +  " is this level of sad..");
				}
				
				
				
				
			}
			
		});
		
		
		
		
		/**
		 * adds buttons and text boxes to frame
		 */
		
		Container c = getContentPane();
		JPanel search = new JPanel();
		search.add(songSearch);
		search.add(songTextBox);
		search.add(artistSearch);
		search.add(artistTextBox);
		
		JPanel sadButton = new JPanel();
		sadButton.add(sadFaces1);
		sadButton.add(button);
		sadButton.add(sadFaces2);
		
		JPanel results = new JPanel();
		results.add(sadResults);
		
		c.add(search);
		c.add(sadButton);
		c.add(results);
		

	}

}
