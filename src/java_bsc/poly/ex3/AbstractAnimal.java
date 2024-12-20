package java_bsc.poly.ex3;

public abstract class AbstractAnimal {
	//자식이 오버라이딩 해야함
	public abstract void sound();

	//자식이 기능을 상속받아 사용해야함
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}
