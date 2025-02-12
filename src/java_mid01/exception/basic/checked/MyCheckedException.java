package java_mid01.exception.basic.checked;

/*
 * Exception을 상속받은 예외는 체크예외가 된다.( 체크예외 - 개발자가 발생한 예외를 명시적으로 처리)
 */
public class MyCheckedException extends Exception{
	
	public MyCheckedException(String message) {
		super(message);
	}

}
