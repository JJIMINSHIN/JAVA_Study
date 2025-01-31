package java_mid01.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingMain1 {

	public static void main(String args[]) {
		//포맷팅
		LocalDate date = LocalDate.of(2024, 12, 31);
		System.out.println(date); //2024-12-31 : iso 표준 출력, 데이트 포맷
		DateTimeFormatter formmater = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		
		String formattedDate = date.format(formmater);
		System.out.println("날짜, 시간 포맷팅 : "+formattedDate);
		
		// 파싱 :  문자 - > 날짜
		String input ="2024년 01월 01일";
		LocalDate parsedDate = LocalDate.parse(input, formmater); 
		System.out.println("문자열 파싱 날짜와 시간: " +parsedDate ); //문자 -> 날짜
		
		
		
	}
}
