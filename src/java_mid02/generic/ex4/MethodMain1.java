package java_mid02.generic.ex4;

public class MethodMain1 {
	
	public static void main(String args[]) {
		Integer i =10;
		Object obj = GenericMethod.objMethod(i); //obj print : 10

		// 타입 인자 명시적 전달
		System.out.println("명시적 타입 인자 전달");
		Integer result = GenericMethod.<Integer>genericMethod(i); //generic print : 10
		Integer integerValue = GenericMethod.<Integer>numberMethod(10); //bound print : 10
		Double doubleValue = GenericMethod.<Double>numberMethod(20.0); //bound print : 20.0
		
		//타입 추론, 타입 인자 생략 -> Integer로 반환타입 추론 가능함 -> 다이아몬드 제거 가능
		System.out.println("타입 추론");
		Integer result2 = GenericMethod.genericMethod(i);
		Integer integerValue2 = GenericMethod.numberMethod(10);
		Double doubleValue2 = GenericMethod.numberMethod(20.0);
		 
	}

}
