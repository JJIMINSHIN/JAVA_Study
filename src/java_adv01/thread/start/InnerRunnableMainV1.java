package java_adv01.thread.start;

import static java_adv01.util.MyLogger.log;

public class InnerRunnableMainV1 {

	public static void main(String args[]) {
		log("main() start");
		
		MyRunnable runnable = new MyRunnable();
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		log("main() end");
	}
	
	//여기서만 사용할 것 같으니 중첩클래스로 만들어주기
	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			log(" : 중첩클래스 - run()");
		}
	}
}
