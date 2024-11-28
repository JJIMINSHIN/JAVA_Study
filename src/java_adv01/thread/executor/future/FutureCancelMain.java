package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.concurrent.*;

/*
 * 실행 결과 ( cancel true) => 작업 중단
20:40:31.065 [     main] Future.state: RUNNING 
20:40:31.065 [pool-1-thread-1] 작업 중: 0 
20:40:32.080 [pool-1-thread-1] 작업 중: 1 
20:40:33.094 [pool-1-thread-1] 작업 중: 2 
20:40:34.079 [     main] future.cancel(true) 호출 
20:40:34.082 [pool-1-thread-1] 인터럽트 발생 
20:40:34.082 [     main] Future.state: CANCELLED 
20:40:34.106 [     main] cancel(true) result: true 
20:40:34.113 [     main] Future는 이미 취소 되었습니다. 
 * 
 * 실행 결과 (cancel false) => future 상태만 중단하고 실행중인 작업은 진행됨.
20:41:30.688 [     main] Future.state: RUNNING 
20:41:30.688 [pool-1-thread-1] 작업 중: 0 
20:41:31.709 [pool-1-thread-1] 작업 중: 1 
20:41:32.721 [pool-1-thread-1] 작업 중: 2 
20:41:33.704 [     main] future.cancel(false) 호출 
20:41:33.708 [     main] Future.state: CANCELLED 
20:41:33.730 [pool-1-thread-1] 작업 중: 3 
20:41:33.741 [     main] cancel(false) result: true 
20:41:33.742 [     main] Future는 이미 취소 되었습니다. 
20:41:34.740 [pool-1-thread-1] 작업 중: 4 
20:41:35.750 [pool-1-thread-1] 작업 중: 5 
20:41:36.763 [pool-1-thread-1] 작업 중: 6 
20:41:37.771 [pool-1-thread-1] 작업 중: 7 
20:41:38.783 [pool-1-thread-1] 작업 중: 8 
20:41:39.793 [pool-1-thread-1] 작업 중: 9 

 * */
public class FutureCancelMain {
	private static boolean mayInterruptIfRunning = false; // 변경
	//	private static boolean mayInterruptIfRunning = false; // 변경

	public static void main(String args[]) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<String> future = es.submit(new MyTask());
		log("Future.state: " + future.state()); // 반환된 future 상태 보기
		
		// 일정 시간 후 취소 시도
		sleep(3000);
		
		// cancel() 호출
		log("future.cancel(" + mayInterruptIfRunning + ") 호출");
		
		boolean cancelResult1 = future.cancel(mayInterruptIfRunning);
		log("Future.state: " + future.state());

		log("cancel(" + mayInterruptIfRunning + ") result: " + cancelResult1);
		
		// 결과 확인
		try {
			log("Future result: " + future.get());
		} catch (CancellationException e) { // 런타임 예외
			log("Future는 이미 취소 되었습니다.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// Executor 종료
		es.close();
	}

	static class MyTask implements Callable<String> {
		@Override
		public String call() {
			try {
				for (int i = 0; i < 10; i++) {
					log("작업 중: " + i);
					Thread.sleep(1000); // 1초 동안 sleep
				}
			} catch (InterruptedException e) {
				log("인터럽트 발생");
				return "Interrupted";
			}
			return "Completed";
		}

	}

}
