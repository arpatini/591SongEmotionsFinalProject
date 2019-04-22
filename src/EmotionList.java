import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//An emotion database is fed in here. And the words and their corresponding emotions are fed into an arraylist
public class EmotionList {
	
	ArrayList <EmotionAndWords> emotionDataBase = new ArrayList <>(); 
	
	public void inputEmotionList (String fileName) {
	
	File file = new File (fileName);
	try {
		Scanner in = new Scanner (file);

		String line = "";
		in.nextLine();
		
		while(in.hasNextLine()) {
			line = in.nextLine();
			String []parts = line.split(",");
			
			EmotionAndWords emo = new EmotionAndWords (parts[1], parts[2]);
			
			emotionDataBase.add(emo);
		}

		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}	
}
