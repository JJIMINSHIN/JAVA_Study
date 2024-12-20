package java_bsc.poly.ex4;

public class AbstractMain {

	public static void main(String args[]) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Caw caw = new Caw();
		
		soundAnimal(dog);
		moveAnmial(dog);
		System.out.println("===========");
		soundAnimal(cat);
		moveAnmial(cat);
		System.out.println("===========");
		soundAnimal(caw);
		moveAnmial(caw);
	}

	private static void moveAnmial(AbstractAnimal animal) {
		System.out.println("동물 이동 테스트 시작");
		animal.move();
		System.out.println("동물 이동 테스트 종료");
	}

	private static void soundAnimal(AbstractAnimal animal) {
		System.out.println("동물 소리 테스트 시작");
		animal.sound();
		System.out.println("동물 소리 테스트 종료");
	}

}
