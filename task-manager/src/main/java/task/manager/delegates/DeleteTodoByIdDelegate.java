package task.manager.delegates;

import org.springframework.http.ResponseEntity;

import task.manager.application.TodoApiImplementation.IDeleteTodoByIdDelegate;
import task.manager.models.Todo;

public class DeleteTodoByIdDelegate implements IDeleteTodoByIdDelegate {

	@Override
	public ResponseEntity<Todo> deleteTodo(String todoId) {
		return null;
	}

}
