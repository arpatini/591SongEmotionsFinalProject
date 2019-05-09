import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainFrameTest {

	@Test
	void testButtonNothingTyped() {
		MainFrame mf = new MainFrame("Song Emotion Scale");
		mf.button.doClick();
		assertEquals(mf.sadResults.getText(), "We don't recognize that song, please try again.");	
	}
	
	@Test
	void testButtonOnlySongTyped() {
		MainFrame mf = new MainFrame("Song Emotion Scale");
		mf.songTextBox.setText("Where Does The Good Go");
		mf.button.doClick();
		assertEquals(mf.sadResults.getText(), "We don't recognize that song, please try again.");	
	}
	
	@Test
	void testButtonOnlyArtistTyped() {
		MainFrame mf = new MainFrame("Song Emotion Scale");
		mf.artistTextBox.setText("Tegan and Sara");
		mf.button.doClick();
		assertEquals(mf.sadResults.getText(), "We don't recognize that song, please try again.");	
	}
	

}
