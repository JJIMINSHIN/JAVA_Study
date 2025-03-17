package java_mid02.generic.ex2;

import java_mid02.generic.animal.Animal;
import java_mid02.generic.animal.Dog;
import java_mid02.generic.animal.Cat;

public class AnimalMain1 {

	public static void main(String args[]) {
		
		Animal animal = new Animal("동물", 0);
		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냥냥", 50);
		
		Box<Dog> dogBox = new Box<>();
		dogBox.set(dog);
		Dog findDog = dogBox.get();
		System.out.println("findDog = "+findDog);
		
		Box<Cat> catBox = new Box<>();
		catBox.set(cat);
		Cat findCat = catBox.get();
		System.out.println("findCat = "+findCat);
		
		Box<Animal> animalBox = new Box<>();
		animalBox.set(cat);
		Animal findAnimal = animalBox.get();
		System.out.println("findAnimal = "+findAnimal);
		
	}
	
}
