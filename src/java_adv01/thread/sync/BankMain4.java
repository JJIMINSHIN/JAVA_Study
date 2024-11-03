package java_adv01.thread.sync;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * lock.lock() 실행 결과.  => 동시성 파괴 헤결
00:51:27.715 [       t1] 거래 시작: BankAccountV4 
00:51:27.715 [       t2] 거래 시작: BankAccountV4 
00:51:27.729 [       t1] [검증 시작] 출금액: 800, 잔액: 1000 
00:51:27.729 [       t1] [검증 완료] 출금액: 800, 잔액: 1000 
00:51:28.134 [     main] t1 state : TIMED_WAITING 
00:51:28.135 [     main] t2 state : WAITING 
00:51:28.741 [       t1] [출금 완료] 출금액: 800, 변경 잔액: 200 
00:51:28.742 [       t1] 거래 종료 
00:51:28.742 [       t2] [검증 시작] 출금액: 800, 잔액: 200 
00:51:28.746 [       t2] [검증 실패] 출금액: 800, 잔액: 200 
00:51:28.765 [     main] 최종 잔액 : 200 

 * */
public class BankMain4 {
	
	public static void main(String args[]) throws InterruptedException {

		BankAccount account = new BankAccountV4(1000); //x001
		
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
