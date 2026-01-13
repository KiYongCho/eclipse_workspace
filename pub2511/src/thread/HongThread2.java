package thread;

public class HongThread2 extends Thread {
	
	private Account2 hongAccount2;
	
	public HongThread2(Account2 account2) {
		this.hongAccount2 = account2;
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			
			// 공용 자원에 대해 동기화 블럭 사용 (블럭내에서는 hongAccount2객체에 대해 동기화됨)
			synchronized (hongAccount2) {
				hongAccount2.setMoney(hongAccount2.getMoney() - 500);				
			}
			
			// 공용 자원에 대해 동기화 메소드 사용 (메소드내의 모든 객체에 대해 동기화됨)
			// hongAccount2.withdraw();			
			
			System.out.println("홍길동 계좌에서 500원 출금!");
			System.out.println(hongAccount2 + "\n");
			try {
				Thread.sleep(30);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}






