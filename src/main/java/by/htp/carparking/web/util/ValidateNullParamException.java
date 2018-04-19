package by.htp.carparking.web.util;

public class ValidateNullParamException extends RuntimeException{

	private static final long serialVersionUID = -4764440450610912427L;

	public ValidateNullParamException() {
		super();
	}

	public ValidateNullParamException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateNullParamException(String message) {
		super(message);
	}

	public ValidateNullParamException(Throwable cause) {
		super(cause);
	}
	
}
