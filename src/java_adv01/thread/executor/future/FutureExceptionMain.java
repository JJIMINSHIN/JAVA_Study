package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.concurrent.*;

/*
 * 실행 결과 
20:48:45.488 [     main] 작업 전달 
20:48:45.503 [pool-1-thread-1] Collable 실행, 예외 발생 
20:48:46.559 [     main] future.get() 호출 시도, future.state(): FAILED 
20:48:46.561 [     main] e = java.util.concurrent.ExecutionException: java.lang.IllegalStateException: ex! 
20:48:46.567 [     main] Cause = java.lang.IllegalStateException: ex! 
 * */
public class FutureExceptionMain {

	public static void main(String args[]) {
		
		ExecutorService es = Executors.newFixedThreadPool(1);
		log("작업 전달");
		Future<Integer> future = es.submit(new Excallable());
		sleep(1000);
		
		// 결과 확인
		try {
			log("future.get() 호출 시도, future.state(): " + future.state());
			Integer result = future.get();
			log("result value = "+result);
			
		} catch (InterruptedException e) { // 런타임 예외
			throw new RuntimeException(e);
		} catch (ExecutionException e) {
			log("e = "+e );
			Throwable cause = e.getCause();
			log("Cause = "+cause);
		}
		es.close();
	}

	static class Excallable implements Callable<Integer> {
		@Override
		public Integer call() {
			log("Collable 실행, 예외 발생" );
			throw new IllegalStateException("ex!");
		}

	}

}
