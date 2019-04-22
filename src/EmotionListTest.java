import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmotionListTest {

	@Test
	void testInputEmotionList() {
		EmotionList el = new EmotionList();
		el.inputEmotionList("emotion.csv");
		assertEquals(14182, el.emotionDataBase.size());
	}

}
