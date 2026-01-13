package thread.ex;

public class ExThread2 {
	
	boolean flag;
	
	public static void main(String[] args) {
		
		ExThread2 et2 = new ExThread2();		
		new UpperThread(et2).start();
		new LowerThread(et2).start();
		
	}

}