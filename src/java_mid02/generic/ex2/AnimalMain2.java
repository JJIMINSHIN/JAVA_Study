package java_mid02.generic.ex2;

import java_mid02.generic.animal.Animal;
import java_mid02.generic.animal.Dog;
import java_mid02.generic.animal.Cat;

public class AnimalMain2 {

	public static void main(String args[]) {
		
		Animal animal = new Animal("동물", 0);
		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냥냥", 50);
		
		Box<Animal> animalBox = new Box<>();
		animalBox.set(animal);
		animalBox.set(dog);
		animalBox.set(cat);
		
		Animal findAnimal = animalBox.get();
		System.out.println("findAnimal = "+findAnimal);
	}
	
}
