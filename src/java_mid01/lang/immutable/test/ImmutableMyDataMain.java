package java_mid01.lang.immutable.test;


public class ImmutableMyDataMain {

	public static void main(String args[]) {
		
		// date1 = x001 , date2 = x001
		ImmutableMyData date1 = new ImmutableMyData(2024, 1, 1);
		ImmutableMyData date2 = date1;
		
		System.out.println("date1 = "+date1);
		System.out.println("date2 = "+date2);
		
		System.out.println("2025 -> date1");
		//date1 = new ImmutableMyData(2025, 1, 10);
		date1 = date1.withYear(2025); //date1 = x002 , date2 = x001, 반환값 무조건 받아야함
		System.out.println("date1 = "+date1); //x002
		System.out.println("date2 = "+date2); //x001
	}
}
