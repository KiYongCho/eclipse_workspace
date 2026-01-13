package thread;

public class EvenThread extends Thread {
	
	private int i = 0;
	
	@Override
	public void run() {
		while (true) {
			System.out.println("EvenThread i : " + i);
			i += 2;
			try {
				// Thread를 종료하는 가장 좋은 방법은 조건에 따라 Thread를 interrupt해서
				// InterruptedException 처리하는 것
				if (i==10) this.interrupt();
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				System.out.println("### EvenThread 종료됨!");
				System.exit(0); // 정상 종료
			}
			
		}
	}

}







