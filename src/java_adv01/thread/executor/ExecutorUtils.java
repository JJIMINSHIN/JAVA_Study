package java_adv01.thread.executor;

import static java_adv01.util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class ExecutorUtils {

	public static void printState(ExecutorService executorService) {
		
		if (executorService instanceof ThreadPoolExecutor poolExecutor) {

			int pool = poolExecutor.getPoolSize();
			int active = poolExecutor.getActiveCount();
			int queuedTasks = poolExecutor.getQueue().size();
			long completedTask = poolExecutor.getCompletedTaskCount();

			log("[pool=" + pool + ", active=" + active + ", queuedTasks=" + queuedTasks + ", completedTask="
					+ completedTask + "]");
		} else {
			log(executorService);
		}
	}
	
	// 우아한 종료를 위한 추가, 오버 로딩 
	public static void printState(ExecutorService executorService, String taskName) {
		
		if (executorService instanceof ThreadPoolExecutor poolExecutor) {

			int pool = poolExecutor.getPoolSize();
			int active = poolExecutor.getActiveCount();
			int queuedTasks = poolExecutor.getQueue().size();
			long completedTask = poolExecutor.getCompletedTaskCount();

			log("[pool=" + pool + ", active=" + active + ", queuedTasks=" + queuedTasks + ", completedTask="
					+ completedTask + "]");
		} else {
			log(taskName +"  -> " + executorService);
		}
	}

}
