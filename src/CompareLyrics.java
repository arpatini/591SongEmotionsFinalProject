import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CompareLyrics {

	EmotionAndWords newEmo = new EmotionAndWords(null, null);

	int countAnticipation;
	int countFear;
	int countAnger;
	int countTrust;
	int countSurprise;
	int countSadness;
	int countJoy;
	int countDisgust;
	
	HashMap <String, Integer> eightEmotionCounts = new HashMap <>();
	
	/**
	 * This method compares each word from lyrics with the emotion database, the word is then correlated with the emotion associated with it.
	 * The occurrences of 8 emotions are counted and summarized into a hashMap
	 * @param lyrics
	 * @param emotionDataBase
	 */
	public void mostFrequentEmotions(String lyrics, ArrayList <EmotionAndWords> emotionDataBase) {

		String [] parts = lyrics.split(" ");


		for (int i = 0; i < parts.length; i ++) {

			for (int j  = 0; j < emotionDataBase.size(); j++) {
               
				if (parts[i].equals(emotionDataBase.get(j).word)) {


					if (emotionDataBase.get(j).emotion.equals("anticipation")) {
						countAnticipation++;
					}

					if (emotionDataBase.get(j).emotion.equals("fear")) {
						countFear++;
					}

					if (emotionDataBase.get(j).emotion.equals("Anger")) {
						countAnger++;
					}

					if (emotionDataBase.get(j).emotion.equals("trust")) {
						countTrust++;
					}

					if (emotionDataBase.get(j).emotion.equals("surprise")) {
						countSurprise++;
					}

					if (emotionDataBase.get(j).emotion.equals("sadness")) {
						countSadness++;
					}

					if (emotionDataBase.get(j).emotion.equals("joy")) {
						countJoy++;
					}

					if (emotionDataBase.get(j).emotion.equals("disgust")) {
						countDisgust++;
					}
				}	
			}
		}
	    eightEmotionCounts.put("anticipation", countAnticipation);
	    eightEmotionCounts.put("fear", countFear);
	    eightEmotionCounts.put("anger", countAnger);
	    eightEmotionCounts.put("trust", countTrust);
	    eightEmotionCounts.put("surprise", countSurprise);
	    eightEmotionCounts.put("sadness", countSadness);
	    eightEmotionCounts.put("joy", countJoy);
	    eightEmotionCounts.put("disgust", countDisgust);
	}

	
	/**
	 * Analyze the counts of the eight emotions associated with the words in the song lyrics, return the emotion most elicited from the lyrics
	 * @param eightEmotionCounts
	 * @return
	 */
	public String emotionAnalysis (HashMap<String, Integer> eightEmotionCounts) {
		int max = 0;
		String item = null;
		
		for (String s : eightEmotionCounts.keySet()) {
			System.out.print(s + " ");
			System.out.println(eightEmotionCounts.get(s));
			
			if (eightEmotionCounts.get(s) > max) {
				max = eightEmotionCounts.get(s);
				item = s;
				
			}
		}
		
		return item;	
	}

	public static void main(String[] args) throws IOException {

		CompareLyrics newCompare = new CompareLyrics();
		EmotionList emotionList = new EmotionList("emo1.csv");
		//String lyrics = "So I cross my heart and hope for you";
		
		/*
		 * This part is new: added by @Andrew Pai for testing purposes.
		 */
		
		
		Search search = new Search();
    	String lyrics = search.LyricsSearch("Look What You Made Me Do","Taylor Swift");

		
		newCompare.mostFrequentEmotions (lyrics, emotionList.emotionDataBase);
		//System.out.println(newCompare.countAnticipation);
		
		System.out.println("The emotion elicited from this song is " +"\"" + newCompare.emotionAnalysis(newCompare.eightEmotionCounts) + "\"!");
	}

}
