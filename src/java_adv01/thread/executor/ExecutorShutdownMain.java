package java_adv01.thread.executor;

import static java_adv01.thread.executor.ExecutorUtils.printState;
import static java_adv01.util.MyLogger.log;

import java.util.concurrent.*;

/*
 * 실행 결과
16:47:47.151 [pool-1-thread-2] taskB 시작 
16:47:47.151 [     main] [pool=2, active=2, queuedTasks=2, completedTask=0] 
16:47:47.151 [pool-1-thread-1] taskA 시작 
16:47:47.155 [     main] == shutdown 시작 == 
16:47:47.156 [     main] 서비스 정상 종료 시도 
16:47:48.159 [pool-1-thread-1] taskA 완료 
16:47:48.160 [pool-1-thread-1] taskC 시작 
16:47:48.160 [pool-1-thread-2] taskB 완료 
16:47:48.161 [pool-1-thread-2] longTask 시작 
16:47:49.172 [pool-1-thread-1] taskC 완료 
16:47:57.159 [     main] 서비스 정상 종료 실패 -> 강제 종료 시도 
16:47:57.160 [pool-1-thread-2] 인터럽트 발생, sleep interrupted 
Exception in thread "pool-1-thread-2" 16:47:57.160 [     main] == shoutdown 완료 == 
16:47:57.160 [     main] [pool=0, active=0, queuedTasks=0, completedTask=4] 
java.lang.RuntimeException: java.lang.InterruptedException: sleep interrupted
	at java_adv01.util.ThreadUtils.sleep(ThreadUtils.java:12)
	at java_adv01.thread.executor.RunnableTask.run(RunnableTask.java:25)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: java.lang.InterruptedException: sleep interrupted
	at java.base/java.lang.Thread.sleep0(Native Method)
	at java.base/java.lang.Thread.sleep(Thread.java:509)
	at java_adv01.util.ThreadUtils.sleep(ThreadUtils.java:9)
	... 4 more

 * */

public class ExecutorShutdownMain {
	
	public static void main(String args[]) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(new RunnableTask("taskA"));
		es.execute(new RunnableTask("taskB"));
		es.execute(new RunnableTask("taskC"));
		es.execute(new RunnableTask("longTask",100_000)); // 100초 대기
		printState(es);
		log("== shutdown 시작 ==");
		
		shutdownAndAwaitTermination(es);
		log("== shoutdown 완료 ==");
		printState(es);
		
	}

	static void shutdownAndAwaitTermination(ExecutorService es) {
		es.shutdown(); //non-blocking, 새로운 작업을 받지 않는다. 처리 중이거나, 큐에 이미 대기중인 작업을 처리한다. 이후에 풀의 스레드를 종료한다.
		
		try {
		
			log("서비스 정상 종료 시도");
			
			// 이미 작업중인 작업등릉 모두 완료할 떄 까지 10초 기다린다.
			if(!es.awaitTermination(10, TimeUnit.SECONDS)) {
				// 정상 종료가 너무 오래 걸리면...
				
				log("서비스 정상 종료 실패 -> 강제 종료 시도");
				es.shutdownNow();
				
				//작업이 취소될 떄 까지 기다린다.
				if(!es.awaitTermination(10, TimeUnit.SECONDS)) {
					log("서비스가 종료되지 않았습니다.");
				}
			}
			
		} catch (InterruptedException e) {
			es.shutdownNow();
		}
	}
}
