package thread;

public class ThreadTest2 {
	
	public static void main(String[] args) {
		
		Thread et = new EvenThread();
		et.start();
		
		Thread ot = new OddThread();
		ot.start();
		
	}

}
