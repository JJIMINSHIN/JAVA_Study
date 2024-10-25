package java_bsc.final1;

/*
 * final 값은 최초의 한번만 가능
 * 이후 변경 불가
 * */
public class FinalLocalMain {
	
	public static void main(String args[]) {
		//final 지역 변수 1
		final int data1;
		
		data1 = 10;
		//data1 = 20;
		
		//final 지역 변수 2
		final int data2 = 10;
		//data2 =20; //컴파일 오류

	}
	
	//final 매개변수
	static void method(final int parameter) {
		//parameter =20 ; 컴파일 오류 => 파라미터 값 변경 불가
	}

}
