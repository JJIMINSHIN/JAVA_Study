package java_bsc.access.b;

import java_bsc.access.a.AccessData;


public class AccessOuterMain {

	public static void main(String args[]) {
		AccessData data = new AccessData();
		
		//public
		data.publicField =1;
		data.publicMethod();

		/*
		 * default 같은 패키지접근 가능
		 * 	The field AccessData.defaultField is not visible
			data.defaultField =2;
			data.defaultMethod();
		 * private도 당연히 안됨
		 * data.privateField = 3;
		   data.privateMethod();
		 */
		data.innerAccess();
	}
}
