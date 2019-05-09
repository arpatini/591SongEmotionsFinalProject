import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SongRecommenderTest {

	@Test
	void testCreateListOfSongsNotRecognized() {
		try {
			ArrayList<String> list = SongRecommender.createListOfSongs("");
			ArrayList<String> emptyList = new ArrayList<String>();
			assertArrayEquals(list.toArray(), emptyList.toArray());
			
		} catch (IOException e) {
			System.out.println("Mistake?");
		}
	}
	
	@Test
	void testCreateListOfSongsFromLookWhatYouMadeMeDo() {
		try {
			ArrayList<String> list = SongRecommender.createListOfSongs("Look What You Made Me Do");
			
			ArrayList<String> otherList = new ArrayList<String>();		
			otherList.add("Look What You Made Me Do by Taylor Swift");
			assertEquals(list.get(0), otherList.get(0));
			
		} catch (IOException e) {
			System.out.println("Mistake?");
		}
	}
	
	@Test
	void testCreateListOfSongsFromTeganAndSara() {
		try {
			ArrayList<String> list = SongRecommender.createListOfSongs("what about us?");
			
			ArrayList<String> otherList = new ArrayList<String>();		
			otherList.add("What About Us? by Pink");
			assertEquals(list.get(0), otherList.get(0));
			
		} catch (IOException e) {
			System.out.println("Mistake?");
		}
	}

}
