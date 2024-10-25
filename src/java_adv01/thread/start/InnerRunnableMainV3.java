package java_adv01.thread.start;

import static java_adv01.util.MyLogger.log;

public class InnerRunnableMainV3 {

	public static void main(String args[]) {
		log("main() start");
		
		//변수로 합치기!
		Thread thread = new Thread((new Runnable() {
			
			@Override
			public void run() {
				log(" : 변수 - run()");
			}
		}));
		thread.start();
		
		log("main() end");
	}
	
}
