import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmotionList {

	ArrayList <EmotionAndWords> emotionDataBase = new ArrayList <>(); 
	EmotionAndWords emo;
    
	/**
	 * This constructor reads from an emotion database. And the words and their corresponding emotions from the emotion database are fed into an arrayList 
	 * @param fileName
	 */
	
	public EmotionList (String fileName) {

		File file = new File (fileName);
		try {
			Scanner in = new Scanner (file);

			String line = "";
			line = in.nextLine();
			
			while(in.hasNextLine()) {
				line = in.nextLine();
				
				//System.out.println(line);
				String []parts = line.split(",");
				
				
				//int index1 = line.indexOf(" ");
				//System.out.println(index1);
				//String part1 = line.substring(0, index1);
				//String remainString = line.substring(index1+1);
				//String part2 = remainString.substring(0, remainString.indexOf(" "));
				//EmotionAndWords emo = new EmotionAndWords(part1, part2 );
				
				
				//System.out.println(parts[0]);
				//System.out.println(parts[1]);
				
				String emotionPart = parts[0];
				String wordPart = parts[1];
				
				wordPart = wordPart.replace("#", "");

				emo = new EmotionAndWords (emotionPart, wordPart);

				emotionDataBase.add(emo);
			}


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

}
