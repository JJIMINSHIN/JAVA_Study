package java_adv01.thread.executor.reject;

import java.util.concurrent.*;
import static java_adv01.util.MyLogger.log;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과 (나머지는 main이 실행함 -> 시간 소요 많이 됨) 
18:22:45.028 [     main] task2 시작 
18:22:45.028 [pool-1-thread-1] task1 시작 
18:22:46.042 [     main] task2 완료 
18:22:46.042 [pool-1-thread-1] task1 완료 
18:22:46.043 [     main] task3 시작 
18:22:47.058 [     main] task3 완료 
18:22:47.058 [pool-1-thread-1] task4 시작 
18:22:48.071 [pool-1-thread-1] task4 완료 
 * */
public class RejectMainV3 {

	public static void main(String args[]) {
		ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>(),
				new ThreadPoolExecutor.CallerRunsPolicy());

		es.submit(new RunnableTask("task1"));
		es.submit(new RunnableTask("task2"));
		es.submit(new RunnableTask("task3"));
		es.submit(new RunnableTask("task4"));
		
		es.close();
	}

}
