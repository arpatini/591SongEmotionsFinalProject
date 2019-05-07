import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.hamcrest.Matcher;
import org.jsoup.Jsoup;

import java.util.*;

public class SongRecommender {
	
	/**
	 * returns list of songs with their artist when typing song name
	 * 
	 * outputs String[]
	 */
	
	public static ArrayList<String> createListOfSongsFromSong(String wordBeingTyped) throws IOException{
		ArrayList<String> matchingSongs = new ArrayList<String>();
		
		wordBeingTyped.replaceAll(" ", "+");
		
		String searchbyTitle = "http://search.azlyrics.com/search.php?q="+wordBeingTyped+"&w=songs&p=1";
		
		
		Document site = Jsoup.connect(searchbyTitle).get();
	    Elements lyricsTable = site.select("div.panel");
	    
	    for (Element a : lyricsTable){
	        Elements table = a.select("table > tbody > tr"); //the jSoup interface requires us to look at tr in tbody
	        for (Element elms : table) {
	            elms.select("small").html("");
	            matchingSongs.add(elms.text());

	        }
	    }
	    
	    if (matchingSongs.size() > 0) {
	    	matchingSongs.remove(0); //first link has pages info 
		    matchingSongs.remove(matchingSongs.size() - 1); //last link has pages info too
	    }
	    
	    
	    
	    return matchingSongs;

	}
	
	/**
	 * returns list of songs with their artist when typing artist name
	 * 
	 * outputs String[]
	 */
	
	public ArrayList<String> createListOfSongsFromArtist(String wordBeingTyped) {
		ArrayList<String> matchingArtists = new ArrayList<String>();
		
		
		return matchingArtists;

	}
	
	
	//creates a JList from above list for user to scroll through as they are typing 
	//outputs JList
	public static JList createJListOfSongs(ArrayList<String> listOfSongsAndArtistsThatMatch) {
	//	creates JList to pass to songTextBox.ActionListener and artistTextBox.ActionListener;
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> listOfOptions = new JList<>(dlm);
		for (String song : listOfSongsAndArtistsThatMatch) {
			dlm.addElement(song);
			listOfOptions.setModel(dlm);

		}

		
		
		
		return listOfOptions;
	}
	
	public static void main(String[] args) {
		try {
			createJListOfSongs(createListOfSongsFromSong("listen"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
