package java_mid02.generic.ex4;

import java_mid02.generic.animal.Cat;
import java_mid02.generic.animal.Dog;

public class MethodMain3 {
	
	public static void main(String args[]) {
	
		Dog dog = new Dog("멍멍이1", 100);
		Cat cat = new Cat("냥냥이1", 50);
		
		ComplexBox<Dog> hospital = new ComplexBox<>();
		hospital.set(dog);
		
		Cat returnCat = hospital.printAndReturn(cat);
		System.out.println("returnCat = "+returnCat);
	}

}
