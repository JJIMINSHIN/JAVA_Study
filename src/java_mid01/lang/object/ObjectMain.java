package java_mid01.lang.object;

public class ObjectMain {
	public static void main(String args[]) {
		Child ch = new Child();
		ch.childMethod();
		ch.parentMethod();
		
		/*
		 * toString()은 Object 클래스의 메서드	
		 * toString() : 객체에 대한 정보 제공
		 * */
		String str = ch.toString();
		System.out.println(str);
	}

}
