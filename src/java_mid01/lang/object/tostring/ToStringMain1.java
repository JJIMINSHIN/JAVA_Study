package java_mid01.lang.object.tostring;

public class ToStringMain1 {
	public static void main(String args[]) {
		Object obj = new Object();
		String str = obj.toString();
		
		//toString() 반환값 출력
		System.out.println(str);
		
		//object 직접 출력
		System.out.println(obj);
	}

}
