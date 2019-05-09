import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Search {

	/**
	 * @author Andrew Pai
	 * The TitleSearch method searches for a song title, crawling it up using the Jsoup method.
	 * @param songName is the song name that we get from the search function
	 * @param artistName is the artist name that we get from search function
	 */
	
	public String LyricsSearch(String songName, String artistName) throws IOException{
		String lyrics ="";
		
        //We strip song name and artist name of all punctuation
        String songNameClean = songName.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        String artistNameClean = artistName.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        
	    String searchLink = "https://www.azlyrics.com/lyrics/"+artistNameClean+"/"+songNameClean+".html";	    
		Document lyricPage = Jsoup.connect(searchLink).get();
		Elements lyricTags = lyricPage.select("div[class='col-xs-12 col-lg-8 text-center']>div");
		
		
		//Using the jsoup database, we identify the lyrics
		for (Element elm : lyricTags) {	
			//Reduce clutter.
		    if(elm.attr("class").equals("div-share noprint")||elm.attr("class").equals("div-share")||elm.attr("class").equals("lyricsh")||elm.attr("class").equals("ringtone")) {
		        continue;
		    }
		    lyrics = lyrics + elm.text();
		    break;
		}
		return lyrics;
	}
	


}