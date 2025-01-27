package java_mid01.enumeration.test.http;

public enum HttpStatus {
	OK(200,"OK"),
	BAD_REQUEST(400, "Bad Request"),
	NOT_FOUND(404, "Not Found"),
	INTERNAL_SERVER_ERROR(500,"Internal Server Error");

	private final int code;
	private final String message;
	
	private HttpStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static HttpStatus findByCode(int code) {
		for(HttpStatus status : values()) {// values : 모든 ENUM 상수를 포함하는 배열을 반환한다.
			if(status.getCode() ==code) {
				return status;
			}
		}
		return null;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	 }

	public boolean isSuccess() {
		return code >= 200 && code <= 299;
	}

}
