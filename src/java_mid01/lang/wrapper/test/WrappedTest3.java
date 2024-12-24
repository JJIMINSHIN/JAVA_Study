package java_mid01.lang.wrapper.test;

public class WrappedTest3 {
	public static void main(String args[]) {
		String str ="100";
		
		//String -> Integer
		 Integer integer1 = Integer.valueOf(str);
		 System.out.println("integer1 = " + integer1);
		 
		 //Integer -> int : intValue
		 int intValue = integer1.intValue();
		 System.out.println("intValue = " + intValue);
		 
		 //int -> Integer : Integer.valueOf
		 Integer integer2 = Integer.valueOf(intValue);
		 System.out.println("integer2 = " + integer2);

	}
}
