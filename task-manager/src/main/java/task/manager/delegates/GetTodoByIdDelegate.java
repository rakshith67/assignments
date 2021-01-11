package task.manager.delegates;

import org.springframework.http.ResponseEntity;

import task.manager.application.TodoApiImplementation.IGetTodoByIdDelegate;
import task.manager.models.Todo;

public class GetTodoByIdDelegate implements IGetTodoByIdDelegate {

	@Override
	public ResponseEntity<Todo> getTodo(String todoId) {
		return null;
	}

}
