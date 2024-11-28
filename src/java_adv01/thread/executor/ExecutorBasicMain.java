package java_adv01.thread.executor;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;
import static java_adv01.thread.executor.ExecutorUtils.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * 실행 결과
15:37:56.392 [     main] == 초기 상태 == 
15:37:56.411 [     main] [pool=0, active=0, queuedTasks=0, completedTask=0] 
15:37:56.414 [     main] == 작업 수행 중 == 
15:37:56.414 [     main] [pool=2, active=2, queuedTasks=2, completedTask=0] 
15:37:56.415 [pool-1-thread-2] taskB 시작 
15:37:56.415 [pool-1-thread-1] taskA 시작 
15:37:57.423 [pool-1-thread-2] taskB 완료 
15:37:57.423 [pool-1-thread-1] taskA 완료 
15:37:57.424 [pool-1-thread-2] taskC 시작 
15:37:57.425 [pool-1-thread-1] taskD 시작 
15:37:58.435 [pool-1-thread-2] taskC 완료 
15:37:58.435 [pool-1-thread-1] taskD 완료 
15:37:59.421 [     main] == 작업 수행 완료 == 
15:37:59.422 [     main] [pool=2, active=0, queuedTasks=0, completedTask=4] 
15:37:59.425 [     main] == shutdown 완료== 
15:37:59.427 [     main] [pool=0, active=0, queuedTasks=0, completedTask=4] 
 * */
public class ExecutorBasicMain {

	public static void main(String args[]) {
		ExecutorService es = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
		log("== 초기 상태 ==");
		printState(es);
		
		es.execute(new RunnableTask("taskA"));
		es.execute(new RunnableTask("taskB"));
		es.execute(new RunnableTask("taskC"));
		es.execute(new RunnableTask("taskD"));
		
		log("== 작업 수행 중 ==");
		printState(es);

		sleep(3000);
		log("== 작업 수행 완료 ==");
		printState(es);
		
		es.close();
		log("== shutdown 완료==");
		printState(es);
	}
}
