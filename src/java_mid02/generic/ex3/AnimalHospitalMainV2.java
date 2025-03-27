package java_mid02.generic.ex3;

import java_mid02.generic.animal.Cat;
import java_mid02.generic.animal.Dog;

public class AnimalHospitalMainV2 {

	public static void main(String[] args) {
		AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
		AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();
		AnimalHospitalV2<Integer> integerHospital = new AnimalHospitalV2<>();
		AnimalHospitalV2<Object> objectHospital = new AnimalHospitalV2<>();
	}
}
