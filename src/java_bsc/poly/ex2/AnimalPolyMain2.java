package java_bsc.poly.ex2;

public class AnimalPolyMain2 {

	public static void main(String args[]) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Caw caw = new Caw();
		Animal[] anminalArr = {dog, cat, caw};
		
		for (Animal arr : anminalArr) {
			System.out.println("동물 소리 테스트 시작");
			arr.sound();
			System.out.println("동물 소리 테스트 종료");
		}
	}
}
