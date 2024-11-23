package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMainNotify {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueNotifyAll(2);
		
		//2.생산자, 소비자 실행 순서 선택, 반드시 하나만 선택!
		// 생산자
		producerFrist(queue);
		
		// 소비자
		//consumerFrist(queue);
		
	}
	
	private static void producerFrist(BoundedQueue queue) {
		log("== [생산자 먼저 실행] 시작, "+queue.getClass().getSimpleName()+" ==");
		
		List<Thread> threads = new ArrayList<>();
		startProducer(queue, threads);
		printAllState(queue, threads);
		startConsumer(queue, threads);
		printAllState(queue, threads);
		log("== [생산자 먼저 실행] 종료, "+queue.getClass().getSimpleName()+" ==");
	}
	
	private static void consumerFrist(BoundedQueue queue) {
		log("== [소비자 먼저 실행] 시작, "+queue.getClass().getSimpleName()+" ==");
		
		List<Thread> threads = new ArrayList<>();
		startConsumer(queue, threads);
		printAllState(queue, threads);
		startProducer(queue, threads);
		printAllState(queue, threads);
		log("== [소비자 먼저 실행] 종료, "+queue.getClass().getSimpleName()+" ==");
	}
	
	private static void startProducer(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("생산자 시작");
		for(int i=1; i<=3; i++) {
			Thread producer = new Thread(new ProducerTask(queue,"data"+i),"producer"+i);
			threads.add(producer);
			producer.start();
			sleep(100);
		}
	}
	
	private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
		System.out.println();
		log("생산자 시작");
		for(int i=1; i<=3; i++) {
			Thread consumer = new Thread(new ConsumerTask(queue,"data"+i),"consumer"+i);
			threads.add(consumer);
			consumer.start();
			sleep(100);
		}
	}
	
	public static void printAllState(BoundedQueue queue, List<Thread>threads) {
		System.out.println();
		log("현재 상태 출력, 큐 데이터 "+queue);
		for(Thread th : threads) {
			log(th.getName()+" : "+th.getState());
		}
	}

}

/*
 * 생산자 실행 결과
17:55:24.304 [     main] == [생산자 먼저 실행] 시작, BoundedQueueNotifyAll == 

17:55:24.308 [     main] 생산자 시작 
17:55:24.318 [producer1] [생산 시도] data1 -> [] 
17:55:24.318 [producer1] [put] 생성자 데이터 저장, notify() 호출  
17:55:24.318 [producer1] [생산 완료] data1 -> [data1] 
17:55:24.419 [producer2] [생산 시도] data2 -> [data1] 
17:55:24.420 [producer2] [put] 생성자 데이터 저장, notify() 호출  
17:55:24.420 [producer2] [생산 완료] data2 -> [data1, data2] 
17:55:24.527 [producer3] [생산 시도] data3 -> [data1, data2] 
17:55:24.527 [producer3] [put] 큐가 가득참, 생산자 대기  

17:55:24.637 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
17:55:24.638 [     main] producer1 : TERMINATED 
17:55:24.638 [     main] producer2 : TERMINATED 
17:55:24.639 [     main] producer3 : WAITING 

17:55:24.640 [     main] 생산자 시작 
17:55:24.644 [consumer1] [소비 시도] ? <- [data1, data2] 
17:55:24.644 [consumer1] [take] 소비자 데이터 획득, notify() 호출 
17:55:24.645 [producer3] [put] 생성자 깨어남  
17:55:24.645 [consumer1] [소비 완료] data1 <- [data2] 
17:55:24.645 [producer3] [put] 생성자 데이터 저장, notify() 호출  
17:55:24.647 [producer3] [생산 완료] data3 -> [data2, data3] 
17:55:24.758 [consumer2] [소비 시도] ? <- [data2, data3] 
17:55:24.758 [consumer2] [take] 소비자 데이터 획득, notify() 호출 
17:55:24.758 [consumer2] [소비 완료] data2 <- [data3] 
17:55:24.867 [consumer3] [소비 시도] ? <- [data3] 
17:55:24.868 [consumer3] [take] 소비자 데이터 획득, notify() 호출 
17:55:24.869 [consumer3] [소비 완료] data3 <- [] 

17:55:24.975 [     main] 현재 상태 출력, 큐 데이터 [] 
17:55:24.975 [     main] producer1 : TERMINATED 
17:55:24.977 [     main] producer2 : TERMINATED 
17:55:24.977 [     main] producer3 : TERMINATED 
17:55:24.978 [     main] consumer1 : TERMINATED 
17:55:24.978 [     main] consumer2 : TERMINATED 
17:55:24.979 [     main] consumer3 : TERMINATED 
17:55:24.979 [     main] == [생산자 먼저 실행] 종료, BoundedQueueNotifyAll == 


 * 
 * 소비자 실행 결과
17:54:24.128 [     main] == [소비자 먼저 실행] 시작, BoundedQueueNotifyAll == 

17:54:24.132 [     main] 생산자 시작 
17:54:24.137 [consumer1] [소비 시도] ? <- [] 
17:54:24.137 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
17:54:24.240 [consumer2] [소비 시도] ? <- [] 
17:54:24.240 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
17:54:24.348 [consumer3] [소비 시도] ? <- [] 
17:54:24.348 [consumer3] [take] 큐에 데이터가 없음, 소비자 대기 

17:54:24.458 [     main] 현재 상태 출력, 큐 데이터 [] 
17:54:24.465 [     main] consumer1 : WAITING 
17:54:24.467 [     main] consumer2 : WAITING 
17:54:24.467 [     main] consumer3 : WAITING 

17:54:24.467 [     main] 생산자 시작 
17:54:24.470 [producer1] [생산 시도] data1 -> [] 
17:54:24.470 [producer1] [put] 생성자 데이터 저장, notify() 호출  
17:54:24.470 [consumer1] [take] 소비자 깨어남 
17:54:24.470 [consumer1] [take] 소비자 데이터 획득, notify() 호출 
17:54:24.470 [producer1] [생산 완료] data1 -> [data1] 
17:54:24.471 [consumer3] [take] 소비자 깨어남 
17:54:24.471 [consumer1] [소비 완료] data1 <- [] 
17:54:24.471 [consumer3] [take] 큐에 데이터가 없음, 소비자 대기 
17:54:24.472 [consumer2] [take] 소비자 깨어남 
17:54:24.472 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
17:54:24.582 [producer2] [생산 시도] data2 -> [] 
17:54:24.582 [producer2] [put] 생성자 데이터 저장, notify() 호출  
17:54:24.582 [producer2] [생산 완료] data2 -> [data2] 
17:54:24.582 [consumer3] [take] 소비자 깨어남 
17:54:24.583 [consumer3] [take] 소비자 데이터 획득, notify() 호출 
17:54:24.583 [consumer2] [take] 소비자 깨어남 
17:54:24.583 [consumer3] [소비 완료] data2 <- [] 
17:54:24.583 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
17:54:24.691 [producer3] [생산 시도] data3 -> [] 
17:54:24.692 [producer3] [put] 생성자 데이터 저장, notify() 호출  
17:54:24.692 [consumer2] [take] 소비자 깨어남 
17:54:24.693 [producer3] [생산 완료] data3 -> [data3] 
17:54:24.693 [consumer2] [take] 소비자 데이터 획득, notify() 호출 
17:54:24.693 [consumer2] [소비 완료] data3 <- [] 

17:54:24.800 [     main] 현재 상태 출력, 큐 데이터 [] 
17:54:24.800 [     main] consumer1 : TERMINATED 
17:54:24.800 [     main] consumer2 : TERMINATED 
17:54:24.800 [     main] consumer3 : TERMINATED 
17:54:24.800 [     main] producer1 : TERMINATED 
17:54:24.800 [     main] producer2 : TERMINATED 
17:54:24.802 [     main] producer3 : TERMINATED 
17:54:24.802 [     main] == [소비자 먼저 실행] 종료, BoundedQueueNotifyAll == 
 

 * 
 * */