package java_mid02.generic.ex4;

import java_mid02.generic.animal.Cat;
import java_mid02.generic.animal.Dog;

public class MethodMain2 {
	
	public static void main(String args[]) {
	
		Dog dog = new Dog("멍멍이1", 100);
		Cat cat = new Cat("냥냥이1", 300);
		
		AnimalMethod.checkup(dog);
		AnimalMethod.checkup(cat);
		
		Dog targetDog = new Dog("큰 멍멍이", 200);
		Dog bigger = AnimalMethod.getBigger(dog, targetDog);
		System.out.println("bigger = "+ bigger);
	}

}
