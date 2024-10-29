package java_bsc.extends1.super2;

public class ClassC extends ClassB{
	
	public ClassC() {
		super(10,20); //B는 생성자 직접 생성했음으로 그냥 사용 x
		System.out.println("ClassC 생성자");
	}

}
