package java_mid01.lang.string.test;

public class TestString10 {

	public static void main(String args[]) {
		String fruits = "apple,banana,mango";
		String[] sp  = fruits.split(",");
		for(String s : sp) {
			System.out.println(s);
		}
		String jo = String.join("->", sp);
		System.out.println(jo);
		
	}

}
