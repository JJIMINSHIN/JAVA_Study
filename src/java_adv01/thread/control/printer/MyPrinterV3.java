package java_adv01.thread.control.printer;

import static java_adv01.util.MyLogger.log;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;


/* 불필요한 변수 제거
17:28:36.517 [     main] 프린터할 문서를 입력하세요 :  종료(q) :  
asdas
17:28:38.034 [     main] 프린터할 문서를 입력하세요 :  종료(q) :  
17:28:38.043 [  printer] 출력 시작 : asdas , 대기 문서 : [] 
sadfs
17:28:41.045 [  printer] 출력 완료 
17:28:41.047 [  printer] 출력 시작 : sadfs , 대기 문서 : [asd] 
q
17:28:43.098 [  printer] 인터럽트! 
17:28:43.099 [  printer] 프린터 종료 

 * */
public class MyPrinterV3 {
	
	public static void main(String args[]) {
		Printer printer  = new Printer();
		Thread printerThread = new Thread(printer, "printer");
		printerThread.start();
		
		//입력
		Scanner userInput = new Scanner(System.in);
		while(true) {
			log("프린터할 문서를 입력하세요 :  종료(q) : ");
			String input = userInput.nextLine();
			if(input.equals("q")) {
				printerThread.interrupt(); // 인터럽트 걸기
				break;
			}
			
			printer.addJob(input);
			
		}
		
	}
	
	static class Printer implements Runnable{
		
		Queue<String> jobQueue  = new ConcurrentLinkedQueue<>();
		
		
		@Override
		public void run() {
			while(!Thread.interrupted()) {
				if(jobQueue.isEmpty()) continue;
				
				try {
					String job = jobQueue.poll();
					log("출력 시작 : "+job +" , 대기 문서 : "+jobQueue);
					Thread.sleep(3000);
					log("출력 완료");
				} catch (InterruptedException e) {
					log("인터럽트!");
					break;
				}
			}
			
			log("프린터 종료");
		}
		
		public void addJob(String input) {
			jobQueue.offer(input);
		}
	}
}
