package todo.list.services;

import java.util.List;

import todo.list.models.CustomException;
import todo.list.models.Task;
import todo.list.models.Todo;

public class TodoValidator {

	private TodoValidator() {

	}

	public static void validateCreateTodo(Todo todo) {
		if (null == todo) {
			throw new CustomException(400, "Given todo is not valid");
		}
		if (isEmpty(todo.getName())) {
			throw new CustomException(400, "Given todo name is not valid");
		}
		List<Task> tasks = todo.getTasks();
		for (Task task : tasks) {
			if (isEmpty(task.getName())) {
				throw new CustomException(400, "Given task name is not valid");
			}
		}
	}

	private static boolean isEmpty(String string) {
		return null == string || string.isEmpty();
	}
}
