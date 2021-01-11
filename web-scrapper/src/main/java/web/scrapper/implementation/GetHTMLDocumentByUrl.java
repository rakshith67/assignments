package web.scrapper.implementation;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetHTMLDocumentByUrl {

	/**
	 * Gets the HTML page using the URL specified.
	 */
	public Document getDocumentByURL(String url) {
		Document document = null;
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
		}
		return document;
	}
}
