package java_mid01.lang.string.test;

public class TestString4 {
	
	public static void main(String args[]) {
		String str = "hello.txt";
		int len = str.indexOf(".txt");
		String fileName = str.substring(0,len);
		String extName = str.substring(len);
		
		System.out.println("fileName = "+fileName);
		System.out.println("extName = "+extName);
		
	}

}
