package thread;

public class ThreadTest4 {
	
	public static void main(String[] args) {
		
		// 공용 계좌 생성
		Account2 account2 = new Account2("커플계좌", 0);
		
		// HongThread2와 KangThread2가 같은 Account2를 가지게 됨 (같은 자원을 공유)
		new HongThread2(account2).start();
		new KangThread2(account2).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		System.out.println("최종 계좌 잔액 : " + account2);
		
	}

}








