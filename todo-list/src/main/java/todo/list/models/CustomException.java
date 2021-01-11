package todo.list.models;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final int code;

	private final String message;

	public CustomException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}


}
