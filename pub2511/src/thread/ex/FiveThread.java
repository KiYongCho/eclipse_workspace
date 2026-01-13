package thread.ex;

public class FiveThread extends Thread {
	
	@Override
	public void run() {
		int i = 1;
		while (true) {
			System.out.println("5의 배수" + 5*i++);
			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

}
