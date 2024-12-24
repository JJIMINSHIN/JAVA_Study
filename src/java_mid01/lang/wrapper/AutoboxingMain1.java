package java_mid01.lang.wrapper;

public class AutoboxingMain1 {
	
	public static void main(String args[]) {
		// Primitive(기본형) -> Wrapper(객체)
		int val = 7;
		Integer boxedVal = Integer.valueOf(val);
		
		 // Wrapper(객체) -> Primitive(기본형)
		int unboxedVal = boxedVal.intValue();
		
		System.out.println("boxedValue = " + boxedVal);
		System.out.println("unboxedValue = " + unboxedVal);
	}

}
