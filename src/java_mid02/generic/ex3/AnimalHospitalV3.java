package java_mid02.generic.ex3;

import java_mid02.generic.animal.Animal;

/*
 * 타입 인자로 들어 올 수 있는 값을 Animal과 그 자식으로 제한시킴
 * 자바 컴파일러는 T에 입력될 수 있는 값의 범위를 예측할 수 있음
 * -> Animal의 기능을 사용할 수 있다.
 */
public class AnimalHospitalV3<T extends Animal> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public void checkup() {
		System.out.println("동물 이름: " + animal.getName());
		System.out.println("동물 크기: " + animal.getSize());
		animal.sound();
	}

	public T bigger(T target) {
		return animal.getSize() > target.getSize() ? animal : target;
	}

}
