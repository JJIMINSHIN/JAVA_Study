package java_bsc.poly.basic;

//upcasting vs downcasting
public class CastingMain5 {

	public static void main(String[] args) {
		
		Parent parent1 = new Parent();
		System.out.println("parent1 호출");
		call(parent1); // false, parent() > Child x, Child c = new Parent()
		
		Parent parent2 = new Child();
		System.out.println("parent2 호출");
		call(parent2); // true, parent() > Child o
		
	}

	private static void call(Parent parent) {
		parent.parentMethod();
		if (parent instanceof Child) {
			System.out.println("call Child 인스턴스 맞음");
			Child child = (Child) parent;
			child.childMethod();
		}
	}

}
