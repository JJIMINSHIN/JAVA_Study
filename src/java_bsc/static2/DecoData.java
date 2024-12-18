package java_bsc.static2;

public class DecoData {
	
	private int instanceValue;
	private static int staticValue;
	
	//정적 메서드로 static만 사용 가능
	public static void staticCall() {
		//Cannot make a static reference to the non-static field instanceValue
		//instanceValue++; //인스턴스 변수 접근, compile error 
		//instanceMethod(); //인스턴스 메서드 접근
		
		staticValue++; // 정적 변수 접근
		staticMethod(); //정적 메서드 접근
	}
	
	public void instanceCall() {
		instanceValue++;
		instanceMethod();
		
		staticValue++;
		staticMethod();
	}
	
	private void instanceMethod() {
		System.out.println("instanceValue= "+instanceValue);
	}
	
	private static void staticMethod() {
		System.out.println("staticValue= "+staticValue);
	}
}
