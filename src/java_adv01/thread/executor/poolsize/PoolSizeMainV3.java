package java_adv01.thread.executor.poolsize;

import static java_adv01.thread.executor.ExecutorUtils.printState;
import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과 ( 작업 요청이 오면 스레드가 바로바로 처리, 다 active로 넘어감, queue에 작업 저장하지 않음)
17:46:21.362 [     main] pool 생성 
17:46:21.405 [     main] [pool=0, active=0, queuedTasks=0, completedTask=0] 
17:46:21.414 [     main] [pool=1, active=1, queuedTasks=0, completedTask=0] 
17:46:21.415 [     main] [pool=2, active=2, queuedTasks=0, completedTask=0] 
17:46:21.415 [pool-1-thread-2] task1 시작 
17:46:21.415 [pool-1-thread-1] task0 시작 
17:46:21.417 [     main] [pool=3, active=3, queuedTasks=0, completedTask=0] 
17:46:21.417 [pool-1-thread-3] task2 시작 
17:46:21.418 [     main] [pool=4, active=4, queuedTasks=0, completedTask=0] 
17:46:21.420 [     main] [pool=5, active=5, queuedTasks=0, completedTask=0] 
17:46:21.423 [pool-1-thread-4] task3 시작 
17:46:21.423 [pool-1-thread-5] task4 시작 
17:46:22.436 [pool-1-thread-5] task4 완료 
17:46:22.436 [pool-1-thread-4] task3 완료 
17:46:22.438 [pool-1-thread-3] task2 완료 
17:46:22.438 [pool-1-thread-2] task1 완료 
17:46:22.439 [pool-1-thread-1] task0 완료 
17:46:24.427 [     main] == 작업 수행 완료 ==  
17:46:24.428 [     main] [pool=5, active=0, queuedTasks=0, completedTask=5] 
17:46:27.434 [     main] == maxmumPoolSize 대기 시간 초과 ==  
17:46:27.435 [     main] [pool=0, active=0, queuedTasks=0, completedTask=5] 
17:46:27.437 [     main] == shutdown 완료 ==  
17:46:27.439 [     main] [pool=0, active=0, queuedTasks=0, completedTask=5] 
 * */

public class PoolSizeMainV3 {

	public static void main(String args[]) {
		
		ThreadPoolExecutor es = new ThreadPoolExecutor(0,Integer.MAX_VALUE, 3, TimeUnit.SECONDS, new SynchronousQueue<>());
		
		log("pool 생성");
		printState(es);
		
		for (int i = 0; i <=4; i++) {
			String taskName = "task"+i;
			es.execute(new RunnableTask(taskName));
			printState(es, taskName);
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
