package java_adv01.thread.bounded;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;


public class BoundedMain3 {
	
	public static void main(String args[]) {
		// 1.BoundedQueue 선택
		BoundedQueue  queue = new BoundedQueueV3(2);
		
		//2.생산자, 소비자 실행 순서 선택, 반드시 하나만 선택!
		// 생산자
		//producerFrist(queue);
		
		// 소비자
		consumerFrist(queue);
		
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
17:12:54.196 [     main] == [생산자 먼저 실행] 시작, BoundedQueueV3 == 

17:12:54.202 [     main] 생산자 시작 
17:12:54.212 [producer1] [생산 시도] data1 -> [] 
17:12:54.212 [producer1] [put] 생성자 데이터 저장, notify() 호출  
17:12:54.213 [producer1] [생산 완료] data1 -> [data1] 
17:12:54.309 [producer2] [생산 시도] data2 -> [data1] 
17:12:54.310 [producer2] [put] 생성자 데이터 저장, notify() 호출  
17:12:54.310 [producer2] [생산 완료] data2 -> [data1, data2] 
17:12:54.417 [producer3] [생산 시도] data3 -> [data1, data2] 
17:12:54.417 [producer3] [put] 큐가 가득참, 생산자 대기  

17:12:54.528 [     main] 현재 상태 출력, 큐 데이터 [data1, data2] 
17:12:54.530 [     main] producer1 : TERMINATED 
17:12:54.530 [     main] producer2 : TERMINATED 
17:12:54.530 [     main] producer3 : WAITING 

17:12:54.532 [     main] 생산자 시작 
17:12:54.537 [consumer1] [소비 시도] ? <- [data1, data2] 
17:12:54.537 [consumer1] [take] 소비자 데이터 획득, notify() 호출 
17:12:54.538 [producer3] [put] 생성자 깨어남  
17:12:54.538 [consumer1] [소비 완료] data1 <- [data2] 
17:12:54.539 [producer3] [put] 생성자 데이터 저장, notify() 호출  
17:12:54.539 [producer3] [생산 완료] data3 -> [data2, data3] 
17:12:54.652 [consumer2] [소비 시도] ? <- [data2, data3] 
17:12:54.653 [consumer2] [take] 소비자 데이터 획득, notify() 호출 
17:12:54.654 [consumer2] [소비 완료] data2 <- [data3] 
17:12:54.761 [consumer3] [소비 시도] ? <- [data3] 
17:12:54.762 [consumer3] [take] 소비자 데이터 획득, notify() 호출 
17:12:54.762 [consumer3] [소비 완료] data3 <- [] 

17:12:54.870 [     main] 현재 상태 출력, 큐 데이터 [] 
17:12:54.871 [     main] producer1 : TERMINATED 
17:12:54.871 [     main] producer2 : TERMINATED 
17:12:54.872 [     main] producer3 : TERMINATED 
17:12:54.872 [     main] consumer1 : TERMINATED 
17:12:54.873 [     main] consumer2 : TERMINATED 
17:12:54.874 [     main] consumer3 : TERMINATED 
17:12:54.874 [     main] == [생산자 먼저 실행] 종료, BoundedQueueV3 == 

 * 
 * 소비자 실행 결과
17:13:34.666 [     main] == [소비자 먼저 실행] 시작, BoundedQueueV3 == 

17:13:34.670 [     main] 생산자 시작 
17:13:34.675 [consumer1] [소비 시도] ? <- [] 
17:13:34.675 [consumer1] [take] 큐에 데이터가 없음, 소비자 대기 
17:13:34.787 [consumer2] [소비 시도] ? <- [] 
17:13:34.788 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
17:13:34.897 [consumer3] [소비 시도] ? <- [] 
17:13:34.898 [consumer3] [take] 큐에 데이터가 없음, 소비자 대기 

17:13:35.005 [     main] 현재 상태 출력, 큐 데이터 [] 
17:13:35.023 [     main] consumer1 : WAITING 
17:13:35.025 [     main] consumer2 : WAITING 
17:13:35.025 [     main] consumer3 : WAITING 

17:13:35.026 [     main] 생산자 시작 
17:13:35.030 [producer1] [생산 시도] data1 -> [] 
17:13:35.030 [producer1] [put] 생성자 데이터 저장, notify() 호출  
17:13:35.030 [consumer1] [take] 소비자 깨어남 
17:13:35.030 [consumer1] [take] 소비자 데이터 획득, notify() 호출 
17:13:35.030 [producer1] [생산 완료] data1 -> [data1] 
17:13:35.032 [consumer2] [take] 소비자 깨어남 
17:13:35.032 [consumer1] [소비 완료] data1 <- [] 
17:13:35.032 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
17:13:35.129 [producer2] [생산 시도] data2 -> [] 
17:13:35.129 [producer2] [put] 생성자 데이터 저장, notify() 호출  
17:13:35.131 [producer2] [생산 완료] data2 -> [data2] 
17:13:35.131 [consumer3] [take] 소비자 깨어남 
17:13:35.131 [consumer3] [take] 소비자 데이터 획득, notify() 호출 
17:13:35.132 [consumer2] [take] 소비자 깨어남 
17:13:35.132 [consumer3] [소비 완료] data2 <- [] 
17:13:35.132 [consumer2] [take] 큐에 데이터가 없음, 소비자 대기 
17:13:35.238 [producer3] [생산 시도] data3 -> [] 
17:13:35.239 [producer3] [put] 생성자 데이터 저장, notify() 호출  
17:13:35.239 [consumer2] [take] 소비자 깨어남 
17:13:35.239 [producer3] [생산 완료] data3 -> [data3] 
17:13:35.239 [consumer2] [take] 소비자 데이터 획득, notify() 호출 
17:13:35.240 [consumer2] [소비 완료] data3 <- [] 

17:13:35.348 [     main] 현재 상태 출력, 큐 데이터 [] 
17:13:35.350 [     main] consumer1 : TERMINATED 
17:13:35.351 [     main] consumer2 : TERMINATED 
17:13:35.352 [     main] consumer3 : TERMINATED 
17:13:35.353 [     main] producer1 : TERMINATED 
17:13:35.354 [     main] producer2 : TERMINATED 
17:13:35.355 [     main] producer3 : TERMINATED 
17:13:35.358 [     main] == [소비자 먼저 실행] 종료, BoundedQueueV3 == 

 * 
 * */