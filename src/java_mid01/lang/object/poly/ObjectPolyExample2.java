package java_mid01.lang.object.poly;

public class ObjectPolyExample2 {
	
	public static void main(String args[]) {
		Dog dog = new Dog();
		Car car = new Car();
		Object Obj = new Object();
		
		Object[] object = {dog, car, Obj};
		
		size(object);
			
	}
	private static void size(Object[] object) {
		System.out.println("전달된 객체의 수는 : "+object.length);
		
	}
	

}
