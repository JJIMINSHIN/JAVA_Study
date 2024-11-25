package java_adv01.thread.cas;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


/*
 * 실행결과
start value = 0
00:22:39.248 [ Thread-1] getValue: 0 
00:22:39.248 [ Thread-0] getValue: 0 
00:22:39.267 [ Thread-1] result: true 
00:22:39.267 [ Thread-0] result: false 
00:22:39.381 [ Thread-0] getValue: 1 
00:22:39.382 [ Thread-0] result: true 
AtomicIntegerresultValue: 2
 * */
public class CasMainV3 {

	private static final int THREAD_COUNT = 2;

	public static void main(String args[]) throws InterruptedException {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		System.out.println("start value = " + atomicInteger.get());

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				incrementAndGet(atomicInteger);
			}
		};
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(runnable);
			threads.add(thread);
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		int result = atomicInteger.get();
		System.out.println(atomicInteger.getClass().getSimpleName() + "resultValue: " + result);
	}

	private static int incrementAndGet(AtomicInteger atomicInteger) {
		int getValue;
		boolean result;
		do {
			getValue = atomicInteger.get();
			sleep(100); // 스레드 동시 실행을 위한 대기
			log("getValue: " + getValue);
			result = atomicInteger.compareAndSet(getValue, getValue + 1);
			log("result: " + result);
		} while (!result);
		return getValue + 1;
	}
}