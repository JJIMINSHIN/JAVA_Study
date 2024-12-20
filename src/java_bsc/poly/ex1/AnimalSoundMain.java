package java_bsc.poly.ex1;

/*
 * 다영성 사용 x
 */
public class AnimalSoundMain {
	public static void main(String args[]) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Caw caw = new Caw();

		System.out.println("동물 소리 테스트 시작");
		dog.sound();
		System.out.println("동물 소리 테스트 종료");

		System.out.println("동물 소리 테스트 시작");
		cat.sound();
		System.out.println("동물 소리 테스트 종료");

		System.out.println("동물 소리 테스트 시작");
		caw.sound();
		System.out.println("동물 소리 테스트 종료");

	}

}
