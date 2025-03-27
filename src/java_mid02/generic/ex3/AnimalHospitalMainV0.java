package java_mid02.generic.ex3;

import java_mid02.generic.animal.Cat;
import java_mid02.generic.animal.Dog;

public class AnimalHospitalMainV0 {

	public static void main(String args[]) {
		DogHospital dogHospital = new DogHospital();
		CatHospital catHospital = new CatHospital();
		
		Dog dog = new Dog("멍멍이1", 100);
		Cat cat = new Cat("냥냥이1", 300);
		
		//개 병원
		dogHospital.set(dog);
		dogHospital.checkup();
		
		//고양이 병원
		catHospital.set(cat);
		catHospital.checkup();
		
		/*
		 * 문제 1 컴파일 오류
		 * 	The method set(Dog) in the type DogHospital is not applicable for the arguments (Cat)
			dogHospital.set(cat);
		*/
		
		// 문제 2 : 개타입 변환
		dogHospital.set(dog);
		Dog bigDog = dogHospital.bigger(new Dog("멍멍이2",200));
		System.out.println("bigDog : "+bigDog);
	}
}
