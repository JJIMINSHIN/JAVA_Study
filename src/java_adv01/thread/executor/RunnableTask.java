package java_adv01.thread.executor;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable{
	
	private final String name;
	private int sleepMs =1000;
	
	
	public RunnableTask(String name) {
		this.name = name;
	}

	public RunnableTask(String name, int sleepMs) {
		this.name = name;
		this.sleepMs = sleepMs;
	}

	@Override
	public void run() {
		log(name +" 시작");
		sleep(sleepMs);
		log(name +" 완료");
	}
	
	
	
}
