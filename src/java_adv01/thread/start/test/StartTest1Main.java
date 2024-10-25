package java_adv01.thread.start.test;

import static java_adv01.util.MyLogger.log;

public class StartTest1Main {
	
	public static void main(String args[]) {
		CounterThread cth = new CounterThread();
		cth.start();
	}
	
	static class CounterThread extends Thread{
		
		@Override
		public void run() {
			for(int i=1; i<=5; i++) {
			
				log("value : "+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
		
	}
}
