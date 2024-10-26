package java_adv01.thread.control.interrupt;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 *
16:56:08.914 [     work] 작업 중 
16:56:08.914 [     work] 작업 중 
16:56:08.915 [     main] 작업 중단 지시 thread.interrupt() 
16:56:08.915 [     work] 작업 중 
16:56:08.921 [     main] work 스레드 인터럽트 상태1 = true 
16:56:08.921 [     work] work 스레드 인터럽트 상태2 = false 
16:56:08.921 [     work] 자원 정리 
16:56:09.926 [     work] 자원 종료 
16:56:09.926 [     work] 작업 종료 
 
 * 
 * */
public class ThreadStopMainV4 {

	public static void main(String args[]) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(100);
		log("작업 중단 지시 thread.interrupt()");
		/* 옛날에는 thread.stop()을 사용 => 자원정리 및 종료할 수 없음. 이런게 있었다라는것만 알아두기!*/
		thread.interrupt(); // 인터럽트 주기
		log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());

	}

	static class MyTask implements Runnable {

		volatile boolean runFlag = true;

		@Override
		public void run() {
			while (!Thread.interrupted()) {
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
