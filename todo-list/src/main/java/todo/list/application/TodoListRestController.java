package todo.list.application;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import todo.list.models.Todo;
import todo.list.services.TodoListService;
import todo.list.services.TodoValidator;

/**
 * Rest controller for the todolist.
 *
 */
@Path("/taskManagement/v1/todos")
@Produces(MediaType.APPLICATION_JSON)
public class TodoListRestController {

	private final TodoListService todoListService;

	public TodoListRestController(TodoListService todoListService) {
		this.todoListService = todoListService;
	}

	@GET
	public Response getTodos() {
		return Response.ok(todoListService.getTodoList()).build();
	}

	@GET
	@Path("/{id}")
	public Response getTodoById(@PathParam("id") String id) {
		Todo todo = todoListService.getTodoById(id);
		if (todo != null) {
			return Response.ok(todo).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	public Response createTodo(Todo todo) {
		// validation
		TodoValidator.validateCreateTodo(todo);

		Todo createdTodo = todoListService.createTodo(todo);
		if (createdTodo != null) {
			return Response.ok(createdTodo).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateTodoById(@PathParam("id") String id, Todo todo) {
		// validation
		TodoValidator.validateCreateTodo(todo);

		Todo updatedTodo = todoListService.putTodoById(id, todo);
		if (updatedTodo != null) {
			todo.setId(id);
			return Response.ok(todo).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTodoById(@PathParam("id") String id) {
		Todo todo = todoListService.getTodoById(id);
		if (todo != null) {
			todoListService.deleteTodoById(id);
			return Response.ok().build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}

}
