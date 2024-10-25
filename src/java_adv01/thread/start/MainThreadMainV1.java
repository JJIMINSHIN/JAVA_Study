package java_adv01.thread.start;

import static java_adv01.util.MyLogger.log;

public class MainThreadMainV1 {
	
	public static void main(String args[]) {
		log("main() start");
		
		HelloRunnable runnable = new HelloRunnable();
		
		Thread thread1 = new Thread(runnable);
		thread1.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		Thread thread3 = new Thread(runnable);
		thread3.start();

		log("main() end");
		
		
	}

}