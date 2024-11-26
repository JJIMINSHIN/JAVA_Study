package java_mid01.lang.nested.test;

/*
 * 문제2 - 내부 클래스 완성 
 * 이너클래스 생성하려면 바깥클래스의 인스턴스가 있어야 하기 때문에 
 * 바깥클래스인스턴스.new라고해야 생성 가능
 * */

public class OuterClass2Main {
	public static void main(String args[]) {
		OuterClass2 outer = new OuterClass2();
		OuterClass2.InnerClass inner = outer.new InnerClass();
		inner.hello();
	}
}
