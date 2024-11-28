package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;

import java.util.List;
import java.util.concurrent.*;

import java_adv01.thread.executor.CallableTask;

/*
 * 실행 결과 (여러 작업 한번에 처리- 모든 callable 작업 제출하고, 하나의 작업이 완료되면 return, 나머지는 취소)
20:59:37.330 [pool-1-thread-1] task1 실행 
20:59:37.330 [pool-1-thread-2] task2 실행 
20:59:37.330 [pool-1-thread-3] task3 실행 
20:59:38.396 [pool-1-thread-1] task1 완료, return = 1000 
20:59:38.402 [     main] value = 1000 
20:59:38.406 [pool-1-thread-3] 인터럽트 발생, sleep interrupted 
20:59:38.406 [pool-1-thread-2] 인터럽트 발생, sleep interrupted 

 * */

public class InvokeAnyMain {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);

		CallableTask task1 = new CallableTask("task1", 1000);
		CallableTask task2 = new CallableTask("task2", 2000);
		CallableTask task3 = new CallableTask("task3", 3000);

		List<CallableTask> tasks = List.of(task1, task2, task3);

		Integer value = es.invokeAny(tasks);
		log("value = " + value);

		es.close();
	}
}
