package thread.ex;

public class ExThread1 {
	
	public static void main(String[] args) {
		
		new ThreeThread().start();
		new FiveThread().start();
		
	}

}
