import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.parser.ParserDelegator;


// creates a layout for JFrame and adds two text boxes and a search button

//then sends song name and artist name to Andrew 

public class MainFrame extends JFrame {
	
	public static JButton button;
	public static JTextArea sadResults;
	public JTextField songTextBox = new JTextField();
	public JTextField artistTextBox;
	private DefaultListModel modelList;
	JList<String> jlist = new JList<String>();
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	ArrayList<String> list = new ArrayList<String>();
	String text = "";
	
	

	public MainFrame(String title) {
		
		
		super(title);
		
		setLayout(new BorderLayout());
		
		//creates song search toolbar
		songTextBox = new JTextField(20);
		JLabel songSearch = new JLabel("Song Name", JLabel.CENTER);
		songTextBox.setFocusable(true);
		
		//creates artist search toolbar
		artistTextBox = new JTextField(20);
		JLabel artistSearch = new JLabel("Artist Name", JLabel.CENTER);
		
		button = new JButton("What emotion will I feel if I listen to this song?");
		
		JTextArea sadFaces1 = new JTextArea(
				":( :/ :) :( :/ :) :( :/ :) :( :/ :) :( :/ :) :( :/ :) :( :/ ");
		sadFaces1.setEditable(false);
		JTextArea sadFaces2 = new JTextArea(
				":( :/ :) :( :/ :) :( :/ :) :( :/ :) :( :/ :) :( :/ :) :( :/ ");
		sadFaces2.setEditable(false);
		
		sadResults = new JTextArea(20,40);
		sadResults.setLineWrap(true);
		sadResults.setWrapStyleWord(true);
		sadResults.setEditable(false);
		
		
		
		
		
		/**
		 * adds buttons and text boxes to frame
		 */
		
		Container c = getContentPane();
		c.setFocusable(true);
		JPanel search = new JPanel();
		search.setBackground(Color.white);
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

		
		
		
		jlist.setModel(dlm);
		jlist.setVisible(false);
		jlist.setFocusable(true);
	    jlist.requestFocus();
		jlist.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

		JPanel pane = new JPanel();
		pane.setVisible(true);
		pane.setFocusable(true);
		pane.add(jlist);
		pane.setBackground(Color.lightGray);
		
		JPanel buttonAndResults = new JPanel();
		buttonAndResults.setBackground(Color.white);
		buttonAndResults.add(sadButton);
		buttonAndResults.add(results);

		c.add(search, BorderLayout.NORTH);
		c.add(pane, BorderLayout.CENTER);	
		c.add(buttonAndResults, BorderLayout.SOUTH);
		
		
		
		
		
		
		/**
		 * creates list of options as the user types song name so that they can scroll if 
		 * they've typed enough
		 * 
		 *  need to put words from what they click on in each text box
		 */
		songTextBox.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				list.clear();
				dlm.clear();
				jlist.clearSelection();
				
				try {
					list = SongRecommender.createListOfSongs(songTextBox.getText() + " ");
					
		
					if (list.size() > 0) {
						
						for (String song : list) {
							String songWithoutNumber = song.substring(song.indexOf(" "));
							dlm.addElement(songWithoutNumber);
						}
						jlist.setVisible(true);
						jlist.setBackground(Color.WHITE);
					}
						
					
				} catch (IOException e) {
					songTextBox.setText("Please try again.");
				}
				
		      }
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if (songTextBox.getText().equals("")) {
					jlist.setVisible(false);
				}
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
		artistTextBox.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				list.clear();
				dlm.clear();
				jlist.clearSelection();
				
				try {
					list = SongRecommender.createListOfSongs(artistTextBox.getText());
					
		
					if (list.size() > 0) {
						
						for (String song : list) {
							if (song.contains(" by ")) {
								if (song.substring(song.indexOf("by ") + 2).contains(artistTextBox.getText())) {
									String songWithoutNumber = song.substring(song.indexOf(" "));
									dlm.addElement(songWithoutNumber);
								}	
							}
							
						}
						jlist.setVisible(true);
						jlist.setBackground(Color.WHITE);
					}
						
					
				} catch (IOException e) {
					artistTextBox.setText("Please try again.");
				}
				
		      }
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if (artistTextBox.getText().equals("")) {
					jlist.setVisible(false);
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		
		
		
			jlist.addListSelectionListener(new ListSelectionListener() {
				
					@Override
		            public void valueChanged(ListSelectionEvent arg0) {
						
		            	String[] songAndArtist = new String[2];
		            	if (!(jlist.getSelectedValue() == null)) {
		            		text = jlist.getSelectedValue().toString();
			            	songAndArtist = text.split(" by ");
			            	String song = songAndArtist[0].substring(songAndArtist[0].indexOf(" "));
			                songTextBox.setText(song);
			                artistTextBox.setText(songAndArtist[1]);
			                artistTextBox.setEditable(true);
			                jlist.setVisible(false);
			                jlist.clearSelection();
		            	}	
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
				sadResults.setText("");
				String songName = songTextBox.getText();
				String artistName = artistTextBox.getText();
				
				//input these to method that gets lyrics and pass those to Yang and 
				//get sadness text back
				
				if ((songName.equals("")) || (artistName.equals("")) || (list.isEmpty())) {
					sadResults.append("We don't recognize that song, please try again.");
				} else {
					//temporary resutls until Yang writes method to return this
					sadResults.append(songName + " by " + artistName +  " is this emotion");
				}
				
				
				
				
			}
			
		});
		
		
		
		
		

	}

}
