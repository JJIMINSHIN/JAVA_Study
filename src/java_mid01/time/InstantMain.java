package java_mid01.time;

import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantMain {

	public static void main(String args[]) {

		// 생성
		Instant now = Instant.now(); // UTC 기준
		System.out.println("now = " + now); // 지금시간에서 -9뺀시간
		
		
		ZonedDateTime zdt = ZonedDateTime.now();
		Instant from = Instant.from(zdt);
		System.out.println("from = " + from);
		
		
		Instant epochStart = Instant.ofEpochSecond(0);
		System.out.println("epochStart = " + epochStart);
		
		Instant epochStart2 = Instant.ofEpochSecond(100);
		System.out.println("epochStart = " + epochStart2);
		
		// 1시간 후
		Instant later = epochStart.plusSeconds(3600);
		System.out.println("later = " + later);
		
		
		// 시간 계산(초로)
		long laterEpochSecond = later.getEpochSecond();
		System.out.println("laterEpochSecond = " + laterEpochSecond);
	}

}
