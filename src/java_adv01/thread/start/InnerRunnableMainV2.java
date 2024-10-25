package java_adv01.thread.start;

import static java_adv01.util.MyLogger.log;

public class InnerRunnableMainV2 {

	public static void main(String args[]) {
		log("main() start");
		
		//익명 클래스로 만들어주기
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				log(" : 익명 - run()");
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
		log("main() end");
	}
	
}
