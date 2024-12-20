package java_bsc.poly.ex5;

public class Caw implements InterfaceAnimal {

	@Override
	public void sound() {
		System.out.println("음매");
	}

	@Override
	public void move() {
		System.out.println("송아지가 움직입니다.");
	}

}
