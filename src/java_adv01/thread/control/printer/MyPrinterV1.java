package java_adv01.thread.control.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;


/*
 * queue.poll() : queue 첫번쨰 요소를 삭제 및 반환 => if(q.isEmpty) return null;
 * queue.remove() : poll과 같은 역할 => if(q.isEmpty) =>예외 발생
 * 프린터 입력
 * asd => sdf => dfg =>fgh 입력
17:17:44.896 [  printer] 출력 시작 : asd , 대기 문서 : [] 
fgh
17:17:46.514 [     main] 프린터할 문서를 입력하세요 :  종료(q) :  
17:17:47.904 [  printer] 출력 완료 
17:17:47.905 [  printer] 출력 시작 : sdf , 대기 문서 : [dfg, fgh] 
17:17:50.912 [  printer] 출력 완료 
17:17:50.913 [  printer] 출력 시작 : dfg , 대기 문서 : [fgh] 
17:17:53.921 [  printer] 출력 완료 
17:17:53.922 [  printer] 출력 시작 : fgh , 대기 문서 : [] 
17:17:56.923 [  printer] 출력 완료 

 * 프린터 종료
 * q
17:21:14.092 [  printer] 프린터 종료 

 * */
public class MyPrinterV1 {
	
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
				printer.work =false;
				break;
			}
			
			printer.addJob(input);
			
		}
		
	}
	
	static class Printer implements Runnable{
		
		volatile boolean work = true;
		Queue<String> jobQueue  = new ConcurrentLinkedQueue<>();
		
		
		@Override
		public void run() {
			while(work) {
				if(jobQueue.isEmpty()) continue;
				
				String job = jobQueue.poll();
				log("출력 시작 : "+job +" , 대기 문서 : "+jobQueue);
				sleep(3000);
				log("출력 완료");
			}
			
			log("프린터 종료");
		}
		
		public void addJob(String input) {
			jobQueue.offer(input);
		}
	}
}
