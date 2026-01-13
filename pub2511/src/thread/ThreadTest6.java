package thread;

public class ThreadTest6 {
	
	public static void main(String[] args) {
		
		Thread wt1 = new WorkerThread("작업 1", 2000);
		Thread wt2 = new WorkerThread("작업 2", 3000);
		Thread wt3 = new WorkerThread("작업 3", 1000);
		
		wt1.start();
		wt2.start();
		wt3.start();
		
		try {
			wt1.join(); // wt1 쓰레드 종료될때까지 main쓰레드 기다림
			wt2.join(); // wt2 쓰레드 종료될때까지 main쓰레드 기다림
			wt3.join(); // wt3 쓰레드 종료될때까지 main쓰레드 기다림
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
	}

}





