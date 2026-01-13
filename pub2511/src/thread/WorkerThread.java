package thread;

public class WorkerThread extends Thread {
	
	private String name;
	private int workTime;
	
	public WorkerThread() {
	}

	public WorkerThread(String name, int workTime) {
		super();
		this.name = name;
		this.workTime = workTime;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(name + " 시작!");
			Thread.sleep(workTime);
			System.out.println(name + " 종료!");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}














