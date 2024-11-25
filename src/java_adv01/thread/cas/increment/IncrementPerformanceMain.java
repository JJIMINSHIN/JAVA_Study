package java_adv01.thread.cas.increment;

import static java_adv01.util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;

/*
 * BasicInteger: ms=7
 * VolatileInteger: ms=883
 * SyncInteger: ms=2877
 * MyAtomicInteger: ms=1107
 * */
public class IncrementPerformanceMain {

	public static final long COUNT = 100_000_000;

	public static void main(String args[]) throws InterruptedException {
		test(new BasicInteger());
		test(new VolatileInteger());
		test(new SyncInteger());
		test(new MyAtomicInteger());
	}

	private static void test(IncrementInteger incrementInteger) {
		long startMs = System.currentTimeMillis();
		
		for (long i = 0; i < COUNT; i++) {
			incrementInteger.increment();
		}
		
		long endMs = System.currentTimeMillis();
		System.out.println(incrementInteger.getClass().getSimpleName() + ": ms=" + (endMs - startMs));
	}

}
