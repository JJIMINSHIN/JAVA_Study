package java_mid01.exception.basic.checked;

/*
 * catch -> 예외를 잡는다
 * throws -> 예외를 던진다.
 */
public class Client {

	public void call() throws MyCheckedException{
		throw new MyCheckedException("ex");
	}
}
