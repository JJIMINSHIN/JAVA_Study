package java_mid01.lang.nested.local;

import java.lang.reflect.Field;

/*
 * 실행 결과
value = 0
localVar = 111
paramVar = 2
outInstanceVar = 3
* 필드 확인
field = int java_mid01.lang.nested.local.LocalOuterV3$1LocalPrinter.value
field = private final int java_mid01.lang.nested.local.LocalOuterV3$1LocalPrinter.val$localVar
field = private final int java_mid01.lang.nested.local.LocalOuterV3$1LocalPrinter.val$paramVar
 * 바깥클래스 참조
field = final java_mid01.lang.nested.local.LocalOuterV3 java_mid01.lang.nested.local.LocalOuterV3$1LocalPrinter.this$0

 * */

public class LocalOuterV4 {

	private int outInstanceVar = 3;
	
	public Printer process(int paramVar) {
		
		// 지역변수는 스택 프레임이 종료되는 순간 함께 제거됨.
		int localVar =1;
		
		class LocalPrinter implements Printer {
			int value =0;
			
			@Override
			public void print() {
				System.out.println("value = "+value);
				// 인스턴스는 지역 변수보다 더 오래 살아남음
				System.out.println("localVar = "+localVar);
				System.out.println("paramVar = "+paramVar);
				
				System.out.println("outInstanceVar = "+outInstanceVar);
			}
		}//LocalPrinter

		Printer printer = new LocalPrinter();
		/*
		 * Local variable localVar defined in an enclosing scope must be final or effectively final
		 * 컴파일 오류 발생
		 * */
		//localVar =10;
		return printer;		
		//printer.print();  여기서 실행하지 않고 Printer 인스턴스만 반환

	}
	
	public static void main(String args[]) {
		LocalOuterV4 localOuter = new LocalOuterV4();
		Printer printer = localOuter.process(2);
		// process()의 스택 프레임이 사라진 이후에 실행
		printer.print();
	}
}
