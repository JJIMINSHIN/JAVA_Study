package java_bsc.ref;

public class Method2 {

	public static void main(String args[]) {
		Student student1 = createStudent("학생1", 15, 90); //48cf768c
		System.out.println("student1 = "+student1); //48cf768c

		Student student2 = createStudent("학생2", 16, 80); //8807e25
		System.out.println("student2 = "+student2); //8807e25

		printStudent(student1);
		printStudent(student2);
	}

	static Student createStudent(String name, int age, int grade) {
		Student student = new Student();
		System.out.println("student = "+student); 
		student.name = name;
		student.age = age;
		student.grade = grade;
		return student;
	}

	static void printStudent(Student student1) {
		System.out.println("이름:" + student1.name + " 나이:" + student1.age + " 성적:" + student1.grade);
	}
}
