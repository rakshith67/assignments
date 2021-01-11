package task.manager.application;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import task.manager.models.ErrorResponse;
import task.manager.models.Todo;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-05T13:27:19.009+05:30")

@Api(value = "todos", description = "the todos API")
public interface TodosApi {

	Logger log = LoggerFactory.getLogger(TodosApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "", nickname = "createTodo", notes = "This API will create a TODO in the database.", response = Todo.class, tags = {
			"taskManagement", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully removed users", response = Todo.class),
			@ApiResponse(code = 400, message = "Bad Request errors.", response = ErrorResponse.class),
			@ApiResponse(code = 405, message = "Invalid Method Type", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Errors", response = ErrorResponse.class),
			@ApiResponse(code = 502, message = "Bad gateway errors.", response = ErrorResponse.class) })
	@RequestMapping(value = "/todos", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<Todo> createTodo(
			@ApiParam(value = "Todo object that needs to be added to the store", required = true) @Valid @RequestBody Todo body) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]}",
							Todo.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default TodosApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "", nickname = "deleteTodoById", notes = "This API will delete a TODO in the database.", response = Todo.class, tags = {
			"taskManagement", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted todo", response = Todo.class),
			@ApiResponse(code = 400, message = "Bad Request errors.", response = ErrorResponse.class),
			@ApiResponse(code = 405, message = "Invalid Method Type", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Errors", response = ErrorResponse.class),
			@ApiResponse(code = 502, message = "Bad gateway errors.", response = ErrorResponse.class) })
	@RequestMapping(value = "/todos/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.DELETE)
	default ResponseEntity<Todo> deleteTodoById(
			@ApiParam(value = "Id of the todo", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]}",
							Todo.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default TodosApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "", nickname = "getTodo", notes = "This API will retrieve all the existing todo's in the database.", response = Todo.class, responseContainer = "List", tags = {
			"taskManagement", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully removed users", response = Todo.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request errors.", response = ErrorResponse.class),
			@ApiResponse(code = 405, message = "Invalid Method Type", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Errors", response = ErrorResponse.class),
			@ApiResponse(code = 502, message = "Bad gateway errors.", response = ErrorResponse.class) })
	@RequestMapping(value = "/todos", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<List<Todo>> getTodo() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"[ {  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]}, {  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]} ]",
							List.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default TodosApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "", nickname = "getTodobyId", notes = "This API will get the TODO by id.", response = Todo.class, tags = {
			"taskManagement", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully got todo from id", response = Todo.class),
			@ApiResponse(code = 400, message = "Bad Request errors.", response = ErrorResponse.class),
			@ApiResponse(code = 405, message = "Invalid Method Type", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Errors", response = ErrorResponse.class),
			@ApiResponse(code = 502, message = "Bad gateway errors.", response = ErrorResponse.class) })
	@RequestMapping(value = "/todos/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<Todo> getTodobyId(
			@ApiParam(value = "Id of the todo", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]}",
							Todo.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default TodosApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@ApiOperation(value = "", nickname = "putTodoById", notes = "This API will put given TODO in the database.", response = Todo.class, tags = {
			"taskManagement", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully put todo", response = Todo.class),
			@ApiResponse(code = 400, message = "Bad Request errors.", response = ErrorResponse.class),
			@ApiResponse(code = 405, message = "Invalid Method Type", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal Server Errors", response = ErrorResponse.class),
			@ApiResponse(code = 502, message = "Bad gateway errors.", response = ErrorResponse.class) })
	@RequestMapping(value = "/todos/{id}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	default ResponseEntity<Todo> putTodoById(
			@ApiParam(value = "Todo object that needs to be put", required = true) @Valid @RequestBody Todo body,
			@ApiParam(value = "Id of the todo", required = true) @PathVariable("id") String id) {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
			if (getAcceptHeader().get().contains("application/json")) {
				try {
					return new ResponseEntity<>(getObjectMapper().get().readValue(
							"{  \"name\" : \"name\",  \"description\" : \"description\",  \"id\" : \"id\",  \"tasks\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"id\" : \"id\"  } ]}",
							Todo.class), HttpStatus.NOT_IMPLEMENTED);
				} catch (IOException e) {
					log.error("Couldn't serialize response for content type application/json", e);
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default TodosApi interface so no example is generated");
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

}
