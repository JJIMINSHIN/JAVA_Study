package java_mid02.generic.ex5;

import java_mid02.generic.animal.Animal;
import java_mid02.generic.animal.Cat;
import java_mid02.generic.animal.Dog;

public class WildcardMain2 {

	public static void main(String[] args) {
		Box<Object> objBox = new Box<>();
		Box<Animal> animalBox = new Box<>();
		Box<Dog> dogBox = new Box<>();
		Box<Cat> catBox = new Box<>();

		// ?가 Animal보다 위에 있어야함
		//Animal 포함 사우이 타입 전달 가능
		writeBox(objBox);
		writeBox(animalBox);
		
		// writeBox(dogBox); // 하한이 Animal
		// writeBox(catBox); // 하한이 Animal
		Animal animal = animalBox.get();
		System.out.println("animal = " + animal);
	}

	static void writeBox(Box<? super Animal> box) {
		box.set(new Dog("멍멍이", 100));
	}
}
