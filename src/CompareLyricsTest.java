import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompareLyricsTest {

	@Test
	void testCountTrust() {
		CompareLyrics newCompare = new CompareLyrics();
		EmotionList el = new EmotionList("emo1.csv");
		String lyrics = "So stop time right here in the moonlight";
		newCompare.mostFrequentEmotions (lyrics, el.emotionDataBase);
		int countTrustTest = newCompare.countTrust;
		assertEquals(3, countTrustTest);
	}
	
	@Test
	void testCountJoy() {
		CompareLyrics newCompare = new CompareLyrics();
		EmotionList el = new EmotionList("emo1.csv");
		String lyrics = "So stop time right here in the moonlight";
		newCompare.mostFrequentEmotions (lyrics, el.emotionDataBase);
		int countJoyTest = newCompare.countJoy;
		assertEquals(4, countJoyTest);
	}
	
	
	@Test
	void testSizeOfEightEmotionCounts() {
		CompareLyrics newCompare = new CompareLyrics();
		EmotionList el = new EmotionList("emo1.csv");
		String lyrics = "So stop time right here in the moonlight";
		newCompare.mostFrequentEmotions (lyrics, el.emotionDataBase);
		assertEquals(8, newCompare.eightEmotionCounts.size());
	}
	
	@Test
	void testEmotion() {
		CompareLyrics newCompare = new CompareLyrics();
		EmotionList el = new EmotionList("emo1.csv");
		String lyrics = "So stop time right here in the moonlight";
		newCompare.mostFrequentEmotions (lyrics, el.emotionDataBase);
		String emotionTest = newCompare.emotionAnalysis(newCompare.eightEmotionCounts);
		assertEquals("joy", emotionTest);
	}
	
	
	@Test
	void test() {
		CompareLyrics newCompare = new CompareLyrics();
		EmotionList el = new EmotionList("emo1.csv");
		String lyrics = "So I cross my heart and hope for you";
		newCompare.mostFrequentEmotions (lyrics, el.emotionDataBase);
		String emotionTest = newCompare.emotionAnalysis(newCompare.eightEmotionCounts);
		assertEquals("trust", emotionTest);
	}
}
