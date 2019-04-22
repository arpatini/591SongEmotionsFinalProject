import java.util.ArrayList;

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

    //compare each word from lyrics with the emotion database, the word is then correlated with the emotion associated with it. The occurrence of 8 emotions
	//are counted and later summarized to give a rating to the lyrics of the song
	public void mostFrequentEmotions(String lyrics, ArrayList <EmotionAndWords> emotionDataBase) {

		String [] parts = lyrics.split(",");


		for (int i = 0; i <= parts.length; i ++) {

			for (int j  = 0; j <= emotionDataBase.size(); j++) {
				
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

	}


	public static void main(String[] args) {
		
		CompareLyrics newCompare = new CompareLyrics();
		String lyrics = "So I cross my heart and hope for you";
		ArrayList <EmotionAndWords> emotionDataBase = null;
		newCompare.mostFrequentEmotions (lyrics, emotionDataBase);

	}

}
