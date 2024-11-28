package java_adv01.thread.executor.future;

import java.util.List;
import java.util.concurrent.*;

import static java_adv01.util.MyLogger.log;
import java_adv01.thread.executor.CallableTask;

/*
 * 실행 결과 (여러 작업 한번에 처리- 모든 callable 작업 제출하고, 모든 작업이 완료되어야 return)
20:57:53.616 [pool-1-thread-2] task2 실행 
20:57:53.616 [pool-1-thread-1] task1 실행 
20:57:53.616 [pool-1-thread-3] task3 실행 
20:57:54.661 [pool-1-thread-1] task1 완료, return = 1000 
20:57:55.625 [pool-1-thread-2] task2 완료, return = 2000 
20:57:56.636 [pool-1-thread-3] task3 완료, return = 3000 
20:57:56.640 [     main] value = 1000 
20:57:56.642 [     main] value = 2000 
20:57:56.644 [     main] value = 3000 
 * */

public class InvokeAllMain {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		
		CallableTask task1 = new CallableTask("task1", 1000);
		CallableTask task2 = new CallableTask("task2", 2000);
		CallableTask task3 = new CallableTask("task3", 3000);
		
		List<CallableTask> tasks = List.of(task1, task2, task3);
		List<Future<Integer>> futures = es.invokeAll(tasks);
		for (Future<Integer> future : futures) {
			Integer value = future.get();
			log("value = " + value);
		}
		
		es.close();
	}

}
