package java_mid01.enumeration.ex2;

public class ClassRefMain {
	public static void main(String args[]) {
		
		System.out.println("class BASIC = "+ClassGrade.BASIC.getClass());
		System.out.println("class GOLD = "+ClassGrade.GOLD.getClass());
		System.out.println("class DIAMOND = "+ClassGrade.DIAMOND.getClass());
		
		System.out.println("---------------------------------------------------------------");
		
		System.out.println("ref BASIC = "+ ClassGrade.BASIC); //x001
		System.out.println("ref GOLD = "+ ClassGrade.GOLD); //x002
		System.out.println("ref DIAMOND = "+ ClassGrade.DIAMOND); //x003
	}
}
