package java_adv01.thread.sync;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * 실행 결과.  => 동시성 파괴
12:57:12.239 [       t1] 거래 시작: BankAccountV1 
12:57:12.239 [       t2] 거래 시작: BankAccountV1 
12:57:12.251 [       t2] [검증 시작] 출금액: 800, 잔액: 1000 
12:57:12.251 [       t1] [검증 시작] 출금액: 800, 잔액: 1000 
12:57:12.251 [       t2] [검증 완료] 출금액: 800, 잔액: 1000 
12:57:12.251 [       t1] [검증 완료] 출금액: 800, 잔액: 1000 
12:57:12.664 [     main] t1 state : TIMED_WAITING 
12:57:12.664 [     main] t2 state : TIMED_WAITING 
12:57:13.257 [       t2] [출금 완료] 출금액: 800, 변경 잔액: -600 
12:57:13.257 [       t1] [출금 완료] 출금액: 800, 변경 잔액: 200 
12:57:13.258 [       t2] 거래 종료 
12:57:13.258 [       t1] 거래 종료 
12:57:13.268 [     main] 최종 잔액 : -600 

 * */
public class BankMain {
	
	public static void main(String args[]) throws InterruptedException {

		BankAccount account = new BankAccountV1(1000); //x001
		
		Thread t1 = new Thread(new WithdrawTask(account, 800),"t1"); //x002
		Thread t2 = new Thread(new WithdrawTask(account, 800),"t2"); //x003
		
		t1.start();
		t2.start();
		
		sleep(500);
		log("t1 state : "+t1.getState());
		log("t2 state : "+t2.getState());
		
		t1.join();
		t2.join();
		
		log("최종 잔액 : "+account.getBalance());
	}

}
