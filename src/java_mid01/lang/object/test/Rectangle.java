package java_mid01.lang.object.test;

import java.util.Objects;

/*
 * toString() Override
 * 		Alt + Shift + S -> Press S
 * IDE로 equals 만들기 단축키
 * 		Alt + Shift + S -> Generate hashCode() and equals()
 * */

public class Rectangle {
	
	private int width;
	private int height;



	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return height == other.height && width == other.width;
	}




	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public static void main(String args[]) {
		Rectangle rect1 = new Rectangle(100, 20);
		Rectangle rect2 = new Rectangle(100, 20);

		System.out.println(rect1);
		System.out.println(rect2);
		System.out.println(rect1 == rect2);
		System.out.println(rect1.equals(rect2));
	}
}
