package java_adv01.thread.executor.poolsize;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;
import static java_adv01.thread.executor.ExecutorUtils.printState;

import java.util.concurrent.*;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과
17:01:20.293 [     main] [pool=0, active=0, queuedTasks=0, completedTask=0] 
17:01:20.303 [     main] [pool=1, active=1, queuedTasks=0, completedTask=0] 
17:01:20.305 [     main] [pool=2, active=2, queuedTasks=0, completedTask=0] 
17:01:20.306 [pool-1-thread-1] task1 시작 
17:01:20.306 [     main] [pool=2, active=2, queuedTasks=1, completedTask=0] 
17:01:20.306 [pool-1-thread-2] task2 시작 
17:01:20.307 [     main] [pool=2, active=2, queuedTasks=2, completedTask=0] 
17:01:20.308 [     main] [pool=3, active=3, queuedTasks=2, completedTask=0] 
17:01:20.308 [pool-1-thread-3] task5 시작 
17:01:20.308 [     main] [pool=4, active=4, queuedTasks=2, completedTask=0] 
17:01:20.309 [pool-1-thread-4] task6 시작 
17:01:20.309 [     main] task7 실행 거절 예외 발생: java.util.concurrent.RejectedExecutionException: Task java_adv01.thread.executor.RunnableTask@7921b0a2 rejected from java.util.concurrent.ThreadPoolExecutor@368239c8[Running, pool size = 4, active threads = 4, queued tasks = 2, completed tasks = 0] 
17:01:21.318 [pool-1-thread-2] task2 완료 
17:01:21.318 [pool-1-thread-1] task1 완료 
17:01:21.318 [pool-1-thread-4] task6 완료 
17:01:21.318 [pool-1-thread-3] task5 완료 
17:01:21.320 [pool-1-thread-2] task3 시작 
17:01:21.321 [pool-1-thread-1] task4 시작 
17:01:22.336 [pool-1-thread-1] task4 완료 
17:01:22.336 [pool-1-thread-2] task3 완료 
17:01:23.324 [     main] == 작업 수행 완료 ==  
17:01:23.326 [     main] [pool=4, active=0, queuedTasks=0, completedTask=6] 
17:01:26.342 [     main] == maxmumPoolSize 대기 시간 초과 ==  
17:01:26.343 [     main] [pool=2, active=0, queuedTasks=0, completedTask=6] 
17:01:26.345 [     main] == shutdown 완료 ==  
17:01:26.346 [     main] [pool=0, active=0, queuedTasks=0, completedTask=6] 

 * */

public class PoolSizeMainV1 {

	public static void main(String args[]) {
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
		ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);
		printState(es);

		es.execute(new RunnableTask("task1")); // 작업 전달
		printState(es, "task1"); // 로그 출력

		es.execute(new RunnableTask("task2"));
		printState(es, "task2");

		es.execute(new RunnableTask("task3"));
		printState(es, "task3");

		es.execute(new RunnableTask("task4"));
		printState(es, "task4");

		es.execute(new RunnableTask("task5"));
		printState(es, "task5");

		es.execute(new RunnableTask("task6"));
		printState(es, "task6");

		try {
			es.execute(new RunnableTask("task7"));
		}catch(RejectedExecutionException e) {
			log("task7 실행 거절 예외 발생: "+e);
		}
		
		sleep(3000);
		log("== 작업 수행 완료 == ");
		printState(es);
		
		sleep(3000);
		log("== maxmumPoolSize 대기 시간 초과 == ");
		printState(es);
		
		es.close();
		log("== shutdown 완료 == ");
		printState(es);
		
		
	}

}
