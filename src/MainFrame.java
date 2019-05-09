import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



/**
 * 
 * @author angelapatini
 * 
 * creates a layout for JFrame and adds two text boxes and a search button
 *
 *runs song name and artist name through Andrew's code to get lyrics to run and return's answer

 */

public class MainFrame extends JFrame {
	
	public static JButton button;
	public static JTextArea sadResults;
	public JTextField songTextBox = new JTextField();
	public JTextField artistTextBox;
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
		
		//format the results text box
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

		
		
		//creates jlist for recommendations
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
		 *  puts words from what they click on in each text box
		 */
	
		songTextBox.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {		
		      }
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if (songTextBox.getText().equals("")) {
					jlist.setVisible(false);
				}
				list.clear();
				dlm.clear();
				jlist.clearSelection();
				
				try {
					list = SongRecommender.createListOfSongs(songTextBox.getText() + " ");
					
					
					if ((songTextBox.getText().length() == 0) && (artistTextBox.getText().length() > 0)) {
						list.clear();
						list = SongRecommender.createListOfSongs(artistTextBox.getText() + " ");
						
						if (list.size() > 0) {
							
							for (String song : list) {
								if (song.contains(" by ")) {
									String[] songAndArtist = song.split(" by ");
									if (songAndArtist.length == 2) {
										if (song.substring(song.indexOf("by ") + 2).contains(artistTextBox.getText())) {
											dlm.addElement(song);	
										}
									}
										
								}
								
							}
							jlist.setVisible(true);
							jlist.setBackground(Color.WHITE);
						}
						
					} else {
						if (list.size() > 0) {
							
							for (String song : list) {
								String[] songAndArtist = song.split(" by ");
								if (songAndArtist.length == 2) {
									if (artistTextBox.getText().length() > 0) {
										if (song.substring(song.indexOf("by ") + 2).contains(artistTextBox.getText())) {
											dlm.addElement(song);
										}
									} else {
										dlm.addElement(song);
									}
								}
								
							}
							jlist.setVisible(true);
							jlist.setBackground(Color.WHITE);
						}
					}	
				} catch (IOException e) {
					songTextBox.setText("Please try again.");
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
		 */
		artistTextBox.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyPressed(KeyEvent keyEvent) {
		      }
			
			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if (artistTextBox.getText().equals("")) {
				}
				list.clear();
				dlm.clear();
				jlist.clearSelection();
				
				try {
					list = SongRecommender.createListOfSongs(artistTextBox.getText());
					
					if ((artistTextBox.getText().length() == 0) && (songTextBox.getText().length() > 0)) {
						list.clear();
						list = SongRecommender.createListOfSongs(songTextBox.getText() + " ");
						
						
						if (list.size() > 0) {
							
							for (String song : list) {
								String[] songAndArtist = song.split(" by ");
								if (songAndArtist.length == 2) {
									dlm.addElement(song);
								}
								
							}
							jlist.setVisible(true);
							jlist.setBackground(Color.WHITE);
						}
							
						
					} else {
						if (list.size() > 0) {
							
							for (String song : list) {
								if (song.contains(" by ")) {
									String[] songAndArtist = song.split(" by ");
									if (songAndArtist.length == 2) {
										if (song.substring(song.indexOf("by ") + 2).contains(artistTextBox.getText())) {
											if (songTextBox.getText().length() > 0) {
												if (song.substring(0, song.indexOf(" by")).contains(songTextBox.getText())) {
														dlm.addElement(song);	
												} 
											} else {
												dlm.addElement(song);
											  }
										}
									}
										
								}
								
							}
							jlist.setVisible(true);
							jlist.setBackground(Color.WHITE);
						}
					}			
					
				} catch (IOException e) {
					artistTextBox.setText("Please try again.");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		
		
		
		/**
		 * puts words from what they click on in each text box when they click on recommendation 
		 */
			jlist.addListSelectionListener(new ListSelectionListener() {
				
					@Override
		            public void valueChanged(ListSelectionEvent arg0) {
						
		            	String[] songAndArtist = new String[2];
		            	if (!(jlist.getSelectedValue() == null)) {
		            		
		            		text = jlist.getSelectedValue().toString();
			            	songAndArtist = text.split(" by ");
			            	String song = songAndArtist[0];
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
		 * tells user what emotion this song will evoke 
		 */
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sadResults.setText("");
				String songName = songTextBox.getText();
				String artistName = artistTextBox.getText();
				
				CompareLyrics newCompare = new CompareLyrics();
				EmotionList emotionList = new EmotionList("emo1.csv");
				//String lyrics = "So I cross my heart and hope for you";
				
				/*
				 * This part is new: added by @Andrew Pai for testing purposes.
				 */
				
				
				Search search = new Search();
		    	
				try {
					String lyrics = search.LyricsSearch(songName, artistName);
					
					newCompare.mostFrequentEmotions(lyrics, emotionList.emotionDataBase);
					
					
					if ((songName.equals("")) || (artistName.equals("")) || (list.isEmpty())) {
						sadResults.append("We don't recognize that song, please try again.");
					} else {
						//temporary resutls until Yang writes method to return this
						sadResults.append("The main emotion elicited from " + songName + " by " + artistName + " is " +"\"" 
										+ newCompare.emotionAnalysis(newCompare.eightEmotionCounts) + "\"!");
					  }
				} catch (IOException e1) {
					sadResults.append("We do not have data on this song, sorry :)");
				}

				
				
			}
		});

	}

}
