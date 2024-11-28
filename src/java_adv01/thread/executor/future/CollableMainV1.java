package java_adv01.thread.executor.future;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.sleep;

import java.util.Random;
import java.util.concurrent.*;

/*
 * 실행 결과
18:43:28.784 [pool-1-thread-1] Callable 시작 
18:43:30.829 [pool-1-thread-1] create value = 4 
18:43:30.829 [pool-1-thread-1] Callable 완료 
18:43:30.835 [     main] result value = 4 
 * */
public class CollableMainV1 {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(1);
		/*
		 * 아래를 한줄로 줄이기! Integer result = es.submit(new MyCallable()).get(); => 시간 동일 이유
		 * : 반환한 다음 get 해야하므로 멀트스레드시 잘못된 사융의 예로 나타날 수 있다~
		 */
		Future<Integer> future = es.submit(new MyCallable());
		Integer result = future.get();
		log("result value = " + result);
		es.close();
	}

	static class MyCallable implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			log("Callable 시작");
			sleep(2000);
			int value = new Random().nextInt(10);
			log("create value = " + value);
			log("Callable 완료");
			return value;
		}

	}

}
