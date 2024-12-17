package java_bsc.access.a;

public class AccessInnerMain {
	
	public static void main(String args[]) {
		AccessData data = new AccessData();
		
		//public
		data.publicField =1;
		data.publicMethod();
		
		//default 같은 패키지접근 가능
		data.defaultField =2;
		data.defaultMethod();
		
		/*
		 * private 같은 클래스에서만
		 * 아예 호출 자체가 안됨
		 * data.privateField = 3;
		   data.privateMethod();
		 */
		
		data.innerAccess();

	}

}
