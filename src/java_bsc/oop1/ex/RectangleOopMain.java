package java_bsc.oop1.ex;

public class RectangleOopMain {
	
	public static void main(String args[]) {
		Rectangle recTangle = new Rectangle();
		
		recTangle.width = 5;
		recTangle.height = 8;
		
		int area = recTangle.calculateArea();
		System.out.println("넓이: " + area);
		
		int perimeter = recTangle.calculatePerimeter();
		System.out.println("둘레 길이: " + perimeter);
		
		boolean square = recTangle.isSquare();
		System.out.println("정사각형 여부: " + square);
	}

}
