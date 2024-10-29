package java_bsc.extends1.super2;

public class ClassB extends ClassA{
	
	public ClassB(int a) {
		super(); // 매개변수가 없는 기본 생성자는 생성자 생략 가능
		//this(a,0); //super -> this로 변경해봄
		System.out.println("ClassB 생성자 a = "+a);
	}
	
	public ClassB(int a, int b) {
		super();
		System.out.println("ClassB 생성자 a = "+a+" 생성자 b = "+b);
	}

}
