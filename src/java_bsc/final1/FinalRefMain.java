package java_bsc.final1;

public class FinalRefMain {
	
	public static void main(String args[]) {
		final Data data = new Data(); // 지역변수 선언
		
		/*
		 *참조 대상의 값은 변경 가능 
		 public class Data {
			public int value;
		 }
		 * */
		data.value =10;
		System.out.println(data.value);
		data.value =20;
		System.out.println(data.value);
		
	}

}
