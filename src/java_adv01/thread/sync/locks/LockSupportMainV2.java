package java_adv01.thread.sync.locks;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.concurrent.locks.LockSupport;

/*
 * 1. unpark 사용 실행결과 
17:07:14.352 [ Thread-1] park 시작 
17:07:14.547 [     main] Thread-1 state: WAITING 
17:07:14.548 [     main] main -> unpark(Thread-1) 
17:07:14.550 [ Thread-1] park 종료, state: RUNNABLE 
17:07:14.580 [ Thread-1] 인터럽트 상태false 

 * 2. interrupt 사용 실행결과
17:09:24.933 [ Thread-1] park 시작 
17:09:25.099 [     main] Thread-1 state: WAITING 
17:09:25.100 [     main] main -> unpark(Thread-1) 
17:09:25.103 [ Thread-1] park 종료, state: RUNNABLE 
17:09:25.132 [ Thread-1] 인터럽트 상태 : true 
 * 
 * */
public class LockSupportMainV2 {
	public static void main(String args[]) {
		Thread thread1 = new Thread(new ParkTask(),"Thread-1");
		thread1.start();
		
		//잠시 대기하여 thread-1이 park 상태에 빠질 시간을 준다.
		sleep(300);
		log("Thread-1 state: "+thread1.getState());
		
		log("main -> unpark(Thread-1)");
		// unpark, interrupt를 사용해서 쓰레드 깨우기
		//LockSupport.unpark(thread1); //1.unpark 사용
		thread1.interrupt(); // 2.interrupt 사용
	}
	
	static class ParkTask implements Runnable{

		@Override
		public void run() {
			log("park 시작");
			LockSupport.park();
			log("park 종료, state: "+Thread.currentThread().getState());
			log("인터럽트 상태 : "+Thread.currentThread().isInterrupted());
			
		}
	}

}
