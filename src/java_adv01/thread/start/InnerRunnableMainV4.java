package java_adv01.thread.start;

import static java_adv01.util.MyLogger.log;

public class InnerRunnableMainV4 {

	public static void main(String args[]) {
		log("main() start");
		
		//람다로 표현하기!
		Thread thread = new Thread( ()-> log(" : lamda - run()"));
		thread.start();
		
		log("main() end");
	}
	
}
