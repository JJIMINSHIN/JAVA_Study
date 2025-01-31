package java_mid01.time;

import java.time.LocalDate;

public class LocalDateMain {
	public static void main(String args[]) {
		LocalDate nowDate = LocalDate.now();
		LocalDate ofDate = LocalDate.of(2013, 11, 21);
		System.out.println("오늘 날짜 = " + nowDate);
		System.out.println("지정 날짜 = " + ofDate);
		
		// 계산(불변)
		ofDate.plusDays(10);
		System.out.println("지정 날짜+10d = " + ofDate);
		
		//변하려면  반환값 받아야함
		ofDate =  ofDate.plusDays(10);
		System.out.println("지정 날짜+10d = " + ofDate);
	}

}
