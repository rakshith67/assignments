package web.scrapper.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.scrapper.resources.models.Entity;
import web.scrapper.resources.models.ScrapperInput;
import web.scrapper.resources.models.ScrapperOutput;
import web.scrapper.resources.models.Url;

public class WebScrapperController {

	FilterUrlAndSelectors filterUrlAndSelector = new FilterUrlAndSelectors();

	GetHTMLDocumentByUrl getHTMLDocumentByURL = new GetHTMLDocumentByUrl();

	/**
	 * Extracts the scrapped data for each URL and maps into the output object and
	 * returns to the delegate.
	 * 
	 */
	public ScrapperOutput extractData(ScrapperInput input) {
		ScrapperOutput output = new ScrapperOutput();
		List<Map<String, Object>> list = new ArrayList<>();
		output.setData(list);
		List<Url> urls = input.getUrls();
		for (Url url : urls) {
			list.add(extract(input.getEntity(), url.getUrl().substring(1)));
		}
		return output;
	}

	private Map<String, Object> extract(Entity entity, String url) {
		return filterUrlAndSelector.getFilteredEntity(getHTMLDocumentByURL.getDocumentByURL(url), entity);
	}
}
