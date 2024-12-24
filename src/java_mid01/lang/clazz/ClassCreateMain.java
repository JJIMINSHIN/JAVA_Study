package java_mid01.lang.clazz;

public class ClassCreateMain {

	public static void main(String args[]) throws Exception {
		//클래스 조회
		//Class helloClass = Hello.class;
		Class helloClass = Class.forName("java_mid01.lang.clazz.Hello");
		
		//객체 생성
		Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
		String result = hello.hello();
		System.out.println("hello = " + hello);
		System.out.println("result = " + result);
	}
}
