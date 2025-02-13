package java_mid01.exception.ex3.exception;

/*
 * 전송 실패시 발생하는 예외, 내부에 전송 시도한 데이터 보관
 */
public class SendExceptionV3 extends NetworkClientExceptionV3{
	
	private final String sendData;

	public SendExceptionV3(String message, String sendData) {
		super(message);
		this.sendData = sendData;
	}
	
	public String getSendData() {
		return sendData;
	}

}
