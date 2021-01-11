package web.scrapper.resources.models;

import java.util.ArrayList;
import java.util.List;

public class ScrapperInput {

	private List<Url> urls = new ArrayList<>();

	private Entity entity = null;

	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

}
