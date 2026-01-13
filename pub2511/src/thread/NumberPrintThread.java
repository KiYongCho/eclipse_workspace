package thread;

// Thread를 상속받아 Thread 클래스 생성
public class NumberPrintThread extends Thread {
	
	// Thread의 작업을 작업을 정의
	// start()를 호출하면 JVM이 스레드스케쥴링을 통해 run()을 호출해 줌
	@Override
	public void run() {
		
		for (int i=1; i<6; i++) {
			
			System.out.println("i => " + i);
			
			System.out.println(Thread.activeCount()); // 현재 쓰레드그룹에서 활동중인 쓰레드의 수
			System.out.println(Thread.currentThread()); // 현재 실행중인 쓰레드
			System.out.println(this.getId()); // 쓰레드 아이디
			System.out.println(this.getName()); // 쓰레드 이름
			System.out.println(this.getPriority()); // 쓰레드 우선순위 (1~10)
			System.out.println(this.getState()); // 쓰레드 상태 (Thread.State)
			System.out.println(this.getThreadGroup().getName()); // 쓰레드 그룹 이름
			System.out.println(this.isAlive()); // 쓰레드가 활동중인지 여부
			System.out.println(this.isDaemon()); // 데몬쓰레드인지 여부
			System.out.println(this.isInterrupted()); // 인터럽트 되었는지 여부
			
			System.out.println();
			
			try {
				Thread.sleep(1000); // 1000밀리초동안 현재 쓰레드의 실행을 중지
			} catch (InterruptedException ie) { // sleep에서 정한 시간내에 sleep이 방해되면 발생
				ie.printStackTrace();
			}
						
		}
		
	} // run

}











