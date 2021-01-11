package todo.list.application;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import todo.list.models.CustomException;
import todo.list.models.ErrorResponse;

public class TodoListExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException exception) {
		ErrorResponse responseBody = new ErrorResponse();
		if (exception instanceof CustomException) {
			CustomException customException = (CustomException) exception;
			responseBody.setCode(String.valueOf(customException.getCode()));
			responseBody.setMessage(customException.getLocalizedMessage());
			return Response.status(Status.fromStatusCode(customException.getCode())).entity(responseBody).build();
		}
		responseBody.setCode("500");
		responseBody.setMessage(exception.getLocalizedMessage());
		return Response.status(500).entity(responseBody).build();
	}

}
