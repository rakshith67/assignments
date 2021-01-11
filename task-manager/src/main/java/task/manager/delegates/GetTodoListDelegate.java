package task.manager.delegates;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import task.manager.application.TodoApiImplementation.IGetTodoListDelegate;
import task.manager.models.Todo;

public class GetTodoListDelegate implements IGetTodoListDelegate {

	@Override
	public ResponseEntity<List<Todo>> getTodoList() {
		List<Todo> result = new ArrayList<>();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
