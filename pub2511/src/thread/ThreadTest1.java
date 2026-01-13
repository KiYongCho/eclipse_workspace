package thread;

public class ThreadTest1 {
	
	public static void main(String[] args) {
		
		// 쓰레드 객체 생성 (NEW 상태)
		Thread t = new NumberPrintThread();
		
		// 쓰레드 작업 시작 > JVM이 run()을 호출함 > (RUNNABLE 상태)
		t.start();
		
	}

}
