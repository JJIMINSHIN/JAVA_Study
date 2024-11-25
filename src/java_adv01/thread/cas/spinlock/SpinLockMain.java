package java_adv01.thread.cas.spinlock;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

/*
 * 실행 결과 
01:28:34.288 [ Thread-1] 락 획득 시도 
01:28:34.288 [ Thread-2] 락 획득 시도 
01:28:34.298 [ Thread-2] 락 획득 실패 - 스핀 대기 
01:28:34.298 [ Thread-1] 락 획득 완료 
01:28:34.298 [ Thread-2] 락 획득 실패 - 스핀 대기 
01:28:34.299 [ Thread-1] 비즈니스 로직 실행 
01:28:34.300 [ Thread-2] 락 획득 실패 - 스핀 대기 
01:28:34.300 [ Thread-1] 락 반납 완료 
01:28:34.302 [ Thread-2] 락 획득 완료 
01:28:34.302 [ Thread-2] 비즈니스 로직 실행 
01:28:34.303 [ Thread-2] 락 반납 완료 

 * 실행 결과 sleep(1) => 수십만번 실행됨. 
01:27:04.976 [ Thread-2] 락 획득 시도 
01:27:04.976 [ Thread-1] 락 획득 시도 
01:27:04.997 [ Thread-2] 락 획득 완료 
01:27:04.997 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:04.998 [ Thread-2] 비즈니스 로직 실행 
01:27:04.998 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.001 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.001 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.002 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.003 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.004 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.005 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.006 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.007 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.007 [ Thread-1] 락 획득 실패 - 스핀 대기 
01:27:05.008 [ Thread-2] 락 반납 완료 
01:27:05.008 [ Thread-1] 락 획득 완료 
01:27:05.010 [ Thread-1] 비즈니스 로직 실행 
01:27:05.014 [ Thread-1] 락 반납 완료 
 * */

public class SpinLockMain {

	public static void main(String args[]) {
		SpinLock spinLock = new SpinLock();
		Runnable task = new Runnable() {
			@Override
			public void run() {
				spinLock.lock();
				try {
					// critical section
					log("비즈니스 로직 실행");
					//sleep(1); // 오래 걸리는 로직에서 스핀 락 사용X
				} finally {
					spinLock.unlock();
				}
			}
		};
		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");
		t1.start();
		t2.start();
	}

}
