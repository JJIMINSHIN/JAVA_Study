package java_adv01.thread.executor.reject;

import static java_adv01.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import java_adv01.thread.executor.RunnableTask;

/*
 * 실행 결과
18:19:47.908 [     main] 요청 초과 
18:19:47.908 [pool-1-thread-1] task1 시작 
18:19:47.913 [     main] java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@532760d8[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@77afea7d[Wrapped task = java_adv01.thread.executor.RunnableTask@161cd475]] rejected from java.util.concurrent.ThreadPoolExecutor@7382f612[Running, pool size = 1, active threads = 1, queued tasks = 0, completed tasks = 0] 
18:19:48.928 [pool-1-thread-1] task1 완료 
 * */
public class RejectMainV1 {

	public static void main(String args[]) {
		ExecutorService es = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
		
		es.submit(new RunnableTask("task1"));
		try {
			es.submit(new RunnableTask("task2"));
		}catch (RejectedExecutionException e) {
			log("요청 초과");
			// 포기, 다시 시도 등 다양한 고민 하면 됨
			log(e);
		}
		es.close();
	}
	
}
