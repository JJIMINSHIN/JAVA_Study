package java_adv01.thread.sync;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * syncronized 적용
 * 실행 결과.  => 동시성 파괴 헤결
15:41:57.484 [       t1] 거래 시작: BankAccountV2 
15:41:57.496 [       t1] [검증 시작] 출금액: 800, 잔액: 1000 
15:41:57.496 [       t1] [검증 완료] 출금액: 800, 잔액: 1000 
15:41:57.896 [     main] t1 state : TIMED_WAITING 
15:41:57.898 [     main] t2 state : BLOCKED 
15:41:58.498 [       t1] [출금 완료] 출금액: 800, 변경 잔액: 200 
15:41:58.500 [       t1] 거래 종료 
15:41:58.501 [       t2] 거래 시작: BankAccountV2 
15:41:58.502 [       t2] [검증 시작] 출금액: 800, 잔액: 200 
15:41:58.503 [       t2] [검증 실패] 출금액: 800, 잔액: 200 
15:41:58.517 [     main] 최종 잔액 : 200 

 * */
public class BankMain2 {
	
	public static void main(String args[]) throws InterruptedException {

		BankAccount account = new BankAccountV2(1000); //x001
		
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
