import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainFrameTest {

	@Test
	void testButtonNothingTyped() {
		MainFrame mf = new MainFrame("Song Sadness Scale");
		mf.button.doClick();
		System.out.println(mf.sadResults.getText());
		assertEquals(mf.sadResults.getText(), "Please type an actual song.");	
	}
	
	@Test
	void testButtonSongTyped() {
		MainFrame mf = new MainFrame("Song Sadness Scale");
		mf.songTextBox.setText("Where Does The Good Go");
		mf.button.doClick();
		System.out.println(mf.sadResults.getText());
		assertEquals(mf.sadResults.getText(), "Where Does The Good Go by  is this level of sad..");	
	}
	
	@Test
	void testButtonArtistTyped() {
		MainFrame mf = new MainFrame("Song Sadness Scale");
		mf.artistTextBox.setText("Tegan and Sara");
		mf.button.doClick();
		System.out.println(mf.sadResults.getText());
		assertEquals(mf.sadResults.getText(), " by Tegan and Sara is this level of sad..");	
	}
	
	@Test
	void testButtonBothTyped() {
		MainFrame mf = new MainFrame("Song Sadness Scale");
		mf.songTextBox.setText("Where Does The Good Go");
		mf.artistTextBox.setText("Tegan and Sara");
		mf.button.doClick();
		System.out.println(mf.sadResults.getText());
		assertEquals(mf.sadResults.getText(), "Where Does The Good Go by Tegan and Sara is this level of sad..");	
	}

}
