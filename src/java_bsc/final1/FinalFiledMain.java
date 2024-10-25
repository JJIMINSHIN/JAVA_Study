package java_bsc.final1;import java.io.File;

public class FinalFiledMain {
	
	public static void main(String args[]) {
		
		/*
		 * 생성자를 통해 한번만 값 변경 가능
		 public class ConstructInit {
			// 초기값 x -> 생성자로 값 할당 가능
			final int value;
			
			public ConstructInit(int value) {
				this.value = value;
			}
		}
		 * */
		System.out.println("생성자 초기화!");
		ConstructInit constructInit1 = new ConstructInit(10);
		ConstructInit constructInit2 = new ConstructInit(20);
		
		System.out.println(constructInit1.value);
		System.out.println(constructInit2.value);
		// 
		
		/*
		 * final 필드 - 필드 초기화
		 * public class FieldInit {
			static final int CONST_VALUE = 10;
			final int value =10;
		}
		 * */
		System.out.println("필드 초기화!");
		FieldInit fieldInit1 = new FieldInit();
		FieldInit fieldInit2 = new FieldInit();
		FieldInit fieldInit3 = new FieldInit();
		System.out.println(fieldInit1.value);
		System.out.println(fieldInit2.value);
		System.out.println(fieldInit3.value);
		
		//상수
		System.out.println("상수!");
		System.out.println(FieldInit.CONST_VALUE);
	}

}
