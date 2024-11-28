package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.Random;
import java.util.concurrent.*;

/*
 * 실행 결과
18:54:17.557 [     main] submit() 호출 
18:54:17.569 [pool-1-thread-1] Callable 시작 
18:54:17.572 [     main] future 즉시 반환, future = java.util.concurrent.FutureTask@737996a0[Not completed, task = java_adv01.thread.executor.future.CollableMainV2$MyCallable@234bef66] 
18:54:17.573 [     main] future.get() [블로킹] 메서드 호출 시작 -> main 스레드 WAITING 
18:54:19.602 [pool-1-thread-1] create value = 3 
18:54:19.603 [pool-1-thread-1] Callable 완료 
18:54:19.605 [     main] future.get() [블로킹] 메서드 호출 완료 -> main 스레드 RUNNABLE 
18:54:19.607 [     main] result value = 3 
18:54:19.609 [     main] future 완료, future = java.util.concurrent.FutureTask@737996a0[Completed normally] 

 * */
public class CollableMainV2 {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(1);
		log("submit() 호출");

		Future<Integer> future = es.submit(new MyCallable());
		log("future 즉시 반환, future = "+ future);
		
		log("future.get() [블로킹] 메서드 호출 시작 -> main 스레드 WAITING");
		Integer result = future.get(); // 여기서 메인 스레드 기다림
		log("future.get() [블로킹] 메서드 호출 완료 -> main 스레드 RUNNABLE");
		
		log("result value = " + result);
		log("future 완료, future = "+future);
		es.close();
	}

	static class MyCallable implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			log("Callable 시작");
			sleep(2000);
			int value = new Random().nextInt(10);
			log("create value = " + value);
			log("Callable 완료");
			return value;
		}

	}

}
