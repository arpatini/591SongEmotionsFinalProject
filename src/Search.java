import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Search {
	String lyrics = "";
	
	/**
	 * @author Andrew Pai
	 * With help from Aakash's original code: https://github.com/AakashSasikumar/Blog/blob/master/webscraping/AZLyrics/AZLyricsScraper.java.
	 * The TitleSearch method searches for a song title, crawling it up using the Jsoup method.
	 * The ArtistSearch method is to be written.
	 */
	
	public void TitleSearch() throws IOException{
		ArrayList<String> songNames = new ArrayList<>();
        ArrayList<String> urls = new ArrayList<>();
        
        //We ask user to search for song title.
		System.out.println("What song do you want?");
		Scanner choice = new Scanner(System.in);
		String song = choice.nextLine();
		
	    song = song.replaceAll(" ", "+");
	    String searchbyTitle = "http://search.azlyrics.com/search.php?q="+song+"&w=songs&p=1";
	    
	    Document site = Jsoup.connect(searchbyTitle).get();
	    Elements lyricsTable = site.select("div.panel");

	    
	    for (Element a : lyricsTable){
	        Elements table = a.select("table > tbody > tr"); //the jSoup interface requires us to look at tr in tbody
	        for (Element elms : table) {
	            elms.select("small").html("");
	            songNames.add(elms.text());
	            urls.add(elms.select("a").attr("href"));

	        }
	    }
	   
	    songNames.remove(0); //first link has pages info 
	    songNames.remove(songNames.size() - 1); //last link has pages info too
	   

		for (int j = 0; j < songNames.size(); j++) {
		    System.out.println(songNames.get(j));
		}
		System.out.println("Enter your option");
		
		Scanner in = new Scanner(System.in);
		int choice2 = in.nextInt();
		String link = urls.get(choice2);
		removeLyricClutter(link);
	}
	
	public void removeLyricClutter(String s) throws IOException {
		Document lyricPage = Jsoup.connect(s).get();
		Elements lyricTags = lyricPage.select("div[class='col-xs-12 col-lg-8 text-center']>div");
		
		for (Element elm : lyricTags) {
			
			//Reduce clutter.
		    if(elm.attr("class").equals("div-share noprint")||elm.attr("class").equals("div-share")||elm.attr("class").equals("lyricsh")||elm.attr("class").equals("ringtone")) {
		        continue;
		    }
		    lyrics = lyrics + elm.text();
		    break;
		}
		System.out.println(lyrics);
	}
	/*
	 * Artist-search will be written.
	 */
	public void ArtistSearch() {
		System.out.println("To be written.");
	}

	
	//return lyrics
	public String getLyrics() {
		return lyrics;
	}
	
}