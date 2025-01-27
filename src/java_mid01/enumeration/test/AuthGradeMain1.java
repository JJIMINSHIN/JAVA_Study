package java_mid01.enumeration.test;

public class AuthGradeMain1 {

	public static void main(String args[]) {
		AuthGrade[] grades = AuthGrade.values();
		
		for(AuthGrade value :  grades) {
			System.out.println("grade= "+value.name()+", level= "+value.getLevel()+", 설명= "+ value.getDesc());
		}
	}
}
