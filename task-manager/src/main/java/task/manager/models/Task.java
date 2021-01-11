package task.manager.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("name")
	private String name = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
