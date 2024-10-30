package java_mid01.lang.string;

public class StringConcatMain {
	
	public static void main(String args[]) {
		String a = "hello"; //x001
		String b = " java"; //x002
		
		/*
		 * res1 = x001.concat(b);
		 * res2 = x001 + x002; => 참조값끼리는 더할 수 없다.
		 * => 자바에서 특별히 + 제공해줌
		 * */
		String res1 = a.concat(b);
		String res2 = a+b;
		
		System.out.println("res1 = "+res1);
		System.out.println("res2 = "+res2);
	
	}

}
