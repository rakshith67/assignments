package todo.list.services;

import java.util.List;

import todo.list.models.Todo;
import todo.list.repository.TodoListRepository;

/**
 * Service layer for the todolist.
 *
 */
public class TodoListService {

	private TodoListRepository todoListRepository;

	public TodoListService(TodoListRepository todoListRepository) {
		this.todoListRepository = todoListRepository;
	}

	public Todo createTodo(Todo todo) {
		TodoListUtil.fillTodoWithGeneratedIds(todo);
		return todoListRepository.createTodo(todo);
	}

	public List<Todo> getTodoList() {
		return todoListRepository.getTodoList();
	}

	public Todo getTodoById(String id) {
		return todoListRepository.getTodoById(id);
	}

	public void deleteTodoById(String id) {
		todoListRepository.deleteTodoById(id);
	}

	public Todo putTodoById(String id, Todo todo) {
		TodoListUtil.fillTodoWithGeneratedIds(todo);
		return todoListRepository.putTodoById(id, todo);
	}

}
