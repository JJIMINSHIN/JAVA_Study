package java_adv01.thread.executor.reject;

import java.util.concurrent.*;
import static java_adv01.util.MyLogger.log;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과 ( 나머지 조용히 버림) 
18:25:47.347 [pool-1-thread-1] task1 시작 
18:25:48.360 [pool-1-thread-1] task1 완료 
 * */
public class RejectMainV2 {

	public static void main(String args[]) {
		ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>(),
				new ThreadPoolExecutor.DiscardPolicy());

		es.submit(new RunnableTask("task1"));
		es.submit(new RunnableTask("task2"));
		es.submit(new RunnableTask("task3"));
		es.submit(new RunnableTask("task4"));
		
		es.close();
	}

}
