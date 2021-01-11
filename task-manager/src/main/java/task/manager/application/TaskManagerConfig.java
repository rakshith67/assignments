package task.manager.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import task.manager.application.TodoApiImplementation.ICreateTodoDelegate;
import task.manager.application.TodoApiImplementation.IDeleteTodoByIdDelegate;
import task.manager.application.TodoApiImplementation.IGetTodoByIdDelegate;
import task.manager.application.TodoApiImplementation.IGetTodoListDelegate;
import task.manager.application.TodoApiImplementation.IPutTodoByIdDelegate;
import task.manager.delegates.CreateTodoDelegate;
import task.manager.delegates.DeleteTodoByIdDelegate;
import task.manager.delegates.GetTodoByIdDelegate;
import task.manager.delegates.GetTodoListDelegate;
import task.manager.delegates.PutTodoByIdDelegate;
import task.manager.models.ErrorResponse;
import task.manager.models.Task;
import task.manager.models.Todo;

@Configuration
public class TaskManagerConfig {

	@Bean
	@Scope(value = "prototype")
	public Todo todo() {
		return new Todo();
	}

	@Bean
	@Scope(value = "prototype")
	public Task task() {
		return new Task();
	}

	@Bean
	@Scope(value = "prototype")
	public ErrorResponse errorResponse() {
		return new ErrorResponse();
	}

	@Bean
	public ICreateTodoDelegate createTodoDelegate() {
		return new CreateTodoDelegate();
	}

	@Bean
	public IGetTodoListDelegate getTodoListDelegate() {
		return new GetTodoListDelegate();
	}

	@Bean
	public IGetTodoByIdDelegate getTodoByIdDelegate() {
		return new GetTodoByIdDelegate();
	}

	@Bean
	public IPutTodoByIdDelegate putTodoByIdDelegate() {
		return new PutTodoByIdDelegate();
	}

	@Bean
	public IDeleteTodoByIdDelegate deleteTodoByIdDelegate() {
		return new DeleteTodoByIdDelegate();
	}
}
