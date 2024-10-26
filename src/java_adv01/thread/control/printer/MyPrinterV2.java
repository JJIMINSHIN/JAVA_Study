package java_adv01.thread.control.printer;

import static java_adv01.util.MyLogger.log;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;


/* q의 반응성 늘리기
17:26:31.280 [     main] 프린터할 문서를 입력하세요 :  종료(q) :  
17:26:32.266 [  printer] 출력 완료 
17:26:32.268 [  printer] 출력 시작 : asd , 대기 문서 : [s, s, a] 
q
17:26:32.476 [  printer] 인터럽트! 
17:26:32.476 [  printer] 프린터 종료 
 * */
public class MyPrinterV2 {
	
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
				printerThread.interrupt(); // 인터럽트 걸기
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
