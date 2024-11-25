package java_adv01.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행결과
start value = 0
00:24:09.624 [     main] getValue : 0 
00:24:09.635 [     main] result : true 
result1 = 1
00:24:09.636 [     main] getValue : 1 
00:24:09.636 [     main] result : true 
result1 = 2
 * */
public class CasMainV2 {
	
	public static void main(String args[]) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		System.out.println("start value = "+ atomicInteger.get());
		
		// incrementAndGet 구현
		int resultValue1 = incrementAndGet(atomicInteger);
		System.out.println("result1 = "+resultValue1);
		
		int resultValue2= incrementAndGet(atomicInteger);
		System.out.println("result1 = "+resultValue2);
		
	}
	
	private static int incrementAndGet(AtomicInteger atomicInteger) {
		int getValue;
		boolean result;
		do {
			getValue = atomicInteger.get();
			log("getValue : "+getValue);
			result = atomicInteger.compareAndSet(getValue, getValue+1);
			log("result : "+result);
		}while(!result);
		return getValue+1;
		
	}
}
