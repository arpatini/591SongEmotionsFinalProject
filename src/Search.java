import org.jsoup.HttpStatusException;
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
		//Artists with articles in their names, like The Beatles, should be stripped of the articles.
		if (artistName.startsWith("The ")) {
			artistName = artistName.replaceFirst("The ","");
		}
		else if (artistName.startsWith("A ")) {
			artistName = artistName.replaceFirst("A ","");
		}
		
        //We strip song name and artist name of all punctuation
	
        String songNameClean = songName.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
        String artistNameClean = artistName.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
    	String searchLink = "https://www.azlyrics.com/lyrics/"+artistNameClean+"/"+songNameClean+".html";
    	Document lyricPage;

        try{
        	lyricPage = Jsoup.connect(searchLink).get();
        } catch (HttpStatusException e) {
        	lyricPage = Jsoup.connect(AlternateSearch(songName, artistName)).get();
        }
      
        Elements lyricTags = lyricPage.select("div[class='col-xs-12 col-lg-8 text-center']>div"); //this is the divpanel in which he lyrics are located
		
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
	
	/*
	 * Sometimes, the link is not identifiable by the artist name and the song name. In these cases, we try the alternate method, in which the search query is searched and the first result is given.
	 */
	public String AlternateSearch(String songName, String artistName) throws IOException{
		String lyrics = "";
		songName = songName.replaceAll(" ", "+");
		artistName = artistName.replaceAll(" ","+");
	    String searchLink = "http://search.azlyrics.com/search.php?q="+songName+"+by+"+artistName+"&w=songs&p=1";
	    
	    Document site = Jsoup.connect(searchLink).get();
	    Elements lyricsTable = site.select("div.panel");
	    Elements table = lyricsTable.select("table > tbody > tr");
	    table.next();
	    String url = table.select("a").attr("href");
	    
	    return url;	
	}
	
	
}