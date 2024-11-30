package java_adv01.thread.executor.reject;

import static java_adv01.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과 (사용자 정의 -> 시간 소요 많이 됨) 
18:27:47.158 [pool-1-thread-1] task1 시작 
18:27:47.158 [     main] [경고] 거절된 누적 작업 수: 1 
18:27:47.164 [     main] [경고] 거절된 누적 작업 수: 2 
18:27:47.165 [     main] [경고] 거절된 누적 작업 수: 3 
18:27:48.176 [pool-1-thread-1] task1 완료 
 * */
public class RejectMainV4 {

	public static void main(String args[]) {
		ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>(),
				new MyRejectedExecutionHandler());

		es.submit(new RunnableTask("task1"));
		es.submit(new RunnableTask("task2"));
		es.submit(new RunnableTask("task3"));
		es.submit(new RunnableTask("task4"));

		es.close();
	}

	static class MyRejectedExecutionHandler implements RejectedExecutionHandler {
		static AtomicInteger count = new AtomicInteger(0); // 거절 갯수 세기

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			int i = count.incrementAndGet();
			log("[경고] 거절된 누적 작업 수: " + i);
		}
	}
}
