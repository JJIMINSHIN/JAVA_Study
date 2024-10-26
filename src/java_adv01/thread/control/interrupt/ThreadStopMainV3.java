package java_adv01.thread.control.interrupt;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행시간 0.01초 줌
16:41:06.455 [     work] 작업 중 
16:41:06.461 [     work] 작업 중 
16:41:06.455 [     main] 작업 중단 지시 thread.interrupt() 
16:41:06.461 [     work] 작업 중 
16:41:06.468 [     work] work 스레드 인터럽트 상태2 = true => interrupt 상태가 되도 true임
16:41:06.468 [     main] work 스레드 인터럽트 상태1 = true 
16:41:06.468 [     work] 자원 정리 
16:41:06.469 [     work] 작업 종료 
 * 기대 상황 :  자원정리 중 인터럽트 발생 X
 * 
16:48:19.006 [     work] 작업 중 
16:48:19.006 [     work] 작업 중 
16:48:19.006 [     main] 작업 중단 지시 thread.interrupt() 
16:48:19.006 [     work] 작업 중 
16:48:19.011 [     work] work 스레드 인터럽트 상태2 = true 
16:48:19.011 [     main] work 스레드 인터럽트 상태1 = true 
16:48:19.011 [     work] 자원 정리 
16:48:19.011 [     work] 자원 정리 실패 - 자원 정리 중 인터럽트 발생 
16:48:19.011 [     work] work 스레드 인터럽트 상태 3 = false 
16:48:19.011 [     work] 작업 종료 

 * */
public class ThreadStopMainV3 {

	public static void main(String args[]) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(100);
		log("작업 중단 지시 thread.interrupt()");
		thread.interrupt(); // 인터럽트 주기
		log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());

	}

	static class MyTask implements Runnable {

		volatile boolean runFlag = true;

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				log("작업 중");
			}
			log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

			try {
				log("자원 정리");
				Thread.sleep(1000);
				log("자원 종료");
			} catch (InterruptedException e) {
				log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
				log("work 스레드 인터럽트 상태 3 = " + Thread.currentThread().isInterrupted());
			}

			log("작업 종료");
		}

	}
}
