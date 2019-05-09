import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * This test compares the expected size of the database with the database fed into EmotionList
 */

class EmotionListTest {
    
	ArrayList <EmotionAndWords> emotionDataBase = new ArrayList <>(); 
	
	@Test
	void testEmotionList() {
		EmotionList el = new EmotionList("emo1.csv");
		System.out.println(emotionDataBase.size());
		assertEquals(32389, el.emotionDataBase.size());
	}

}
