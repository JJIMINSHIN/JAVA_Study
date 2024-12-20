package java_bsc.poly.ex2;

public class AnimalPolyMain1 {

	public static void main(String args[]) {
		/* 이렇게 담아도 되지만 부모타입은 자식을 받을 수있으니 Animal로 선언해줘도 된다
		 Dog dog = new Dog();
		 Cat cat = new Cat();
		 Caw caw = new Caw(); 
		 * */
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal caw = new Caw();
		
		soundAnimal(dog);
		soundAnimal(cat);
		soundAnimal(caw);
	}

	// 동물이 추가 되어도 변하지 않는 코드
	private static void soundAnimal(Animal animal) {
		System.out.println("동물 소리 테스트 시작");
		animal.sound();
		System.out.println("동물 소리 테스트 종료");
	}
}
