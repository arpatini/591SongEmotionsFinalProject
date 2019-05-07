import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


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
		 * adds buttons and text boxes to frame
		 */
		
		Container c = getContentPane();
		c.setFocusable(true);
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
		
		JScrollPane pane = new JScrollPane();
		pane.setVisible(true);
		
		c.add(search);
		c.add(pane);
		c.add(sadButton);
		c.add(results);
		
		
		
		
		/**
		 * creates list of options as the user types song name so that they can scroll if 
		 * they've typed enough
		 * 
		 *  need to put words from what they click on in each text box
		 */
		songTextBox.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				ArrayList<String> list = new ArrayList<String>();
				
				try {
					list = SongRecommender.createListOfSongsFromSong(songTextBox.getText());
					JList<String> jlist = new JList<String>();
					
					if (list.size() > 0) {
						
						pane.add(jlist);
						jlist = SongRecommender.createJListOfSongs(list);
						jlist.setVisible(true);
						jlist.setFocusable(true);
					    jlist.requestFocus();
						search.add(pane);
						
						jlist.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
						//jlist.addListSelectionListener(new ListSelectionListener() {

				           // @Override
				            //public void valueChanged(ListSelectionEvent arg0) {
				            //	String text = jlist.getSelectedValue().toString();
				            //    if (!arg0.getValueIsAdjusting()) {
				             //     songTextBox.setText(text);
				              //    jlist.setVisible(false);
				             //   }
				            //}
						//});
					}
						
					
				} catch (IOException e) {
					songTextBox.setText("Please try again.");
				}
				
		      }
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
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
		
		
		
		
		

	}

}
