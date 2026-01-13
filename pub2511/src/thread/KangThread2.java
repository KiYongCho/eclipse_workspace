package thread;

public class KangThread2 extends Thread {
	
	private Account2 kangAccount2;
	
	public KangThread2(Account2 account2) {
		this.kangAccount2 = account2;
	}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			
			synchronized (kangAccount2) {
				kangAccount2.setMoney(kangAccount2.getMoney() + 500);				
			}
			
			// kangAccount2.deposit();
			
			System.out.println("강감찬 계좌에 500원 입금!");
			System.out.println(kangAccount2 + "\n");
			try {
				Thread.sleep(50);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}






