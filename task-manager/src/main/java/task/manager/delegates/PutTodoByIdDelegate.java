package task.manager.delegates;

import org.springframework.http.ResponseEntity;

import task.manager.application.TodoApiImplementation.IPutTodoByIdDelegate;
import task.manager.models.Todo;

public class PutTodoByIdDelegate implements IPutTodoByIdDelegate {

	@Override
	public ResponseEntity<Todo> putTodo(String todoId, Todo todo) {
		return null;
	}

}
