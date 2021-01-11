package task.manager.application;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import task.manager.models.Todo;

@Controller
@Scope(value = "prototype")
public class TodoApiImplementation implements TodosApi, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public interface ICreateTodoDelegate {
		ResponseEntity<Todo> createTodo(Todo todo);
	}

	public interface IGetTodoListDelegate {
		ResponseEntity<List<Todo>> getTodoList();
	}

	public interface IGetTodoByIdDelegate {
		ResponseEntity<Todo> getTodo(String todoId);
	}

	public interface IPutTodoByIdDelegate {
		ResponseEntity<Todo> putTodo(String todoId, Todo todo);
	}

	public interface IDeleteTodoByIdDelegate {
		ResponseEntity<Todo> deleteTodo(String todoId);
	}

	@Override
	public ResponseEntity<Todo> createTodo(Todo body) {
		TodoApiImplementation.ICreateTodoDelegate delegate = this.applicationContext
				.getBean(TodoApiImplementation.ICreateTodoDelegate.class);

		return delegate.createTodo(body);
	}

	@Override
	public ResponseEntity<List<Todo>> getTodo() {
		TodoApiImplementation.IGetTodoListDelegate delegate = this.applicationContext
				.getBean(TodoApiImplementation.IGetTodoListDelegate.class);

		return delegate.getTodoList();
	}

	@Override
	public ResponseEntity<Todo> getTodobyId(String id) {
		TodoApiImplementation.IGetTodoByIdDelegate delegate = this.applicationContext
				.getBean(TodoApiImplementation.IGetTodoByIdDelegate.class);

		return delegate.getTodo(id);
	}

	@Override
	public ResponseEntity<Todo> putTodoById(@Valid Todo body, String id) {
		TodoApiImplementation.IPutTodoByIdDelegate delegate = this.applicationContext
				.getBean(TodoApiImplementation.IPutTodoByIdDelegate.class);

		return delegate.putTodo(id, body);
	}

	@Override
	public ResponseEntity<Todo> deleteTodoById(String id) {
		TodoApiImplementation.IDeleteTodoByIdDelegate delegate = this.applicationContext
				.getBean(TodoApiImplementation.IDeleteTodoByIdDelegate.class);

		return delegate.deleteTodo(id);
	}

}
