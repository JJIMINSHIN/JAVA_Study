package java_adv01.util;

import static java_adv01.util.MyLogger.log;

public abstract class ThreadUtils {
	
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			log("인터럽트 발생, "+e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
