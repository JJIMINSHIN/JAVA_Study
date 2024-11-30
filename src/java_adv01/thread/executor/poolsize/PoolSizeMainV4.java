package java_adv01.thread.executor.poolsize;

import static java_adv01.thread.executor.ExecutorUtils.printState;
import static java_adv01.util.MyLogger.log;

import java.util.concurrent.*;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과 (1100개 - 일반적인 상황 11170/100 = 11.7초)
18:02:18.509 [pool-1-thread-73] task1099 완료 
18:02:18.509 [pool-1-thread-60] task1093 완료 
18:02:18.509 [pool-1-thread-59] task1091 완료 
18:02:18.509 [pool-1-thread-63] task1090 완료 
18:02:18.511 [     main] time : 11170 

 * 실행 결과 (1200개 - 긴급 상황 10120/200  6초)
18:05:58.721 [     main] [pool=100, active=100, queuedTasks=738, completedTask=0] 
18:05:58.721 [     main] [pool=100, active=100, queuedTasks=739, completedTask=0] 
18:05:58.721 [     main] [pool=100, active=100, queuedTasks=740, completedTask=0] 
18:05:58.721 [     main] [pool=100, active=100, queuedTasks=743, completedTask=0] 
18:04:19.777 [pool-1-thread-70] task1088 완료 
18:04:19.793 [pool-1-thread-97] task1097 완료 
18:04:19.793 [pool-1-thread-100] task1095 완료 
18:04:19.793 [pool-1-thread-84] task1099 완료 
18:04:19.795 [     main] time : 10120 
 
 * 실행 결과 (1100개 - 거절 상황 6235/200 3초)
18:06:25.530 [     main] [pool=100, active=100, queuedTasks=111, completedTask=0] 
18:08:23.439 [pool-1-thread-187] task1186 시작 
18:08:23.439 [     main] [pool=196, active=196, queuedTasks=1000, completedTask=0] 
18:08:23.439 [pool-1-thread-188] task1187 시작 
18:08:23.439 [pool-1-thread-191] task1190 시작 
18:08:23.439 [pool-1-thread-192] task1191 시작 
18:08:23.439 [     main] [pool=197, active=197, queuedTasks=1000, completedTask=0] 
18:08:23.439 [pool-1-thread-175] task1174 시작 
18:08:23.439 [pool-1-thread-195] task1194 시작 
18:08:23.439 [     main] [pool=198, active=198, queuedTasks=1000, completedTask=0] 
18:08:23.439 [pool-1-thread-197] task1196 시작 
18:08:23.439 [pool-1-thread-196] task1195 시작 
18:08:23.439 [pool-1-thread-198] task1197 시작 
18:08:23.439 [     main] [pool=199, active=199, queuedTasks=1000, completedTask=0] 
18:08:23.439 [pool-1-thread-199] task1198 시작 
18:08:23.439 [     main] [pool=200, active=200, queuedTasks=1000, completedTask=0] 
18:08:23.439 [pool-1-thread-200] task1199 시작 
18:08:23.449 [     main] task1200 -> java.util.concurrent.RejectedExecutionException: Task java_adv01.thread.executor.RunnableTask@64bf3bbf rejected from java.util.concurrent.ThreadPoolExecutor@368239c8[Running, pool size = 200, active threads = 200, queued tasks = 1000, completed tasks = 0] 
18:08:23.449 [     main] task1201 -> java.util.concurrent.RejectedExecutionException: Task java_adv01.thread.executor.RunnableTask@78c03f1f rejected from java.util.concurrent.ThreadPoolExecutor@368239c8[Running, pool size = 200, active threads = 200, queued tasks = 1000, completed tasks = 0] 
18:08:29.509 [pool-1-thread-191] task1085 완료 
18:08:29.512 [     main] time : 6235 
 * */

public class PoolSizeMainV4 {
	
	//static final int TASK_SIZE =  1100; // 1. 일반
	static final int TASK_SIZE =  1119; // 2. 긴급
	//static final int TASK_SIZE =  1201; // 3.거절

	public static void main(String args[]) {
		
		// 쓰레드 100개 사용 추가 긴급 스레드 100개 더 추가 가능 , 큐에 1000개까지 저장할수 있다.
		ExecutorService es = new ThreadPoolExecutor(100,200, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
		printState(es);
		
		long startMs = System.currentTimeMillis();
		
		for (int i = 0; i <=TASK_SIZE; i++) {
			String taskName = "task"+i;
			try {
				es.execute(new RunnableTask(taskName));
				printState(es, taskName);
			}catch(RejectedExecutionException e) {
				log(taskName+" -> "+e);
			}
		}
		
		es.close();
		
		long endMs = System.currentTimeMillis();
		log("time : "+(endMs -startMs));
	}

}
