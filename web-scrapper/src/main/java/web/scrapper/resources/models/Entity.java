package web.scrapper.resources.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entity {

	private String entity;

	@JsonProperty("entity_type")
	private String entityType;

	private String selector;

	@JsonProperty("entity_scrapers")
	private List<Entity> entityScrapers = new ArrayList<>();

	@JsonProperty("Is_multiple")
	private boolean isMultiple;

	private String config;

	private Object value;

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public List<Entity> getEntityScrapers() {
		return entityScrapers;
	}

	public void setEntityScrapers(List<Entity> entityScrapers) {
		this.entityScrapers = entityScrapers;
	}

	public boolean isMultiple() {
		return isMultiple;
	}

	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
