package java_bsc.class1;

import java.util.Iterator;

public class ClassStart3 {

	public static void main(String args[]) {
		
		String[] studnetNames = {"학생1", "학생2"};
		int[] stuAges = {15, 16};
		int[] stGrades = {90, 80};
		
		for (int i = 0; i < stGrades.length; i++) {
			System.out.println("이름: "+studnetNames[i]+" 나이: "+stuAges[i]+" 성적: "+stGrades[i]);
		}
	}
	
}
