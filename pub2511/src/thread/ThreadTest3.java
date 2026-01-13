package thread;

public class ThreadTest3 {
	
	public static void main(String[] args) {
		
		// 쓰레드 동기화가 필요없는 경우
		// HongThread는 HongThread내의 Account를 사용
		// KangThread는 KangThread내의 Account를 사용
		
		new HongThread().start();
		new KangThread().start();
		
	}

}
