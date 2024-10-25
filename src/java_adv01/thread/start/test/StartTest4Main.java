package java_adv01.thread.start.test;

import static java_adv01.util.MyLogger.log;

public class StartTest4Main {
	
	public static void main(String args[]) {
		
		
	}
	
	static class TestRunnable implements Runnable {

		@Override
		public void run() {
			log(" :  - A");
		}
	}
}
