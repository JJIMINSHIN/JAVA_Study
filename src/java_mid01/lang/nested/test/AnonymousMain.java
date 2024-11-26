package java_mid01.lang.nested.test;

/*
 * 문제4 - 익명 클래스 완성 
 * 지역클래스 생성하고 바로 호출!
 * */
public class AnonymousMain {

	public static void main(String args[]) {
		
		Hello hello = new Hello() {
			@Override
			public void hello() {
				System.out.println("Hello.hello");
			}
		};
		hello.hello();
		
	}
}
