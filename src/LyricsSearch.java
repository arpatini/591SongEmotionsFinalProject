import java.io.IOException;
import java.util.*;


/**
 * Created by Aakash on 4/9/2017.
 * Modified by Andrew Pai and 4/21/2019.
 * The 
 */

public class LyricsSearch {
    public static void main(String[] args) throws IOException {
        System.out.println("1: Search for Artist / 2: Search for Title");
        Search search = new Search();
        
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        
        if (choice == 1) {
        	
        }
        else if (choice == 2){
        	search.TitleSearch();
        }
        System.out.println(search.getLyrics());
    }
}