package java_mid01.exception.ex4.exception;

/*
 * 연결 실패시 발생하는 예외
 */
public class ConnectExceptionV4 extends NetworkClientExceptionV4{

	private final String address;

	public ConnectExceptionV4(String message, String address) {
		super(message);
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

}
