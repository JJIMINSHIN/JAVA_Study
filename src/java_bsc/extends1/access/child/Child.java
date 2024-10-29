package java_bsc.extends1.access.child;

import java_bsc.extends1.access.parent.Parent;

public class Child extends Parent{
	
	public void call() {
		publicValue = 1;
		protectedValue = 1; //상속 관계 or 같은 패키지 => 현재는 다른 패키지, 상속 관계
		//defaultValue =1; // 다른 패키지 접근 불가, 컴파일 오류
		//privateValue = 1 // 접근 불가, 컴파일 오류
		
		publicMethod();
		protectedMethod();
		//defaultMethod();
		//privateMethod();
		
		printParent(); // public 이니깐
		
	}

}
