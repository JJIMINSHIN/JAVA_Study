package java_mid01.lang.nested.test;

/*
 * 문제1 - 정적 중첩 클래스를 완성해라
 * */

public class OuterClass1 {
	static class NestedClass{
		public void hello() {
			System.out.println("NestedClass.hello");
		}
	}
}
