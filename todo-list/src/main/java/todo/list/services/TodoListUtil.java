package todo.list.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import todo.list.models.Task;
import todo.list.models.Todo;

public class TodoListUtil {

	private TodoListUtil() {
	}

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(TodoListUtil.class);

	public static Todo createTodo(String id) {
		Todo todo = new Todo();
		todo.setId(id);
		todo.setName("todo");
		todo.setDescription("current");
		List<Task> list = new ArrayList<>();
		list.add(createTask(id));
		todo.setTasks(list);
		return todo;
	}

	private static Task createTask(String id) {
		Task task = new Task();
		task.setId(id);
		task.setName("task");
		task.setDescription("current");
		return task;
	}

	public static void fillTodoWithGeneratedIds(Todo todo) {
		List<Task> taskList = todo.getTasks();
		for (Task task : taskList) {
			if (task.getId() == null || task.getId().isEmpty()) {
				UUID uuidTask = UUID.randomUUID();
				task.setId(uuidTask.toString());
			}
		}
	}

	public static Todo deserializeTodo(String todo) {
		Todo current = null;
		try {
			current = mapper.readValue(todo, Todo.class);
		} catch (IOException e) {
			LOGGER.error("Failed deserializing todo because of {}", e.getLocalizedMessage());
		}
		return current;
	}

	public static String serializeTodo(Todo todo) {
		String current = null;
		try {
			current = mapper.writeValueAsString(todo);
		} catch (IOException e) {
			LOGGER.error("Failed serializing todo because of {}", e.getLocalizedMessage());
		}
		return current;
	}
}
