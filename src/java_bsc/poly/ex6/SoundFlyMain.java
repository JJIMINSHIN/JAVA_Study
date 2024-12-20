package java_bsc.poly.ex6;

public class SoundFlyMain {
	public static void main(String args[]) {
		Dog dog = new Dog(); //sound
		Bird bird = new Bird(); //sound, fly
		Chicken chicken = new Chicken(); //sound, fly

		soundAnimal(dog);
		
		System.out.println("==============");
		
		soundAnimal(bird);
		flyAnimal(bird);

		System.out.println("==============");
	
		soundAnimal(chicken);
		flyAnimal(chicken);
	}

	private static void soundAnimal(AbstractAnimal animal) {
		System.out.println("동물 소리 테스트 시작");
		animal.sound();
		System.out.println("동물 소리 테스트 종료");
	}

	private static void flyAnimal(Fly fly) {
		System.out.println("날기 테스트 시작");
		fly.fly();
		System.out.println("날기 테스트 종료");
	}

}
