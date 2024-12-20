package java_bsc.poly.ex2;

public class AnimalPolyMain3 {

	public static void main(String args[]) {
		Animal[] anminalArr = {new Dog(), new Cat(), new Caw()};
		
		for (Animal arr : anminalArr) {
			soundAnimal(arr);
		}
	}
	
	//변하지 않는 부분
	private static void soundAnimal(Animal animal) {
		System.out.println("동물 소리 테스트 시작3");
		animal.sound();
		System.out.println("동물 소리 테스트 종료3");
	}
}
