package java_bsc.poly.basic;

//upcasting vs downcasting
public class CastingMain3 {

	public static void main(String args[]) {
		
		Parent parent1 = new Child();
		Child child1 = (Child) parent1; //다운캐스팅 
		child1.childMethod();
		
		Parent parent2 = new Parent();
		Child child2 = (Child) parent2;
		/*
		 * java.lang.ClassCastException
		 * 하위는 상위 부모의 모든 타입이 같이 생성되지만 상위는 하위타입이 생성되지 않아
		 * 참조할 수 없다.
		 */
		child1.childMethod();
		
	}

}
