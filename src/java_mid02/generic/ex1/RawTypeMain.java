package java_mid02.generic.ex1;

public class RawTypeMain {
	
	
	public static void main(String args[]) {

		// GenericBox<Object> integerBox = new GenericBox<Object>(); 권장!
		GenericBox integerBox = new GenericBox();
		
		integerBox.set(10);
		Integer res = (Integer) integerBox.get();
		System.out.println("res = "+res);
		
	}

}
