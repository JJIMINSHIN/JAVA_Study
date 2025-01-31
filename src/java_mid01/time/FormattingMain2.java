package java_mid01.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormattingMain2 {

	public static void main(String args[]) {
		//포맷팅 : 날짜, 시간을 문자로
		LocalDateTime now = LocalDateTime.of(2024, 12, 31, 13, 30, 59);
		DateTimeFormatter formmater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		String formattedDateTime = now.format(formmater);
		System.out.println("날짜, 시간 포맷팅 : "+formattedDateTime);
		
		// 파싱 :  문자 - > 날짜,시간으로
		String dateTimeString ="2030-01-01 11:30:00";
		LocalDateTime parsedDateTime = LocalDateTime.parse(dateTimeString, formmater);
		System.out.println("문자열 파싱 날짜와 시간: " +parsedDateTime);
		
		
		
	}
}
