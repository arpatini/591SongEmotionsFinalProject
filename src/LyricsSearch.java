import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;


/**
 * Created by Aakash on 4/9/2017.
 * Modified by Andrew Pai and 4/21/2019.
 */
public class LyricsSearch {
    public static void main(String[] args) throws IOException {
        ArrayList<String> artistNames = new ArrayList<>();
    	ArrayList<String> songNames = new ArrayList<>();
        ArrayList<String> urls = new ArrayList<>();
   
        System.out.println("1: Search for Artist / 2: Search for Title");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        
        if (choice == 1) {
        	System.out.println("What artist do you want?");
        	Scanner choice1 = new Scanner(System.in);
        	String artist = choice1.nextLine();
        	artist = artist.replaceAll(" ", "");
        	artist = Character.toLowerCase(artist.charAt(0)) + "/" + artist;
        	String searchbyArtist = "https://www.azlyrics.com/" + artist;
        	
        	Document site1 = Jsoup.connect(searchbyArtist).get();
            Elements lyricsTable1 = site1.select("div.panel");
        	
   

        }
        else if (choice == 2){
        	System.out.println("What song do you want?");
        	Scanner choice2 = new Scanner(System.in);
        	String song = choice2.nextLine();
        	
            song = song.replaceAll(" ", "+");
            String searchbyTitle = "http://search.azlyrics.com/search.php?q="+song+"&w=songs&p=1";

            Document site = Jsoup.connect(searchbyTitle).get();
            Elements lyricsTable = site.select("div.panel");

            
            for (Element elm : lyricsTable){
            	/*
            	if (elm.text().contains("Artist results:")) {
                    continue;
                }
                if (elm.text().contains("Album")) {
                    continue;
                }
                //System.out.println(elm);
                 */
                Elements table = elm.select("table > tbody > tr");
                for (Element elms : table) {
                    if (elms.text().contains("More Song Results")) {
                        continue;
                    }
                    elms.select("small").html("");
                    songNames.add(elms.text());
                    urls.add(elms.select("a").attr("href"));

                }
            }
            songNames.remove(0); //first link has pages
            songNames.remove(songNames.size() - 1); //last link has pages info
        }

        
        //System.out.println(song);
        /*
        * The general syntax for searching in AZLyrics is http://search.azlyrics.com/search.php?q=(something)
        * So, I just took the part till the '=' and added whatever the user wanted
        * Now, the links come under a bunch of <td> tags
        * When looking at the HTML you can see that the links are in a <tr> tag
        * One more thing to take notice is that AZLyrics will also give you results on similar ALbums
        * Sice we are only interested in songs, I wrote a few lines of code to skip over that
        * Now, we select the <div> tag where the class name is "panel"
        * This tag will might have both the album results and the song results
        * After skipping the album results, we can scrape the <tr> tags
        * We can't stop there yet, the <tr> tags have a <small> tag that contains a small snippet from the full lyrics
        * I wrote a line of code to replace the <small> tag with an empty space, so not using the .text() method will give the name of the song alone
         */
        
        
            
        
        
        for (int j = 0; j < songNames.size(); j++) {
            System.out.println(songNames.get(j));
            //System.out.println(urls.get(j));
        }
        
        System.out.println("Enter your option");
        int choice2 = in.nextInt();
        Document lyricPage = Jsoup.connect(urls.get(choice2)).get();
        Elements lyricTags = lyricPage.select("div[class='col-xs-12 col-lg-8 text-center']>div");
        String lyrics = new String();
        /*
        * Now, that I've gotten the lyric URL, I tried to scrape the tag which contains the lyrics
        * To remove a few <div> tags that had unnecessary text, I had to make a very very long if statement consisting of all the classes I didn't want
        * I was forced to make a long if statement because the div tag containing the lyrics did not have a class at all :(
         */
        for (Element elm : lyricTags) {
            if(elm.attr("class").equals("div-share noprint")||elm.attr("class").equals("collapse noprint")||elm.attr("class").equals("panel album-panel noprint")||elm.attr("class").equals("noprint")||elm.attr("class").equals("smt")||elm.attr("class").equals("hidden")||elm.attr("class").equals("smt noprint")||elm.attr("class").equals("div-share")||elm.attr("class").equals("lyricsh")||elm.attr("class").equals("ringtone")) {
                continue;
            }
            lyrics = elm.text();
            break;
            //System.out.println(elm.text());
        }
        System.out.println(lyrics);
    }

}