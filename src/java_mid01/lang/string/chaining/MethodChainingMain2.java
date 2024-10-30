package java_mid01.lang.string.chaining;

public class MethodChainingMain2 {
	
	public static void main(String args[]) {
		ValueAdder  adder = new ValueAdder();
		ValueAdder adder1 = adder.add(1);
		ValueAdder adder2 = adder.add(2);
		ValueAdder adder3 = adder.add(3);
		
		int res = adder3.getValue();
		System.out.println("res = "+res);
		
		/*
		 * 참조값 동일
		 * chaining.ValueAdder@567d299b
		 * */
		System.out.println("--------------------");
		System.out.println("res = "+adder);
		System.out.println("res = "+adder1);
		System.out.println("res = "+adder2);
		System.out.println("res = "+adder3);
		System.out.println("--------------------");
		
		System.out.println("--------------------");
		System.out.println("res = "+adder.getValue());
		System.out.println("res = "+adder1.getValue());
		System.out.println("res = "+adder2.getValue());
		System.out.println("res = "+adder3.getValue());
		System.out.println("--------------------");
		
	}

}
