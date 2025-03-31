package java_mid02.generic.ex4;

import java_mid02.generic.animal.Animal;

public class ComplexBox<T extends Animal> {

	private T animal;
	
	public void set(T animal) {
		this.animal = animal;
	}
	
	public <T> T printAndReturn(T t) {
		System.out.println("animal.className : "+ animal.getClass().getName());
		System.out.println("t.className"+ t.getClass().getName());
		return t;
	}
	
}
