package java_mid01.lang.wrapper;

public class AutoboxingMain2 {
	
	public static void main(String args[]) {
		// Primitive(기본형) -> Wrapper(객체)
		int val = 7;
		Integer boxedVal = val;  // 오토 박싱(Auto-boxing)
		
		 // Wrapper(객체) -> Primitive(기본형)
		int unboxedVal = boxedVal; // 오토 언박싱(Auto-Unboxing)

		
		System.out.println("boxedValue = " + boxedVal);
		System.out.println("unboxedValue = " + unboxedVal);
	}

}
