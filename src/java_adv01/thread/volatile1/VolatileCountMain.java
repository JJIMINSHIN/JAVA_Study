package java_adv01.thread.volatile1;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * volatile 미사용 실행결과
12:00:27.990 [     work] flag = true, count = 100000000 in while() 
12:00:28.248 [     work] flag = true, count = 200000000 in while() 
12:00:28.491 [     work] flag = true, count = 300000000 in while() 
12:00:28.736 [     work] flag = true, count = 400000000 in while() 
12:00:28.766 [     main] flag = false, count = 411882510 in main 
12:00:28.766 [     work] flag = false, count = 411882510 종료 
 *
 * volatile 적용
12:05:41.184 [     work] flag = true, count = 100000000 in while() 
12:05:41.416 [     work] flag = false, count = 134305212 종료 
12:05:41.416 [     main] flag = false, count = 134305212 in main 
 * */

public class VolatileCountMain {
	
	public static void main(String args[]) {
		MyTask task  = new MyTask();
		Thread t = new Thread(task, "work");
		t.start();
		
		sleep(1000);
		task.flag =false;
		log("flag = "+task.flag+", count = "+task.count +" in main");
		
	}
	
	static class MyTask implements Runnable{
		
//		boolean flag = true;
//		long count;
		
		volatile boolean flag = true;
		volatile long count;
		@Override
		public void run() {
			while(flag) {
				count++;
				if(count%100_000_000==0) {
					log("flag = "+flag+", count = "+count +" in while()");
				}
			}
			log("flag = "+flag+", count = "+count +" 종료");

		}
	}

}
