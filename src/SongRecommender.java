import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;


public class SongRecommender {
	
	/**
	 * returns list of songs with their artist when typing in search
	 * 
	 * outputs ArrayList<String> to create JList in MainFrame
	 */
	
	public static ArrayList<String> createListOfSongs(String wordBeingTyped) throws IOException{
		ArrayList<String> matchingSongs = new ArrayList<String>();
		
		wordBeingTyped.replaceAll(" ", "+");
		
		String searchbyTitle = "http://search.azlyrics.com/search.php?q="+wordBeingTyped+" &w=songs&p=1";
		
		
		Document site = Jsoup.connect(searchbyTitle).get();
	    Elements lyricsTable = site.select("div.panel");
	    
	    for (Element a : lyricsTable){
	        Elements table = a.select("table > tbody > tr"); //the jSoup interface requires us to look at tr in tbody
	        for (Element elms : table) {
	            elms.select("small").html("");
	            if (!(matchingSongs.contains(elms.text().substring(elms.text().indexOf(" "))))) {
	            	matchingSongs.add(elms.text().substring(elms.text().indexOf(" ") + 1));
	            }
	        }
	    }
	    
	    if (matchingSongs.size() > 0) {
	    	matchingSongs.remove(0); //first link has pages info 
		    matchingSongs.remove(matchingSongs.size() - 1); //last link has pages info too
	    }
	    return matchingSongs;
	}


}
