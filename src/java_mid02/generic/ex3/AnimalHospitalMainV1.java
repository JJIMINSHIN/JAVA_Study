package java_mid02.generic.ex3;

import java_mid02.generic.animal.Cat;
import java_mid02.generic.animal.Dog;

public class AnimalHospitalMainV1 {

	public static void main(String args[]) {
		AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
		AnimalHospitalV1 catHospital = new AnimalHospitalV1();
		
		Dog dog = new Dog("멍멍이1", 100);
		Cat cat = new Cat("냥냥이1", 300);
		
		//개 병원
		dogHospital.set(dog);
		dogHospital.checkup();
		
		//고양이 병원
		catHospital.set(cat);
		catHospital.checkup();
		
		// 문제 1 : 컴파일 오류 X  -> 오류가 발생하지 앟음 매개변수 체케 실패 
		dogHospital.set(cat);

		
		// 문제 2 : 개타입 변환 -> 캐스팅 필여
		dogHospital.set(dog);
		Dog bigDog = (Dog) dogHospital.bigger(new Dog("멍멍이2",200));
		System.out.println("bigDog : "+bigDog);
	}
}
