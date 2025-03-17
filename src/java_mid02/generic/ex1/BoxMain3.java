package java_mid02.generic.ex1;

public class BoxMain3 {
	
	public static void main(String args[]) {
		
		// 생성 시점에 T의 타입 결정!
		GenericBox<Integer> integerBox = new GenericBox<Integer>();
		integerBox.set(10);
		Integer integer = (Integer) integerBox.get();
		System.out.println("integer = "+integer);
		
		GenericBox<String> stringBox = new GenericBox<String>();
		stringBox.set("hello");
		String str = (String) stringBox.get();
		System.out.println("str = "+str);
		
		//원하는 모든 타입 사용 가능
		GenericBox<Double> dbBox = new GenericBox<Double>();
		dbBox.set(10.5);
		Double dbValue = dbBox.get();
		System.out.println("doubleValue = "+dbValue);
		
		// 타입 추론 :  생성하는 제네릭 타입 생략 가능
		GenericBox<Integer> itBox2 = new GenericBox<>();
		
	}

}
