Todo Manager Application:

	-> This application enables users to manage their todo lists amd tasks.

API's exposed:

1) Create Todo (/taskManagement/v1/todos, Method:POST, BODY:{todo})

	-> Used to create a todo
	
	-> Mandatory parameters are todo name and all the given tasks name.
	
	-> The tasks should not be empty for a given todo.
	
2) Get All Todos (/taskManagement/v1/todos, Method:GET)

	-> used to retrieve all the todos.
	
	-> If no todo exists it returns empty list.
	
3) Get Todo by Id(/taskManagement/v1/todos/{todoId}, Method:GET)

	-> Used to retrieve the todo based on id.
	
	-> Throws 404 if not found.
	
4) Put Todo by Id(/taskManagement/v1/todos/{todoId}, Method:PUT, BODY:{todo})

	-> Used to update the existing todo
	
	-> validations as per create todo itself
	
	-> Returns the updated todo in the database
	
5) Delete Todo by Id(/taskManagement/v1/todos/{todoId}, Method:DELETE)

	-> Used to delete the todo based on id
	
	-> Throws 404 if the todo with given id not found.
	
Layering Structure:

	This application contains three main components/layers:
	
		1) REST/Controller layer: RESTController to handle the incoming requests and then calls service layer
		
		2) Service layer: Business logic if any and calls the repository layer
		
		3) Repository layer: This layer handles only the connections and transactions with the database.
		

