import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

class SearchTest {

	/**
	 * @author Andrew Pai
	 * @throws IOException
	 */
	@Test
	void removeLyricClutterTest() throws IOException {
		Search s = new Search();
		s.removeLyricClutter("https://www.azlyrics.com/lyrics/taylorswift/lookwhatyoumademedo.html");
		String test = "I don't like your little games Don't like your tilted stage The role you made me play Of the fool, no, I don't like you I don't like your perfect crime How you laugh when you lie You said the gun was mine Isn't cool, no, I don't like you (Oh!) But I got smarter, I got harder in the nick of time Honey, I rose up from the dead, I do it all the time I've got a list of names and yours is in red, underlined I check it once, then I check it twice, oh! Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me do I don't like your kingdom keys They once belonged to me You asked me for a place to sleep Locked me out and threw a feast (What?) The world moves on, another day, another drama, drama But not for me, not for me, all I think about is karma And then the world moves on, but one thing's for sure Maybe I got mine, but you'll all get yours But I got smarter, I got harder in the nick of time Honey, I rose up from the dead, I do it all the time I've got a list of names and yours is in red, underlined I check it once, then I check it twice, oh! Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me do I don't trust nobody and nobody trusts me I'll be the actress starring in your bad dreams I don't trust nobody and nobody trusts me I'll be the actress starring in your bad dreams I don't trust nobody and nobody trusts me I'll be the actress starring in your bad dreams I don't trust nobody and nobody trusts me I'll be the actress starring in your bad dreams (Ooh, look what you made me do) (Look what you made me do) (Look what you just made me do) \"I'm sorry, the old Taylor can't come to the phone right now.\" (Look what you just made me do) (Look what you made me do) (Look what you made me do) \"Why?\" (Look what you just made me do) \"Oh, 'cause she's dead!\" (Oh!) Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me do Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me Ooh, look what you made me do Look what you made me do Look what you just made me do Look what you just made me do";
		assertEquals(s.getLyrics(),test);
	}



}