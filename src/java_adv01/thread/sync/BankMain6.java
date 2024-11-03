package java_adv01.thread.sync;

import static java_adv01.util.MyLogger.log;
import static java_adv01.util.ThreadUtils.*;

/*
 * tryLock 시간 설정 실행 결과. 
00:53:23.381 [       t2] 거래 시작: BankAccountV6 
00:53:23.381 [       t1] 거래 시작: BankAccountV6 
00:53:23.394 [       t2] [검증 시작] 출금액: 800, 잔액: 1000 
00:53:23.394 [       t2] [검증 완료] 출금액: 800, 잔액: 1000 
00:53:23.803 [     main] t1 state : TIMED_WAITING 
00:53:23.805 [     main] t2 state : TIMED_WAITING 
00:53:23.895 [       t1] [진입 실패] 이미 처리중인 작업이 있습니다. 
00:53:24.397 [       t2] [출금 완료] 출금액: 800, 변경 잔액: 200 
00:53:24.399 [       t2] 거래 종료 
00:53:24.416 [     main] 최종 잔액 : 200 


 * */
public class BankMain6 {
	
	public static void main(String args[]) throws InterruptedException {

		BankAccount account = new BankAccountV6(1000); //x001
		
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
