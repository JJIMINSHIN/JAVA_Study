package java_mid01.lang.string.chaining;

public class MethodChainingMain3 {
	
	public static void main(String args[]) {
		ValueAdder  adder = new ValueAdder();
		
		/*
		 * adder.add(1) 
		 * x001.add(2)
		 * x001.add(3)
		 * */
		int res = adder.add(1).add(2).add(3).getValue();
		System.out.println("res = "+res);
		
	}

}
