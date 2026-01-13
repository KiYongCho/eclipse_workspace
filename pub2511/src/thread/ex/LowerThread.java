package thread.ex;

public class LowerThread extends Thread {
	
	private ExThread2 et2;
	
	public LowerThread(ExThread2 et2) {
		this.et2 = et2;
	}	
	
	@Override
	public void run() {
		int i = 97;
		while (true) {
			synchronized (et2) {
				if (et2.flag) {
					System.out.println((char)i++);
				}
				et2.flag = false;
			}
			try {
				if(i==123) this.interrupt();
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				System.exit(0);
			}
		}
	}

}