package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.Random;

/*
 * 실행 결과
15:52:10.562 [ Thread-1] Runnable 시작 
15:52:12.588 [ Thread-1] create value = 4 
15:52:12.588 [ Thread-1] Runnable 완료 
15:52:12.588 [     main] result value = 4 
 * */
public class RunnableMain {
	
	public static void main(String args[]) throws InterruptedException {
		MyRunnable task = new MyRunnable();
		Thread thread = new Thread(task,"Thread-1");
		thread.start();
		thread.join();
		int result =task.value;
		log("result value = "+result);
	}
	
	static class MyRunnable implements Runnable{
		int value;
		@Override
		public void run() {
			log("Runnable 시작");
			sleep(2000);
			value = new Random().nextInt(10);
			log("create value = "+value);
			log("Runnable 완료");
		}
		
	}

}
