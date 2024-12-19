package java_bsc.poly.basic;

//upcasting vs downcasting
public class CastingMain6 {

	public static void main(String[] args) {
		
		Parent parent1 = new Parent();
		System.out.println("parent1 호출");
		call(parent1);
		
		System.out.println();
		
		Parent parent2 = new Child();
		System.out.println("parent2 호출");
		call(parent2);
	}

	private static void call(Parent parent) {
		parent.parentMethod();
		if (parent instanceof Child child) {
			System.out.println("call Child 인스턴스 맞음");
			 //Child child = (Child) parent; child.childMethod();
			child.childMethod();
		}
	}

}
