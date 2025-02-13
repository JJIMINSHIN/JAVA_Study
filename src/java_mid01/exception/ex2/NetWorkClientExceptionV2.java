package java_mid01.exception.ex2;

public class NetWorkClientExceptionV2 extends Exception {
	
	private String errorCode;
	
	public NetWorkClientExceptionV2(String errorCode, String message){
		super(message);
		this.errorCode = errorCode;
	}	
	
	public String getErrorCode() {
		return errorCode;
	}

}
