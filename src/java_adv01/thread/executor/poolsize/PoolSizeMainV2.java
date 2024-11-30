package java_adv01.thread.executor.poolsize;

import static java_adv01.thread.executor.ExecutorUtils.printState;
import static java_adv01.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과 (큐 사이즈에 제한이 없다.)
17:35:52.294 [     main] pool 생성 
17:35:52.333 [     main] [pool=0, active=0, queuedTasks=0, completedTask=0] 
17:35:52.342 [     main] [pool=1, active=1, queuedTasks=0, completedTask=0] 
17:35:52.343 [     main] [pool=2, active=2, queuedTasks=0, completedTask=0] 
17:35:52.343 [pool-1-thread-1] task0 시작 
17:35:52.343 [pool-1-thread-2] task1 시작 
17:35:52.344 [     main] [pool=2, active=2, queuedTasks=1, completedTask=0] 
17:35:52.345 [     main] [pool=2, active=2, queuedTasks=2, completedTask=0] 
17:35:52.345 [     main] [pool=2, active=2, queuedTasks=3, completedTask=0] 
17:35:52.347 [     main] [pool=2, active=2, queuedTasks=4, completedTask=0] 
17:35:52.347 [     main] [pool=2, active=2, queuedTasks=5, completedTask=0] 
17:35:53.357 [pool-1-thread-2] task1 완료 
17:35:53.358 [pool-1-thread-1] task0 완료 
17:35:53.359 [pool-1-thread-2] task2 시작 
17:35:53.359 [pool-1-thread-1] task3 시작 
17:35:54.363 [pool-1-thread-1] task3 완료 
17:35:54.363 [pool-1-thread-2] task2 완료 
17:35:54.363 [pool-1-thread-1] task4 시작 
17:35:54.363 [pool-1-thread-2] task5 시작 
17:35:55.368 [pool-1-thread-1] task4 완료 
17:35:55.368 [pool-1-thread-2] task5 완료 
17:35:55.369 [pool-1-thread-1] task6 시작 
17:35:56.382 [pool-1-thread-1] task6 완료 
17:35:56.383 [     main] == shutdown 완료 ==  
 * */

public class PoolSizeMainV2 {

	public static void main(String args[]) {
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		// 이거랑 같다. ExecutorService es = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
		log("pool 생성");
		printState(es);
		
		for (int i = 0; i <=6; i++) {
			String taskName = "task"+i;
			es.execute(new RunnableTask(taskName));
			printState(es, taskName);
		}
		
		es.close();
		log("== shutdown 완료 == ");
	}

}
