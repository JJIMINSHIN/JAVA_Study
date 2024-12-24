package java_mid01.lang.wrapper.test;

public class WrappedTest2 {
	public static void main(String args[]) {
		String array[] = {"1.5", "2.5", "3.0"};
		
		double x = 0L;
		for(String s : array) {
			x += Double.parseDouble(s);
		}
		
		System.out.println("sum = "+x);
	}
}
