package java_bsc.class1;


public class ClassStart2 {

	public static void main(String args[]) {
		Student student1; //변수 선언 -> 학샘 담아둘 수 있는 공간 -> Student 안에는 이름, 나이, 성적 필드가 있다.
		
		student1 = new Student(); //학생을 실제 메모리에 만든다. x001
		
		//객체 값 대입
		student1.name = "학생1";
		student1.age = 15;
		student1.grade = 90;
		
		Student student2 = new Student(); // 새로운 학생 만들기 x002
		
		student2.name = "학생2";
		student2.age = 16;
		student2.grade = 80;
		
		//객체 값 사용
		System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
		System.out.println("이름:" + student2.name + " 나이:" + student2.age + " 성적:" + student2.grade);
	}

}
