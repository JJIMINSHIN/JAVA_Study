package java_mid01.lang.object.poly;

public class ObjectPolyExample1 {
	
	public static void main(String args[]) {
		Dog dog = new Dog();
		Car car = new Car();
		
		action(dog);
		action(car);
		
	}
	/*
	 * Object는 모든 객체의 부모이기 떄문에 메서드 사용 가능
	 * 
	 * */
	private static void action(Object obj) {
		/*
		 * 컴파일 오류 내기 -> Object에는 두 메서드가 없기때문에!
		 * obj.sound();
		 * obj.move();
		 * 객체에 맞는 다운캐스팅 필요
		*/
		
		if(obj instanceof Dog dog) {
			dog.sound();
		}else if(obj instanceof Car car){
			car.move();
		}
		
	}

}
