package java_mid01.lang.nested.inner;

public class InnerOuterMain {

	public static void main(String args[]) {
		InnerOuter outer = new InnerOuter(); // x001
		// new InnerOuter.Inner(); 이런식으로 생성 불가 => 바깥 인스턴스를 알고 있어야 활용할 수 있다.
		InnerOuter.Inner inner  = outer.new Inner(); //x001.new
		inner.print();
		
		System.out.println("innerClass = "+inner.getClass());
		
	}
	
}
