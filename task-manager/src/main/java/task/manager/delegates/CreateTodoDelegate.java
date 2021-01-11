package task.manager.delegates;

import org.springframework.http.ResponseEntity;

import task.manager.application.TodoApiImplementation.ICreateTodoDelegate;
import task.manager.models.Todo;

public class CreateTodoDelegate implements ICreateTodoDelegate{

	@Override
	public ResponseEntity<Todo> createTodo(Todo todo) {
		return null;
	}

}
