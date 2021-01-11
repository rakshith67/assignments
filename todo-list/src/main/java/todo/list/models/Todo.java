package todo.list.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("tasks")
	private List<Task> tasks = new ArrayList<>();
	
	private String customParam = null;

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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getClassName() {
		return "Todo";
	}

	public String getCustomParam() {
		return customParam;
	}

	public void setCustomParam(String customParam) {
		this.customParam = customParam;
	}

}
