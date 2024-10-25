package java_adv01.thread.start.test;

import static java_adv01.util.MyLogger.log;

public class StartTest4Main {
	
	public static void main(String args[]) {
		Thread threadA = new Thread(new TestRunnable("A", 1000), "Thread-A");
		Thread threadB = new Thread(new TestRunnable("B", 500), "Thread-B");
		
		threadA.start();
		threadB.start();
		
	}
	
	static class TestRunnable implements Runnable {
		private String content;
		private int sleepMs;
		
		public TestRunnable (String content, int sleepMs) {
			this.content = content;
			this.sleepMs = sleepMs;
		}

		@Override
		public void run() {
			while(true) {
				log(content);
				try {
					Thread.sleep(sleepMs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
