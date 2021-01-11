package todo.list.repository;

import static com.couchbase.client.java.query.Select.select;
import static com.couchbase.client.java.query.dsl.Expression.i;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.couchbase.client.core.env.QueryServiceConfig;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.query.Statement;

import todo.list.models.CustomException;
import todo.list.models.Todo;
import todo.list.services.TodoListUtil;

/**
 * Repository layer for the todolist, Connects to the database.
 *
 */
public class TodoListRepository {

	private static TodoListRepository todoListRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(TodoListRepository.class);

	private Cluster cluster;

	private Bucket bucket;

	public TodoListRepository() {
		try {
			CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
					.queryServiceConfig(QueryServiceConfig.create(0, 12, 10)).connectTimeout(10000).kvTimeout(3000)
					.build();
			cluster = CouchbaseCluster.create(env, "localhost");
			cluster.authenticate("Administrator", "Administrator");
			bucket = cluster.openBucket("todo");
		} catch (Exception e) {
			LOGGER.error("Failed connecting to couchbase because of {}", e.getLocalizedMessage());
		}
	}

	@PreDestroy
	public void destroyCouchbaseConnection() {
		LOGGER.info("Invoked PreDestroy");
		bucket.close();
		cluster.disconnect();
	}

	public static TodoListRepository getInstance() {
		if (todoListRepository == null) {
			todoListRepository = new TodoListRepository();
		}
		return todoListRepository;
	}

	private String getNextUid(String className) {
		String counterName = className + "Counter";
		validateBucket();
		JsonLongDocument val = bucket.counter(counterName, 1, 1);
		String keyPrefix = className;
		return keyPrefix + val.content().longValue();
	}

	public Todo createTodo(Todo entity) {
		validateBucket();
		String key = getNextUid(entity.getClassName());
		entity.setId(key);
		String jsonString = TodoListUtil.serializeTodo(entity);
		JsonDocument jsonDocument = JsonDocument.create(entity.getId(), JsonObject.fromJson(jsonString));
		JsonDocument createdJsonDocument = bucket.insert(jsonDocument);
		JsonObject replacedTodo = createdJsonDocument.content();
		return TodoListUtil.deserializeTodo(replacedTodo.toString());
	}

	public List<Todo> getTodoList() {
		validateBucket();
		List<Todo> todoList = new ArrayList<>();

		Statement statement = select("*").from(i("todo"));
		N1qlQuery query = N1qlQuery.simple(statement);
		N1qlQueryResult queryResult = bucket.query(query);

		List<JsonObject> jsonObjectList = new ArrayList<>();
		List<N1qlQueryRow> rows = queryResult.allRows();
		if (!rows.isEmpty()) {
			rows.remove(rows.size() - 1);
			for (N1qlQueryRow row : rows) {
				jsonObjectList.add((JsonObject) row.value().get("todo"));
			}

			for (JsonObject jsonObject : jsonObjectList) {
				Todo todo = TodoListUtil.deserializeTodo(jsonObject.toString());
				todoList.add(todo);
			}
		}
		return todoList;
	}

	public Todo getTodoById(String id) {
		validateBucket();
		JsonDocument document = bucket.get(id);
		if (document == null) {
			throw new CustomException(404, "No todo exists with the given id " + id);
		}
		JsonObject todo = document.content();
		return TodoListUtil.deserializeTodo(todo.toString());
	}

	public void deleteTodoById(String id) {
		validateBucket();
		getTodoById(id);
		bucket.remove(id);
	}

	//update `todo` set name=""
	public Todo putTodoById(String id, Todo todo) {
		validateBucket();
		getTodoById(id);
		
		todo.setId(id);
		String jsonString = TodoListUtil.serializeTodo(todo);
		JsonDocument jsonDocument = JsonDocument.create(todo.getId(), JsonObject.fromJson(jsonString));
		JsonDocument replacedJsonDocument = bucket.replace(jsonDocument);
		JsonObject replacedTodo = replacedJsonDocument.content();
		return TodoListUtil.deserializeTodo(replacedTodo.toString());
	}

	private void validateBucket() {
		if (bucket == null) {
			throw new CustomException(500, "Connection with couchbase not found");
		}
	}
}
