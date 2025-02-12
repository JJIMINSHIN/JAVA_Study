package java_adv01.thread.control;

import static java_adv01.util.MyLogger.log;

import java_adv01.thread.start.HelloRunnable;

public class ThreadInfoMain {
	
	public static void main(String args[]) {
		
		//main
		Thread mainThread = Thread.currentThread();
		log("mainThread = "+mainThread);
		log("mainThread.threadId() = "+mainThread.threadId());
		log("mainThread.getName() = "+mainThread.getName());
		log("mainThread.getPriority() = "+mainThread.getPriority());
		log("mainThread.getThreadGroup() = "+mainThread.getThreadGroup());
		log("mainThread.getState() = "+mainThread.getState());
		
		//myThread
		Thread myThread = new Thread(new HelloRunnable(), "myThread");
		log("myThread = "+myThread);
		log("myThread.threadId() = "+myThread.threadId());
		log("myThread.getName() = "+myThread.getName());
		log("myThread.getPriority() = "+myThread.getPriority());
		log("myThread.getThreadGroup() = "+myThread.getThreadGroup());
		log("myThread.getState() = "+myThread.getState());
	}

}
