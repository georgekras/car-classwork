package by.htp.carparking.web.util;

public final class HttpRequestParamValidator {
	
	private HttpRequestParamValidator() {
		
	}
	
	public static void validateRequestParamNotNull(String ... str) {
		for(String s: str) {
			if (s == null) {
				throw new ValidateNullParamException("Empty parametr recieved");
			}
		}
	}

}
